// 정수 num과 k가 매개변수로 주어질 때,
// num을 이루는 숫자 중에 k가 있으면
// num의 그 숫자가 있는 자리 수를 return하고
// 없으면 -1을 return 하도록 solution 함수를 완성해보세요.

// 입출력 예
// num	    k	result
// 29183	1	3
// 232443	4	4
// 123456	7	-1

class Solution {
    public int solution(int num, int k) {
        int answer = 0;

        String strNum = String.valueOf(num);
        String strK = String.valueOf(k);
        answer = strNum.indexOf(strK);

        return (answer == -1) ? -1 : answer+1;
    }
}
// 풀이
// 매개 변수로 전달되는 두 정수형 변수의 값을 문자열로 변환
// String 클래스의 indexOf 메서드를 사용해서 strK와 동일한 문자가
// strNum 문자열의 몇 번째에 있는지를 확인
// String 클래스의 indexOf 연산 결과는 찾는 값이 없으면 -1을 반환
// answer변수에 -1이 담겨있으면 동일하게 -1을 반환
// -1아닌 검색 결과가 answer 변수에 담기면 answer변수 값에 +1을 더한 값을 반환