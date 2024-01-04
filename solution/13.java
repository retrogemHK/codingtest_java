import java.util.Stack;

public class Solution {

    public int solution(int[][] board, int[] moves) {
        // ❶ 각 열에 대한 스택을 생성합니다.
        Stack<Integer>[] lanes = new Stack[board.length];
        for (int i = 0; i < lanes.length; i++) {
            lanes[i] = new Stack<>();
        }

        // ❷ board를 역순으로 탐색하며, 각 열의 인형을 lanes에 추가합니다.
        for (int i = board.length - 1; i >= 0; i--) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] > 0) {
                    lanes[j].push(board[i][j]);
                }
            }
        }

        // ❸ 인형을 담을 bucket을 생성합니다.
        Stack<Integer> bucket = new Stack<>();

        // ❹ 사라진 인형의 총 개수를 저장할 변수를 초기화합니다.
        int answer = 0;

        // ❺ moves를 순회하며, 각 열에서 인형을 뽑아 bucket에 추가합니다.
        for (int move : moves) {
            if (!lanes[move - 1].isEmpty()) { // 해당 열에 인형이 있는 경우
                int doll = lanes[move - 1].pop();
                // ❻ 바구니에 인형이 있고, 가장 위에 있는 인형과 같은 경우
                if (!bucket.isEmpty() && bucket.peek() == doll) {
                    bucket.pop();
                    answer += 2;
                }
                else { // ❼ 바구니에 인형이 없거나, 가장 위에 있는 인형과 다른 경우
                    bucket.push(doll);
                }
            }
        }

        return answer;
    }

}