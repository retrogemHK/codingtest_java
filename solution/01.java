import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        int[] arr = new int[100000];

        long start = System.currentTimeMillis();
        int[] bubble = bubbleSort(arr);
        long end = System.currentTimeMillis();

        // Bubble 정렬 코드 시간 측정
        // 1.008 초
        System.out.println((end - start) / 1000.0 + " 초");

        start = System.currentTimeMillis();
        int[] sort = doSort(arr);
        end = System.currentTimeMillis();

        // 정렬 API 코드 시간 측정
        // 0.001 초
        System.out.println((end - start) / 1000.0 + " 초");

        // 두 개의 배열이 같은지 확인
        System.out.println(Arrays.equals(bubble, sort));    // true
    }

    private static int[] bubbleSort(int[] org) {
        int[] arr = org.clone();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        return arr;
    }

    private static int[] doSort(int[] org) {
        int[] arr = org.clone();
        Arrays.sort(arr);
        return arr;
    }

}