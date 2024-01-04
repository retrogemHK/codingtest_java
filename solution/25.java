import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(solution(input)));
    }

    // 이 부분을 변경해서 실행해보세요.
    public static String[] solution(int[] nodes) {
        String[] result = new String[3];
        result[0] = preorder(nodes, 0).trim(); // 마지막 공백 제거
        result[1] = inorder(nodes, 0).trim(); // 마지막 공백 제거
        result[2] = postorder(nodes, 0).trim(); // 마지막 공백 제거
        return result;
    }

    private static String preorder(int[] nodes, int idx) {
        if (idx >= nodes.length) { // idx가 범위를 벗어나면 빈 문자열 반환
            return "";
        }

        // 루트 노드 -> 왼쪽 서브 트리 -> 오른쪽 서브 트리 순으로 재귀 호출하여 결과를 이어붙임
        return nodes[idx] + " " +
                preorder(nodes, 2 * idx + 1) +
                preorder(nodes, 2 * idx + 2);
    }

    private static String inorder(int[] nodes, int idx) {
        if (idx >= nodes.length) { // idx가 범위를 벗어나면 빈 문자열 반환
            return "";
        }

        // 왼쪽 서브 트리 -> 루트 노드 -> 오른쪽 서브 트리 순으로 재귀 호출하여 결과를 이어붙임
        return inorder(nodes, 2 * idx + 1) +
                nodes[idx] + " " +
                inorder(nodes, 2 * idx + 2);
    }

    private static String postorder(int[] nodes, int idx) {
        if (idx >= nodes.length) { // idx가 범위를 벗어나면 빈 문자열 반환
            return "";
        }

        // 왼쪽 서브 트리 -> 오른쪽 서브 트리 -> 루트 노드 순으로 재귀 호출하여 결과를 이어붙임
        return postorder(nodes, 2 * idx + 1) +
                postorder(nodes, 2 * idx + 2) +
                nodes[idx] + " ";
    }

}