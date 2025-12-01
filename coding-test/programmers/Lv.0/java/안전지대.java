import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] array = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0}
        };

        System.out.println(solution(array));
    }

    public static int solution(int[][] board) {

        // 배열의 길이를 저장
        int n = board.length;

        // 위험한 위치를 표시할 2차원 배열을 배열의 길이만큼 설정
        // 2차원 배열의 범위는 배열의 길이를 벗어나지 않는 다는 전제 조건
        int[][] danger = new int[n][n];

        // 2차워 배열이기 때문에 이중 반복문을 사용
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // i번재 행과 j번째 열에서 정수 1을 발견 -> 지뢰 발견
                if (board[i][j] == 1) {
                    // 지뢰 기준 인접한 모든 면이 위험한 지역
                    // 좌,우,밑,위,각 대각선
                    // 행을 기준으로 이중 반복문을 사용
                    // 지뢰 기준 앞,뒤의 값만 접근하면 됨
                    for (int x = i - 1; x <= i + 1; x++) {
                        // 마찬가지로 지뢰 기준으로 위, 아래 값만 접근
                        for (int y = j - 1; y <= j + 1; y++) {
                            // 지뢰가 모서리 끝에 있는 경우의 예외 처리
                            // 배열의 범위를 벗어나는 예외가 발생하기 때문
                            // 유효 범위 = 0 ~ n-1
                            if (x < 0 || y < 0 || x >= n || y >= n) {
                                continue;
                            }
                            // 범위가 유효하다면 해당 위험 지역의 값을 1로 대입
                            danger[x][y] = 1;
                        }
                    }
                }
            }
        }

        // 안전 지대를 계수할 변수 선언
        int answer = 0;
        // 2차원 배열을 읽기 위한 이중 반복문
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 
                if (danger[i][j] == 0 && board[i][j] == 0) {
                    answer++;
                }
            }
        }

        return answer;
    }
}