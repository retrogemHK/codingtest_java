public class Solution {

    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int location = 1; // ❶ 현재 탐색하는 아파트의 위치
        int idx = 0; // ❷ 설치된 기지국의 인덱스

        while (location <= n) {
            // ❸ 기지국이 설치된 위치에 도달한 경우
            if (idx < stations.length && location >= stations[idx] - w) {
                location = stations[idx] + w + 1;
                idx++;
            }
            // ❹ 기지국이 설치되지 않은 위치인 경우
            else {
                location += 2 * w + 1; // ❺ 기지국을 설치하고 해당 범위를 넘어감
                answer++;
            }
        }

        return answer;
    }

}