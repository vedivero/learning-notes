// 문제 설명
// 문자열 str1, str2가 매개변수로 주어집니다.
// str1 안에 str2가 있다면 1을 없다면 2를 return하도록 solution 함수를 완성해주세요.

// 입출력 예
//  str1                    	str2	    result
//  "ab6CDE443fgh22iJKlmn1o"	"6CD"	    1
//  "ppprrrogrammers"	        "pppp"	    2
//  "AbcAbcA"	                "AAA"	    2

class Solution {
    public int solution(String str1, String str2) {
        return str1.contains(str2) ? 1 : 2;
    }
}