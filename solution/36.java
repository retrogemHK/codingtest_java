import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[][] graph1 = {{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6}, {3, 7}, {4, 8}, {5, 8}, {6, 9}, {7, 9}};
        System.out.println(Arrays.toString(solution(graph1, 1, 9)));
        int[][] graph2 = {{1, 3}, {3, 4}, {3, 5}, {5, 2}};
        System.out.println(Arrays.toString(solution(graph2, 1, 5)));
    }

    // 인접 리스트 저장할 ArrayList 배열
    private static ArrayList<Integer>[] adjList;

    // 방문 여부를 저장할 boolean 배열
    private static boolean[] visited;

    private static ArrayList<Integer> answer;

    // 이 부분을 변경해서 실행해보세요.
    private static int[] solution(int[][] graph, int start, int n) {
        adjList = new ArrayList[n + 1];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] edge : graph) {
            adjList[edge[0]].add(edge[1]);
        }

        // ❶ 방문 여부를 저장할 배열
        visited = new boolean[n + 1];
        answer = new ArrayList<>();
        bfs(start); // ❽ 시작 노드에서 너비 우선 탐색 시작

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    // BFS 탐색 메소드
    private static void bfs(int start) {
        // ❷ 탐색시 맨 처음 방문할 노드를 add 하고 방문처리
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = true;

        // ❸ 큐가 비어 있지 않은 동안 반복
        while (!queue.isEmpty()) {
            // ❹ 큐에 있는 원소 중 가장 먼저 추가된 원소를 poll하고 정답 리스트에 추가
            int now = queue.poll();
            answer.add(now);
            // ❺ 인접한 이웃 노드들에 대해서
            for (int next : adjList[now]) {
                if (!visited[next]) { // ❻ 방문하지 않은 인접한 노드인 경우
                    // ❼ 인접한 노드를 방문 처리함
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
    }

}