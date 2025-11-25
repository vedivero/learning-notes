class Solution {
    public int solution(int[] array) {
        int answer = 0;

        // 매개 변수로 전달된 숫자형 배열 array를 향상된 반복문으로 순회
        for (int num : array) {

            // 숫자형 데이터 num을 문자열로 형 변환
            String s = String.valueOf(num);

            // 문자열의 각 문자를 순회
            for (char c : s.toCharArray()) {
                // 문자가 문자 7과 일치하는지 체크
                if (c == '7')
                    // 일치할 경우, answer의 값을 1 증가
                    answer++;
            }

        }

        return answer;
    }
}