import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Solution {

    public int solution(int k, int[] tangerine) {
        // ❶ 귤의 개수를 세는 HashMap 객체 생성
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : tangerine) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        // ❷ 개수를 내림차순으로 정렬
        ArrayList<Integer> sortedCounts = new ArrayList<>(map.values());
        sortedCounts.sort(Collections.reverseOrder());

        int numTypes = 0; // ❸ 현재까지의 종류 수
        int countSum = 0; // ❹ 현재까지의 귤 개수 합

        for (int count : sortedCounts) {
            countSum += count;
            numTypes++;

            // ❺ 귤 개수 합이 k 이상이 되는 순간 종료
            if (countSum >= k)
                break;
        }

        return numTypes;
    }

}