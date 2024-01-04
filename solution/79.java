import java.util.Arrays;

public class Solution {

    public int solution(int[] d, int budget) {
        Arrays.sort(d); // ❶ 배열 d를 오름차순으로 정렬
        int count = 0; // ❷ 지원할 수 있는 부서의 개수를 세는 변수

        for (int amount : d) {
            if (budget < amount) {
                break; // ❸ 남은 예산이 신청한 금액보다 작으면 더 이상 지원할 수 없으므로 종료
            }
            budget -= amount; // ❹ 예산에서 신청한 금액을 차감
            count++;
        }

        return budget >= 0 ? count : count - 1;
    }

}