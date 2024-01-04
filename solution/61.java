import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(solution(3)));
        System.out.println(Arrays.deepToString(solution(4)));
    }

    // 이 부분을 변경해서 실행해보세요.
    private static int[][] solution(int n) {
        // ❶ n 크기의 2차원 배열 생성
        int[][] snailArray = new int[n][n];

        int num = 1; // ❷ 달팽이 수열의 시작 숫자

        // ❸ 행과 열의 시작과 끝 인덱스를 설정
        int startRow = 0, endRow = n - 1;
        int startCol = 0, endCol = n - 1;

        while (startRow <= endRow && startCol <= endCol) {
            // ❹ 첫 번째 행 채우기
            for (int i = startCol; i <= endCol; i++) {
                snailArray[startRow][i] = num++;
            }
            startRow++;

            // ❺ 마지막 열 채우기
            for (int i = startRow; i <= endRow; i++) {
                snailArray[i][endCol] = num++;
            }
            endCol--;

            // ❻ 마지막 행 채우기
            if (startRow <= endRow) {
                for (int i = endCol; i >= startCol; i--) {
                    snailArray[endRow][i] = num++;
                }
                endRow--;
            }

            // ❼ 첫 번째 열 채우기
            if (startCol <= endCol) {
                for (int i = endRow; i >= startRow; i--) {
                    snailArray[i][startCol] = num++;
                }
                startCol++;
            }
        }

        return snailArray;
    }

}