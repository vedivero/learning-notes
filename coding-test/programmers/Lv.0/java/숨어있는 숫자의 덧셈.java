public class Main {
    public static void main(String[] args) {
        System.out.println(solution("aAb1B2cC34oOp"));
    }

    // 문자열을 하나씩 나누어서 처리
    public static int solution(String my_string) {

        int sum = 0;    // 숫자의 합을 더할 변수
        int current = 0;    // 반복문을 순회하면서 임시로 담아둘 변수

        for (int i = 0; i < my_string.length(); i++) {

            // 매개 변수로 전달 받은 문자열을 0번 인덱스부터 문자 타입으로 변환
            char c = my_string.charAt(i);

            // 문자 데이터가 '0' ~ '9'사이에 존재하는지 검증
            // 숫자형 문자 값은 유니코드로 되어 있기 때문에 비교 가능
            if ('0' <= c && c <= '9') {
                // 만약 숫자형 문자 범위에 해당 되는 값이라면
                // 현재의 current값에 10을 곱하고
                // 문자에서 '0'(48)을 빼서 정수 값을 구함
                current = (current * 10) + (c - '0');
            } else {
                // 숫자형 문자가 아니라 문자라면,
                // 이전 반복문까지 처리한 숫자가 하나의 숫자가
                // 되기 때문에 그 합을 sum 변수에 대입
                sum += current;

                // 다음 숫자 처리를 위해 current값을 0으로 초기화
                current = 0;
            }

        }

        // 전달되는 매개 변수의 마지막 인덱스가 숫자형 문자인 경우
        // 반복문 안에서의 sum += current를 실행하지 못하므로
        // 마무리로 로직 추가해놓기
        sum += current;

        return sum;
    }
}