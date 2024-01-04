public class Solution {

    public int solution(int n) {
        // ❶ 동적 계획법을 위한 배열 초기화
        // dp[i]는 가로 길이가 i일 때 바닥을 채우는 방법의 수
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        // ❷ 가로 길이가 3부터 n까지의 각각의 경우에 대해 바닥을 채우는 방법의 수를 구함
        for (int i = 3; i <= n; i++) {
            // ❸ dp[i]는 dp[i - 1]과 dp[i - 2]를 더한 값
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1_000_000_007;
        }
        // ❹ 바닥의 가로 길이가 n일 때 바닥을 채우는 바업의 수인 dp[n]을 반환
        return dp[n];
    }

}