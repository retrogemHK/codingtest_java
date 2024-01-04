import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class Solution {

    public int solution(int[] nums) {
        // ❶ nums 리스트에서 중복을 제거한 집합(set)을 구함
        HashSet<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toCollection(HashSet::new));
        // ❷ 폰켓몬의 총 수
        int n = nums.length;
        // ❸ 선택할 폰켓몬의 수
        int k = n / 2;
        // ❹ 중복을 제거한 폰켓몬의 종류 수와 선택할 폰켓몬의 수 중 작은 값 반환
        return Math.min(k, set.size());
    }

}