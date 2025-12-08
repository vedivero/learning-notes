package array.test;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {

        int[] array = new int[]{30, 20, 50, 10, 40};

        System.out.println("Arrays.toString(array) = " + Arrays.toString(array));
        System.out.println();

        int temp, idx_min = 0;
        for (int i = 0; i < array.length - 1; i++) {
            // 0번째 부터 반복문을 순회하며 차례대로 최소값을 구하기
            idx_min = i;
            for (int j = i + 1; j < array.length; j++) {
                // 0번째 인덱스와 1씩 증가하는 j번째 인덱스를 비교
                // j번째보다 0번째 인덱스가 더 큰 경우
                // = 0번째가 더 큰 수라는 의미
                if (array[idx_min] > array[j]) {
                    // 더 작은수인 j를 최고 값 변수에 대입
                    idx_min = j;
                }
                System.out.println("idx_min = " + idx_min);
            }
            
            // 최소값을 순서대로 다 구한 후,
            // i번째 값을 임시 변수에 대입
            temp = array[i];
            // i번째 순회에 해당하는 최소값을 i번째 배열에 대입
            array[i] = array[idx_min];
            // 최소값 배열 인덱스에 임시로 저장했던 더 큰 수인 값을 대입
            // array[idx_min]은 최소 값을 내주고 교횐된 값을 저장하기 위함일 뿐 
            array[idx_min] = temp;
            System.out.println("Arrays.toString(array) = " + Arrays.toString(array));
        }

    }
}
