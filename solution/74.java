public class Solution {

    public int solution(int[] money) {
        // ❶ 점화식에 필요한 변수를 초기화
        int n = money.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        // ❷ 첫 번째 집을 도둑질하는 경우
        dp1[0] = money[0];
        dp1[1] = money[0];
        for (int i = 2; i < n - 1; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + money[i]);
        }

        // ❸ 첫 번째 집을 도둑질하지 않는 경우
        dp2[1] = money[1];
        for (int i = 2; i < n; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + money[i]);
        }

        // ❹ 두 경우 중 최댓값 찾기
        return Math.max(dp1[n - 2], dp2[n - 1]);
    }

}