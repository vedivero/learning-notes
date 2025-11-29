public class Main {
    public static void main(String[] args) {
        System.out.println(solution("3x + 7 + x"));
        System.out.println(solution("x + x + x"));
        System.out.println(solution("7 + 3 + 10"));
        System.out.println(solution("x"));
        System.out.println(solution("7"));
    }

    public static String solution(String polynomial) {

        // '+'기호를 기준으로 문자열을 나눔
        String[] terms = polynomial.split(" \\+ ");

        int coefX = 0;      // x값의 합을 구하기 위한 변수
        int constant = 0;   // 상수의 합을 구하기 위한 변수

        // '+' 기호를 기준으로 나눈 문자열을 순회
        for (String term : terms) {

            // 문자열에 x가 포함되어 있을 경우를 처리
            if (term.contains("x")) {

                // x 앞에 숫자가 없는 경우, 즉 1x인 경우
                if (term.equals("x")) {
                    coefX += 1;
                // nx인 경우를 처리
                } else {
                    // 0번째 인덱스 부터 문자열 길이에서 -1을 뺀 문자를 나누면
                    // 숫자와 'x'를 분리해서 숫자를 추출할 수 있음
                    String num = term.substring(0, term.length() - 1);
                    // 반복문을 순회하며 추출된 문자열 숫자를 정수형으로 파싱
                    coefX += Integer.parseInt(num);
                }
            } else {
                // x항이 아닌 상수의 합을 처리
                // 문자열 숫자로 전달되었기 때문에 파싱처리
                constant += Integer.parseInt(term);
            }
        }

        // 정답을 작성하기 위한 StringBuilder사용
        StringBuilder sb = new StringBuilder();

        // x항이 0이 아닌 경우,
        // x항이 있는 경우를 처리
        if (coefX != 0) {

            // x가 1이면, x만 반환하면 됨
            if (coefX == 1) {
                sb.append("x");

            // x가 1 이상인 경우, 'x'문자 앞에 숫자를 붙여주기
            } else {
                sb.append(coefX).append("x");
            }
        }

        // 상수가 존재하는 경우를 처리
        if (constant != 0) {

            // x항이 작성된 경우에는 상수 앞에 ' + ' 기호를 쓰기
            if (sb.length() > 0) {
                sb.append(" + ");
            }

            // x항이 없는 경우에는 바로 상수만 추가하기
            sb.append(constant);
        }

        
        return sb.toString();
    }
}