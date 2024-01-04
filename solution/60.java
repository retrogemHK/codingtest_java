import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[][] matrix1_1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] matrix2_1 = {
                {9, 8, 7},
                {6, 5, 4},
                {3, 2, 1}
        };
        System.out.println(Arrays.deepToString(solution(matrix1_1, matrix2_1)));

        int[][] matrix1_2 = {
                {2, 4, 6},
                {1, 3, 5},
                {7, 8, 9}
        };
        int[][] matrix2_2 = {
                {9, 1, 2},
                {4, 5, 6},
                {7, 3, 8}
        };
        System.out.println(Arrays.deepToString(solution(matrix1_2, matrix2_2)));
    }

    private static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        // ❶ 결과 행렬을 0으로 초기화합니다.
        int[][] result = new int[3][3];

        // ❷ 행렬 곱셈을 수행합니다.
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return result;
    }

    private static int[][] transposeMatrix(int[][] matrix) {
        // ❸ 결과 행렬을 0으로 초기화합니다.
        int[][] result = new int[3][3];

        // 전치 행렬을 계산합니다.
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result[j][i] = matrix[i][j];
            }
        }

        return result;
    }

    // 이 부분을 변경해서 실행해보세요.
    private static int[][] solution(int[][] matrix1, int[][] matrix2) {
        // 주어진 두 행렬을 곱합니다.
        int[][] multiplied = multiplyMatrices(matrix1, matrix2);

        // 곱셈 결과의 전치 행렬을 계산합니다.
        int[][] transposed = transposeMatrix(multiplied);

        return transposed;
    }

}