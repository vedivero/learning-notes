class Solution {
    public int[] solution(String[] keyinput, int[] board) {

        // 최종 좌표를 누적하여 계산할 변수 선언        
        int x = 0;
        int y = 0;

        // 중심 값은 항상 [0,0]이기 때문에
        // 매개 변수로 전달 받은 값을 2로 나누어
        // 최소 값 ~ 최대 값의 범위를 설정
        int range_x = board[0] / 2;
        int range_y = board[1] / 2;

        // 반복물을 순회하며, 입력된 키를 순차적으로 처리
        for (String key : keyinput) {

            // 전역 변수의 값을 반복문을 돌 때 마다 초기화하여
            // 이전 반복문에서 계산한 좌표 값을 가져오기
            int current_x = x;
            int current_y = y;

            switch (key) {
                case "left":
                    current_x -= 1;
                    break;
                case "right":
                    current_x += 1;
                    break;
                case "up":
                    current_y += 1;
                    break;
                case "down":
                    current_y -= 1;
                    break;

            }

            // 현재 위치가 범위를 벗어나지 않는지 체크
            if (Math.abs(current_x) <= range_x && Math.abs(current_y) <= range_y) {
                x = current_x;
                y = current_y;
            }

        }

        return new int[]{x, y};
    }
}