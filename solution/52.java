import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 3, 5}, new int[]{2, 4, 6})));
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3}, new int[]{4, 5, 6})));
    }

    // 이 부분을 변경해서 실행해보세요.
    private static int[] solution(int[] arr1, int[] arr2) {
        // 정렬된 배열을 저장할 배열 생성
        int[] merged = new int[arr1.length + arr2.length];
        int k = 0, i = 0, j = 0; // 3개 배열의 인덱스 초기화

        // 두 배열을 순회하면서 정렬된 배열을 생성
        while (i < arr1.length && j < arr2.length) {
            merged[k++] = arr1[i] <= arr2[j] ? arr1[i++] : arr2[j++];
        }

        // arr1 이나 arr2 중 남아 있는 원소들을 정렬된 배열 뒤에 추가
        while (i < arr1.length) {
            merged[k++] =  arr1[i++];
        }
        while (j < arr2.length) {
            merged[k++] =  arr2[j++];
        }

        return merged;
    }

}