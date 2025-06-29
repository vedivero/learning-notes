package lang.string.method;

public class StringSplitJoinMain {
    public static void main(String[] args) {
        String str = "Apple,Banana,Orange";

        String[] splitStr = str.split(",");

        for (String string : splitStr) {
            System.out.println(string);
            //Apple
            //Banana
            //Orange
        }

        String joinStr = "";
        for (String string : splitStr) {
            joinStr += string + "-";
        }
        System.out.println("joinStr = " + joinStr); //joinStr = Apple-Banana-Orange-

        // 마지막 대시(-) 제외하고 출력하기
        String joinStr2 = "";
        for (int i = 0; i < splitStr.length; i++) {
            String string = splitStr[i];
            joinStr2 += string;
            if (i != splitStr.length - 1) {
                joinStr2 += "-";
            }
        }
        System.out.println("joinStr = " + joinStr2);

        //join 메서드로 쉽게 처리하기
        String joinedStr = String.join("-", "A", "B", "C");
        System.out.println("연결된 문자열 joinedStr : " + joinedStr);

        // 문자열 배열 연결
        String result = String.join("-", splitStr);
        System.out.println("result = " + result);
    }
}
