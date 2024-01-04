public class Solution {

    public int solution(int[][] triangle) {
        int n = triangle.length;
        int[][] dp = new int[n][n]; // ❶ dp 배열 초기화

        // ❷ dp 배열의 맨 아래쪽 라인 초기화
        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = triangle[n - 1][i];
        }

        // ❸ 아래쪽 라인부터 올라가면서 dp 배열 채우기
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.max(dp[i + 1][j], dp[i + 1][j + 1]) + triangle[i][j];
            }
        }

        return dp[0][0]; // 꼭대기에서의 최댓값 반환
    }

}