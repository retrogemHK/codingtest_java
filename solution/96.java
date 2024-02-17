class Solution {

    public static void main(String[] args) {
        int[][] board2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] skill2 = {{1, 1, 1, 2, 2, 4}, {1, 0, 0, 1, 1, 2}, {2, 2, 0, 2, 0, 100}};
        System.out.println(solution(board2, skill2));
    }

    public static int solution(int[][] board, int[][] skill) {
        int[][] sum = new int[board.length + 1][board[0].length + 1];

        for (int[] s : skill) {
            int degree = s[5] * (s[0] == 1 ? -1 : 1);
            sum[s[1]][s[2]] += degree;
            sum[s[3] + 1][s[4] + 1] += degree;
            sum[s[1]][s[4] + 1] -= degree;
            sum[s[3] + 1][s[2]] -= degree;
        }

        for (int i = 0; i < sum.length; i++) {
            for (int j = 1; j < sum[0].length; j++) {
                sum[i][j] += sum[i][j - 1];
            }
        }

        for (int i = 1; i < sum.length; i++) {
            for (int j = 0; j < sum[0].length; j++) {
                sum[i][j] += sum[i - 1][j];
            }
        }

        int answer = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] + sum[i][j] > 0)
                    answer++;
            }
        }

        return answer;
    }

}