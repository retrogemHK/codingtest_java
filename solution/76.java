import java.util.Arrays;
import java.util.HashSet;

public class Solution {

    private static final int INF = 20_001;

    public int solution(String[] strs, String t) {
        int n = t.length(); // ❶ 타겟 문자열 t의 길이
        // ❷ 각 위치에서 필요한 최소 조각수를 저장할 배열(초기값은 INF로 함)
        int[] dp = new int[n + 1];
        Arrays.fill(dp, INF);
        // ❸ 빈 문자열을 위해 필요한 최소 조각수는 0
        dp[0] = 0;

        // ❹ strs 조각들의 길이를 저장한 해시셋
        HashSet<Integer> sizes = new HashSet<>();
        for (String str : strs) {
            sizes.add(str.length());
        }

        // ❺ dp[i]부터 dp[n]까지 채우기 위한 반복문
        for (int i = 1; i <= n; i++) {
            // ❻ 각 str 조각의 문자열 길이에 대하여
            for (int size : sizes) {
                if (i - size >= 0) {
                    int idx = i;
                    String sub = t.substring(idx - size, idx);
                    // ❼ 이미 구한 해와 strs 조각을 추가해서 문자열을 만들 수 있다면
                    if (Arrays.asList(strs).contains(sub)) {
                        // ❽ 해당 위치의 최소 조각수를 갱신
                        dp[i] = Math.min(dp[i], dp[i - size] + 1);
                    }
                }
            }
        }

        // ❾ 최소 조각수를 반환
        return dp[n] < INF ? dp[n] : -1;
    }

}