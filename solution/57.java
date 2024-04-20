import java.util.PriorityQueue;

public class Solution {

    private static class Node {
        int i, j, cost;

        public Node(int i, int j, int cost) {
            this.i = i;
            this.j = j;
            this.cost = cost;
        }
    }

    public int solution(int[][] land, int height) {
        int answer = 0;
        int n = land.length;

        // ❶ 주변 노드 탐색을 위한 di, dj
        int[] di = {-1, 0, 1, 0};
        int[] dj = {0, 1, 0, -1};

        boolean[][] visited = new boolean[n][n];

        // ❷ 시작 노드 추가
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        pq.add(new Node(0, 0, 0));

        // ❸ BFS + 우선순위 큐로 다음 노드 관리
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            // ❹ 아직 방문하지 않은 경로만 탐색
            if (visited[now.i][now.j])
                continue;

            visited[now.i][now.j] = true;
            // ❺ 현재까지 비용을 합산
            answer += now.cost;

            for (int i = 0; i < 4; i++) {
                int ni = now.i + di[i];
                int nj = now.j + dj[i];

                // ❻ 유효한 인덱스가 아닐 경우
                if (!(0 <= ni && ni < n && 0 <= nj && nj < n))
                    continue;

                int tempCost = Math.abs(land[now.i][now.j] - land[ni][nj]);
                // ❼ 입력으로 주어진 height 보다 높이차가 큰 경우
                int newCost = tempCost > height ? tempCost : 0;
                // ❽ 다음 경로를 add
                pq.add(new Node(ni, nj, newCost));
            }
        }

        return answer;
    }

}