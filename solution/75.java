public class Solution {

    public int solution(int [][]board) {
        // ❶ 주어진 2차원 보드의 행과 열의 개수를 변수에 저장합니다.
        int row = board.length;
        int col = board[0].length;

        // ❷ 각 행과 열을 순회하며 최적의 정사각형을 찾습니다.
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                // ❸ 현재 위치의 값이 1인 경우를 확인합니다.
                if (board[i][j] == 1) {
                    // ❹ 현재 위치에서 위, 왼쪽, 대각선 왼쪽 위의 값들을 가져옵니다.
                    int up = board[i - 1][j];
                    int left = board[i][j - 1];
                    int upLeft = board[i - 1][j - 1];
                    // ❺ 현재 위치의 값을 이전 위치들의 값들 중
                    // 가장 작은 값에 1을 더한 값으로 업데이트 합니다.
                    board[i][j] += Math.min(up, Math.min(upLeft, left));
                }
            }
        }

        int answer = 0;
        // ❻ 보드에서 가장 큰 값(최대 정사각형의 한 변의 길이)을 찾습니다.
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                answer = Math.max(answer, board[i][j]);
            }
        }

        // ❼ 최대 정사각형의 넓이를 반환합니다.
        return answer * answer;
    }

}