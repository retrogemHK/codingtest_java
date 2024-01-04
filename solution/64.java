public class Solution {

    public int[] solution(int brown, int yellow) {
        // ❶ 격자의 총 개수 (파란색 격자 + 흰색 격자)
        int totalSize = brown + yellow;
        // ❷ 세로 길이의 범위는 3부터 (갈색 격자 + 노란색 격자)의 제곱근
        int sqrt = (int)Math.sqrt(totalSize);
        for (int vertical = 3; vertical <= sqrt; vertical++) {
            // ❸ 사격형 구성이 되는지 확인
            if (totalSize % vertical == 0) {
                // ❹ 사각형의 가로 길이
                int horizontal = (int)(totalSize / vertical);
                // ❺ 카펫 형태로 만들 수 있는지 확인
                if (brown == (horizontal + vertical - 2) * 2) {
                    return new int[]{horizontal, vertical}; // ❻ [가로 길이, 세로 길이]
                }
            }
        }
        return new int[]{}; // ❼ 만약 답을 찾지 못했다면 빈 리스트를 반환
    }

}