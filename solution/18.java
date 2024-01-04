import java.util.HashSet;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 4, 8}, 6));
        System.out.println(solution(new int[]{2, 3, 5, 9}, 10));
    }

    // 이 부분을 변경해서 실행해보세요.
    private static boolean solution(int[] arr, int target) {
        HashSet<Integer> hashSet = new HashSet<>();

        for (int i : arr) {
            // ❶ target에서 현재 원소를 뺀 값이 hashSet에 있는지 확인
            if (hashSet.contains(target - i)) {
                return true;
            }

            // ❷ hashSet에 현재 값 저장
            hashSet.add(i);
        }

        return false;
    }

}