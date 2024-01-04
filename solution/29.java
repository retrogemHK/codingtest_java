import java.util.ArrayList;
import java.util.Arrays;

public class Code324A_길찾기게임 {

    // ❶ Node 클래스 정의
    private static class Node {
        int x, y, num; // 노드의 좌표, 번호 저장
        Node left, right; // 노드의 왼쪽, 오른쪽 자식 노드

        public Node(int num, int x, int y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }

    // ❷ 이진 트리 생성 메소드
    private static Node makeBT(int[][] nodeinfo) {
        // ❸ 각 노드에 대한 좌표, 번호를 배열에 저장
        Node[] nodes = new Node[nodeinfo.length];
        for (int i = 0; i < nodeinfo.length; i++) {
            nodes[i] = new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]);
        }

        // ❹ y 기준으로 내림차순 정렬, y가 같다면 x를 기준으로 오름차순 정렬
        Arrays.sort(nodes, (o1, o2) -> {
            if (o1.y == o2.y)
                return Integer.compare(o1.x, o2.x);
            return Integer.compare(o2.y, o1.y);
        });

        Node root = nodes[0]; // 맨 처음 노드는 무조건 루트

        for (int i = 1; i < nodes.length; i++) {
            Node parent = root;
            while (true) {
                // ❺ 부모 노드의 x좌표가 더 크면 왼쪽으로
                if (nodes[i].x < parent.x) {
                    if (parent.left == null) {
                        parent.left = nodes[i];
                        break;
                    }
                    else {
                        parent = parent.left;
                    }
                }
                // ❻ 부모 노드의 x좌표가 더 작거나 같으면 오른쪽으로
                else {
                    if (parent.right == null) {
                        parent.right = nodes[i];
                        break;
                    }
                    else {
                        parent = parent.right;
                    }
                }
            }
        }

        return nodes[0];
    }

    // ❼ 전위 순회 메소드
    private static void preOrder(Node curr, ArrayList<Integer> answer) {
        if (curr == null) {
            return;
        }
        answer.add(curr.num);
        preOrder(curr.left, answer);
        preOrder(curr.right, answer);
    }

    // ❽ 후위 순회 메소드
    private static void postOrder(Node curr, ArrayList<Integer> answer) {
        if (curr == null) {
            return;
        }
        postOrder(curr.left, answer);
        postOrder(curr.right, answer);
        answer.add(curr.num);
    }

    public int[][] solution(int[][] nodeinfo) {
        Node root = makeBT(nodeinfo); // 이진트리 생성

        ArrayList<Integer> preOrderList = new ArrayList<>();
        preOrder(root, preOrderList); // 전위 순회
        ArrayList<Integer> postOrderList = new ArrayList<>();
        postOrder(root, postOrderList); // 후위 순회

        // 결과 반환
        int[][] answer = new int[2][nodeinfo.length];
        answer[0] = preOrderList.stream().mapToInt(Integer::intValue).toArray();
        answer[1] = postOrderList.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }

}