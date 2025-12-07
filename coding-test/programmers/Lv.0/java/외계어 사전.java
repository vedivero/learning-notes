public public class Main {
    public static void main(String[] args) {

        // String[] spell = {"p", "o", "s"};
        // String[] dic = {"sod", "eocd", "qixm", "adio", "soo"};

        String[] spell = { "z", "d", "x" };
        String[] dic = { "def", "dww", "dzx", "loveaw" };

        System.out.println(solution(spell, dic));
    }

    public static int solution(String[] spell, String[] dic) {

        // spell의 문자열이 모두 일치하는 경우를 확인해야 하므로
        // spell의 길이와 외계어 사전에서 일치하는 개수를 비교하면 됨
        int length = spell.length;

        // 외계어 사전을 반복문을 사용하여 순회
        for (String d : dic) {

            // 일치하는 문자를 세는 변수
            int count = 0;

            // 스펠 문자열 배열을 순회
            for (String s : spell) {
                // 외계어 사전에 스펠링이 있는지를 contains로 체크
                if (d.contains(s)) {
                    // 존재하면 count값을 1 증가
                    count++;
                }
            }

            // spell의 길이와 count의 값이 동일하다는 것은
            // spell의 모든 문자열이 외계어 사전의 요소와 일치하다는 뜻
            if (length == count)
                // spell의 값을 외계어 사전에서 모두 존재하므로 1을 반환
                return 1;

        }

        // 그렇지 않은 경우 2를 반환
        return 2;

    }
}
