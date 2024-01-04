import java.util.Stack;

class Solution {

    public static int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n]; // ❶ 가격이 떨어지지 않은 기간을 저장할 배열

        // 스택(stack)을 사용해 이전 가격과 현재 가격 비교
        Stack<Integer> stack = new Stack<>(); // ❷ 스택 생성
        stack.push(0);

        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                // ❸ 가격이 떨어졌으므로 이전 가격의 기간 계산
                int j = stack.pop();
                answer[j] = i - j;
            }
            stack.push(i);
        }

        // ❹ 스택에 남아 있는 가격들은 가격이 떨어지지 않은 경우
        while (!stack.isEmpty()) {
            int j = stack.pop();
            answer[j] = n - 1 - j;
        }

        return answer;
    }

}