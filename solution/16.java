import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {

    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> answer = new ArrayDeque<>();

        int n = progresses.length;
        // ❶ 각 작업의 배포 가능일 계산
        int[] daysLeft = new int[n];
        for (int i = 0; i < n; i++) {
            daysLeft[i] = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
        }

        int count = 0; // ❷ 배포될 작접의 수 카운트
        int maxDay = daysLeft[0]; // ❸ 현재 배포될 작업 중 가장 늦게 배포될 작업의 가능일

        for (int i = 0; i < n; i++) {
            if (daysLeft[i] <= maxDay) { // ❹ 배포 가능일이 가장 늦은 배포일보다 빠르면
                count++;
            }
            else { // ❺ 배포 예정일이 기준 배포일보다 느리면
                answer.add(count);
                count = 1;
                maxDay = daysLeft[i];
            }
        }

        answer.add(count); // ❻ 마지막으로 카운트된 작업들을 함께 배포
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

}