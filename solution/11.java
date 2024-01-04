import java.util.Stack;

public class Solution {

    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // ❶ 스택이 비어 있지 않고, 현재 문자와 스택의 맨 위 문자가 같으면
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop(); // ❷ 스택의 맨 위 문자 제거
            }
            else {
                stack.push(c); // ❸ 스택에 현재 문자 추가
            }
        }

        return stack.isEmpty() ? 1 : 0; // ❹ 스택이 비어 있으면 1, 그렇지 않으면 0 반환
    }

}