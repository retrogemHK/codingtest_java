import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solution(10));
        System.out.println(solution(27));
        System.out.println(solution(12345));
    }

    public static String solution(int decimal) {
        // 이 부분을 변경해서 실행해보세요.
        Stack<Integer> stack = new Stack<>();
        while (decimal > 0) {
            int remainder = decimal % 2;
            stack.push(remainder);
            decimal /= 2;
        }

        // String 의 + 연산은 시간복잡도 측면에서 성능이 좋지 않습니다.
        // 따라서 StringBuilder 를 사용했습니다.
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }

}