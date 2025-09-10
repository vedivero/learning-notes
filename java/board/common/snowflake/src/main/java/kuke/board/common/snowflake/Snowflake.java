package kuke.board.common.snowflake;

import java.util.random.RandomGenerator;

public class Snowflake {
	private static final int UNUSED_BITS = 1;
	private static final int EPOCH_BITS = 41;		//41 bit로 순차성 보장
	private static final int NODE_ID_BITS = 10;		// 동일한 시간 내에서도 unique를 보장 -> 이걸 사용해서 key 생성
	private static final int SEQUENCE_BITS = 12;	// 동일한 시간 내에서도 unique를 보장 -> 이걸 사용해서 key 생성

	private static final long maxNodeId = (1L << NODE_ID_BITS) - 1;
	private static final long maxSequence = (1L << SEQUENCE_BITS) - 1;

	private final long nodeId = RandomGenerator.getDefault().nextLong(maxNodeId + 1);
	// UTC = 2024-01-01T00:00:00Z
	private final long startTimeMillis = 1704067200000L;

	private long lastTimeMillis = startTimeMillis;
	private long sequence = 0L;

	public synchronized long nextId() {
		long currentTimeMillis = System.currentTimeMillis();

		if (currentTimeMillis < lastTimeMillis) {
			throw new IllegalStateException("Invalid Time");
		}

		if (currentTimeMillis == lastTimeMillis) {
			sequence = (sequence + 1) & maxSequence;
			if (sequence == 0) {
				currentTimeMillis = waitNextMillis(currentTimeMillis);
			}
		} else {
			sequence = 0;
		}

		lastTimeMillis = currentTimeMillis;

		// 조합해서 하나의 ID 생성
		// 핵심 : 분산 시스템에서도 빠르게 유니크한 오름차순 ID 생성 알고리즘을 만드는 것
		return ((currentTimeMillis - startTimeMillis) << (NODE_ID_BITS + SEQUENCE_BITS))
			| (nodeId << SEQUENCE_BITS)
			| sequence;
	}

	private long waitNextMillis(long currentTimestamp) {
		while (currentTimestamp <= lastTimeMillis) {
			currentTimestamp = System.currentTimeMillis();
		}
		return currentTimestamp;
	}
}
