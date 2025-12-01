public class Main {
    public static void main(String[] args) {
        System.out.println(solution("3x + 7 + x"));
        System.out.println(solution("x + x + x"));
        System.out.println(solution("7 + 3 + 10"));
        System.out.println(solution("x"));
        System.out.println(solution("7"));
    }

    public static String solution(String polynomial) {

        int xCount = 0;
        int num = 0;

        // 공백을 기준으로 문자열을 나누어서 나누어진 각 문자열에 대해 처리
        for (String s : polynomial.split(" ")) {
            // 문자열에 "x"가 포함여부로 x항을 판별
            if (s.contains("x")) {
                // 삼항식을 사용
                // x항이 "x"이면, 즉 n+x가 아닌, x이면 xCount에 1을 대입
                // n+x인 경우에는 x를 ""(빈 문자열)로 치환하여 숫자값만 대입
                xCount += s.equals("x") ? 1 : Integer.parseInt(s.replaceAll("x", ""));
            } else if (!s.equals("+")) {
                // x항과 "+" 기호가 아닌 숫자의 경우를 처리
                // 정수형으로 형 번환하여 num 변수에 더하기
                num += Integer.parseInt(s);
            }
        }

        return (xCount != 0 ? xCount > 1 ? xCount + "x" : "x" : "")
                + (num != 0 ? (xCount != 0 ? " + " : "") + num : xCount == 0 ? "0" : "");
        // (xCount != 0 ? xCount > 1 ? xCount + "x" : "x" : "")
        // x항이 0이 아닌 경우 ->
        // x항이 1보다 큰 경우 -> xCount 값에 문자열 "x"를 더해서 Nx를 표현

        // x항이 0이 아닌 경우 ->
        // x항이 1보다 작은 경우 -> x = 1임을 표현하는 x를 표현

        // =============================================
        // (num != 0 ? (xCount != 0 ? " + " : "") + num : xCount == 0 ? "0" : "")
        // num이 0이 아닌 경우 ->
        // xCount가 0이 아닌 경우 (x항이 존재하는 경우) ->
        // " + " 플러스 기호 필요

        // xCount가 0인 경우 (x항이 존재하지 않는 경우) ->
        // 빈 문자열을 반환

        // 그 숫자에 num을 더 하기

    }
}