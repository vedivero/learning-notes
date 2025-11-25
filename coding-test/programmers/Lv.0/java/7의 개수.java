class Solution {
    public int solution(int[] array) {
        int answer = 0;

        // 매개 변수로 전달된 숫자형 배열 array를 향상된 반복문으로 순회
        for (int num : array) {

            // 숫자형 데이터 num을 문자열로 형 변환
            String s = String.valueOf(num);

            for (char c : s.toCharArray()) {
                if (c == '7')
                    answer++;
            }

        }

        return answer;
    }
}