import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        System.out.println(lis(new int[]{1, 4, 2, 3, 1, 5, 7, 3}));
        System.out.println(lis(new int[]{3, 2, 1}));
    }

    // 이 부분을 변경해서 실행해보세요.
    private static int lis(int[] nums) {
        int n = nums.length;

        // ❶ dp[i]는 nums[i]를 마지막으로 하는 LIS의 길이를 저장하는 배열입니다.
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // ❷ num[i]와 nums[j]를 비교하여, nums[i]가 더 큰 경우에만 처리합니다.
                if (nums[i] > nums[j]) {
                    // ❸ nums[i]를 이용하여 만든 부분 수열의 길이와
                    // nums[j]를 이용하여 만든 부분 수열의 길이 + 1 중 최댓값을 저장합니다.
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // ❹ dp 배열에서 최댓값을 찾아 최장 증가 부분 수열의 길이를 반환합니다.
        return Arrays.stream(dp).max().getAsInt();
    }

}