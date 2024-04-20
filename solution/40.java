import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

    private static class Node {
        int dest, cost;

        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }

    public int solution(int N, int[][] road, int K) {
        // ❶ 인접 리스트를 저장할 ArrayList 배열 초기화
        ArrayList<Node>[] adjList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        // ❷ road 정보를 인접 리스트로 저장
        for (int[] edge : road) {
            adjList[edge[0]].add(new Node(edge[1], edge[2]));
            adjList[edge[1]].add(new Node(edge[0], edge[2]));
        }

        int[] dist = new int[N + 1];
        // ❸ 모든 노드의 거리 값을 무한대로 초기화
        Arrays.fill(dist, Integer.MAX_VALUE);

        // ❹ 우선순위 큐를 생성하고 시작 노드를 삽입
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        pq.add(new Node(1, 0));
        dist[1] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (dist[now.dest] < now.cost)
                continue;

            // ❺ 인접한 노드들의 최단 거리를 갱신하고 우선순위 큐에 추가
            for (Node next : adjList[now.dest]) {
                if (dist[next.dest] > now.cost + next.cost) {
                    dist[next.dest] = now.cost + next.cost;
                    pq.add(new Node(next.dest, dist[next.dest]));
                }
            }
        }

        int answer = 0;

        // ❻ dist 배열에서 K 이하인 값의 개수를 구하여 반환
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) answer++;
        }

        return answer;
    }

}