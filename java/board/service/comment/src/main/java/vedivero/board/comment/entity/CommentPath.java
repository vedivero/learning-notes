package vedivero.board.comment.entity;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommentPath {
    private String path;

    private static final String CHARSET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefgjhjklmnopqrstuvwxyz";
    
    // 경로 1 depth 당, 5개 문자를 나타내는 사이즈
    private static final int DEPTH_CHUNK_SIZE = 5;
    private static final int MAX_DEPTH = 5;

    private static final String MIN_CHUNK = String.valueOf(CHARSET.charAt(0)).repeat(DEPTH_CHUNK_SIZE);
    private static final String MAX_CHUNK = String.valueOf(CHARSET.charAt(CHARSET.length() - 1)).repeat(DEPTH_CHUNK_SIZE);

    public static CommentPath create(String path) {
        // 5 depth까지만 생성 가능, 오버플로우 방지
        if (isDepthOverflowed(path)) {
            throw new IllegalStateException("Depth Overflowed");
        }
        CommentPath commentPath = new CommentPath();
        commentPath.path = path;
        return commentPath;
    }

    private static boolean isDepthOverflowed(String path) {
        return calDepth(path) > MAX_DEPTH;
    }

    private static int calDepth(String path) {
        return path.length() / DEPTH_CHUNK_SIZE;
    }

    public int getDepth() {
        return calDepth(path);
    }

    public boolean isRoot() {
        return calDepth(path) == 1;
    }

    public String getParentPath() {
        return path.substring(0, path.length() - DEPTH_CHUNK_SIZE);
    }

    public CommentPath createChildCommentPath(String descendantsTopPath) {
        // descendantsTopPath == null -> 하위 댓글이 처음 생성되는 것
        if (descendantsTopPath == null) {
            // 상위 댓글의 경로 상속 + MIN_CHUNK (00000)
            return CommentPath.create(path + MIN_CHUNK);
        }
        String childrenTopPath = findChildrenTopPath(descendantsTopPath);
        return CommentPath.create(increase(childrenTopPath));
    }

    private String findChildrenTopPath(String descendantsTopPath) {
        // descendantsTopPath (0000 AAAAA aaaaa)는 findChildrenTopPath (0000 AAAAA)를 포함
        return descendantsTopPath.substring(0, (getDepth() + 1) * DEPTH_CHUNK_SIZE);
    }

    private String increase(String path) {
        // 00000 00000 -> 00000 00000 + 1 -> 00000 00001
        String lastChunk = path.substring(path.length() - DEPTH_CHUNK_SIZE);

        if (isChunkOverflowed(lastChunk)) {
            throw new IllegalStateException("Chunk OverFlowed");
        }

        int charsetLength = CHARSET.length();
        int value = 0; // lastChunk를 10진수로 변환하기 위한 값
        for (char ch : lastChunk.toCharArray()) {
            value = value * charsetLength + CHARSET.indexOf(ch);
        }

        value = value + 1;
        String result = "";
        for (int i = 0; i < DEPTH_CHUNK_SIZE; i++) {
            result = CHARSET.charAt(value % charsetLength) + result;
            value /= charsetLength;
        }

        return path.substring(0, path.length() - DEPTH_CHUNK_SIZE) + result;
    }

    private boolean isChunkOverflowed(String lastChunk) {
        return MAX_CHUNK.equals(lastChunk);
    }
}
