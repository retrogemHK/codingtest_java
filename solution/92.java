class Solution {

    public static void main(String[] args) {
        System.out.println(solution(10, 10, new int[][]{{10,15,2,1,2},{20,20,3,3,4}}));
    }

    public static int solution(int alp, int cop, int[][] problems) {
        int maxAlp = 0;
        int maxCop = 0;

        for (int[] problem : problems) {
            maxAlp = Math.max(maxAlp, problem[0]);
            maxCop = Math.max(maxCop, problem[1]);
        }

        int[][] dp = new int[maxAlp + 2][maxCop + 2];

        for (int i = 0; i <= maxAlp; i++) {
            for (int j = 0; j <= maxCop; j++) {
                dp[i][j] = Math.max(i - alp, 0) + Math.max(j - cop, 0);
            }
        }

        for (int i = 0; i <= maxAlp; i++) {
            for (int j = 0; j <= maxCop; j++) {
                for (int[] problem : problems) {
                    if (problem[0] > i || problem[1] > j)
                        continue;
                    int x = Math.min(i + problem[2], maxAlp);
                    int y = Math.min(j + problem[3], maxCop);
                    dp[x][y] = Math.min(dp[x][y], dp[i][j] + problem[4]);
                }

                dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1);
                dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1);
            }
        }

        return dp[maxAlp][maxCop];
    }

}