class Solution {
    public int solution(int[] array) {
        int answer = 0;

        for (int num : array) {

            String s = String.valueOf(num);

            for (char c : s.toCharArray()) {
                if (c == '7')
                    answer++;
            }

        }

        return answer;
    }
}