import java.util.ArrayDeque;

public class Solution {

    private static class Node {
        int x, y, direction, cost;

        public Node(int x, int y, int direction, int cost) {
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.cost = cost;
        }
    }

    // 순서가 반드시 (0, -1), (-1, 0), (0, 1), (1, 0) 순서로 되어야합니다. 코너 계산에 필요함
    private static final int[] rx = {0, -1, 0, 1};
    private static final int[] ry = {-1, 0, 1, 0};

    private static int N;
    private static int[][][] visited;

    // ❶ 주어진 좌표가 보드의 범위 내에 있는지 확인
    private static boolean isValid(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    // ❷ 주어진 좌표가 차단되었거나 이동할 수 없는지 확인
    private static boolean isBlocked(int[][] board, int x, int y) {
        return (x == 0 && y == 0) || !isValid(x, y) || board[x][y] == 1;
    }

    // ❸ 이전 방향과 현재 방향에 따라 비용 계산
    private static int calculateCost(int direction, int prevDirection, int cost) {
        if (prevDirection == -1 || (prevDirection - direction) % 2 == 0)
            return cost + 100;
        return cost + 600;
    }

    // ❹ 주어진 좌표와 방향이 아직 방문하지 않았거나 새 비용이 더 작은 경우
    private static boolean isShouldUpdate(int x, int y, int direction, int newCost) {
        return visited[x][y][direction] == 0 || visited[x][y][direction] > newCost;
    }

    public int solution(int[][] board) {
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0, 0, -1, 0));
        N = board.length;
        visited = new int[N][N][4];

        int answer = Integer.MAX_VALUE;

        // ❺ 큐가 빌 때까지 반복
        while (!queue.isEmpty()) {
            Node now = queue.poll();

            // ❻ 가능한 모든 방향에 대해 반복
            for (int i = 0; i < 4; i++) {
                int new_x = now.x + rx[i];
                int new_y = now.y + ry[i];

                // ❼ 이동할 수 없는 좌표는 건너뛰기
                if (isBlocked(board, new_x, new_y)) {
                    continue;
                }

                int new_cost = calculateCost(i, now.direction, now.cost);

                // ❽ 도착지에 도달한 경우 최소 비용 업데이트
                if (new_x == N - 1 && new_y == N - 1) {
                    answer = Math.min(answer, new_cost);
                }
                // ❾ 좌표와 방향이 아직 방문하지 않았거나 새 비용이 더 작은 경우 큐에 추가
                else if(isShouldUpdate(new_x, new_y, i, new_cost)) {
                    queue.add(new Node(new_x, new_y, i, new_cost));
                    visited[new_x][new_y][i] = new_cost;
                }
            }
        }

        return answer;
    }

}