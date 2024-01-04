import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[][] arr1 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int n1 = 1;
        System.out.println(Arrays.deepToString(solution(arr1, n1)));
        int[][] arr2 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int n2 = 2;
        System.out.println(Arrays.deepToString(solution(arr2, n2)));
    }

    // ❶ 2차원 배열을 인자로 받고, 90도 회전시키는 메소드
    private static int[][] rotate90(int[][] arr) {
        // ❷ 배열의 크기 저장
        int n = arr.length;

        // ❸ 배열의 크기와 동일한 2차원 배열 생성(초기값은 0)
        int[][] rotatedArr = new int[n][n];

        // ❹ 배열을 90도 회전
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotatedArr[j][n - i - 1] = arr[i][j];
            }
        }

        // ❺ 90도로 회전한 배열 반환
        return rotatedArr;
    }

    // 이 부분을 변경해서 실행해보세요.
    private static int[][] solution(int[][] arr, int n) {
        // ❻ 90도 회전 메소드 호출
        for (int i = 0; i < n; i++) {
            arr = rotate90(arr);
        }
        return arr;
    }

}