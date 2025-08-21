// 문제 설명
// 문자열 s가 매개변수로 주어집니다.
// s에서 한 번만 등장하는 문자를 사전 순으로
// 정렬한 문자열을 return 하도록 solution 함수를 완성해보세요.
// 한 번만 등장하는 문자가 없을 경우 빈 문자열을 return 합니다.

// 입출력 예
// s	        result
// "abcabcadc"	"d"
// "abdc"	    "abcd"
// "hello"	    "eho"
import java.util.*;

class Solution {
    public String solution(String s) {
        HashMap<String,Integer> hashMap = new HashMap<>();
        String[] strArr = s.split("");

        for (String st : strArr) {
            hashMap.put(st, hashMap.getOrDefault(st,0)+1);
        }

        List<String> list = new ArrayList();
        for(Map.Entry<String,Integer> entry : hashMap.entrySet()){
            if(entry.getValue() == 1){
                list.add(entry.getKey());
            }
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();

        for(String text : list){
            sb.append(text);
        }

        return sb.toString();
    }
}