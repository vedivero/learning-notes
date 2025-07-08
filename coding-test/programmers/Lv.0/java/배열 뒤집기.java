//정수가 들어 있는 배열 num_list가 매개변수로 주어집니다.
//num_list의 원소의 순서를 거꾸로 뒤집은 배열을 return하도록 solution 함수를 완성해주세요.
class Solution {
    public int[] solution(int[] num_list) {
        int size = num_list.length;
        int[] new_array = new int[size];

        for (int i = 0; i < size; i++) {
            new_array[i] = num_list[size - 1 - i];
        }

        return new_array;
    }
}
//배열의 요소를 반전시키는 문제
//매개 변수로 주어진 배열과 동일한 길이의 새로운 배열을 생성
//반복문을 통해 새로운 배열에 주어진 배열의 마지막 인덱스부터 순차적으로 대입