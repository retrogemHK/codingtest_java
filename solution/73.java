import java.util.Arrays;

public class Solution {

    int solution(int[][] land) {
        // ❶ 각 행마다 이전 행에서의 최대 점수를 더해가며 최대 점수를 구합니다.
        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < 4; j++) {
                // ❷ 이전 행에서 현재 열의 값을 제외한 나머지 열들 중에서 가장 큰 값을 더해줍니다.
                int max = 0;
                for (int k = 0; k < 4; k++) {
                    if (j != k) max = Math.max(max, land[i - 1][k]);
                }
                land[i][j] += max;
            }
        }

        return Arrays.stream(land[land.length - 1]).max().getAsInt();
    }

}