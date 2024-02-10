import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"1110","100111100","0111111010"})));
        System.out.println(Arrays.toString(solution(new String[]{"1011110","01110","101101111010"})));
        System.out.println(Arrays.toString(solution(new String[]{"1100111011101001"})));
    }

    public static String[] solution(String[] s) {
        String[] answer = new String[s.length];

        for (int i = 0; i < s.length; i++) {
            StringBuilder start = new StringBuilder();
            ArrayDeque<Character> stack = new ArrayDeque<>();
            char[] end = s[i].toCharArray();

            for (char c : end) {
                stack.push(c);
                if (stack.size() >= 3) {
                    char s3 = stack.pop();
                    char s2 = stack.pop();
                    char s1 = stack.pop();
                    if (("" + s1 + s2 + s3).equals("110")) {
                        start.append("110");
                    }
                    else {
                        stack.push(s1);
                        stack.push(s2);
                        stack.push(s3);
                    }
                }
            }

            StringBuilder ans = new StringBuilder();
            while (!stack.isEmpty()) {
                ans.append(stack.pollLast());
            }

            if (ans.indexOf("11") >= 0) {
                ans.insert(ans.indexOf("11"), start);
            }
            else if (ans.lastIndexOf("0") >= 0) {
                ans.insert(ans.lastIndexOf("0") + 1, start);
            }
            else {
                ans.insert(0, start);
            }

            answer[i] = ans.toString();
        }

        return answer;
    }

}