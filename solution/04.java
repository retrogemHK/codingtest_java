import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    public static int[] solution(int[] answers) {
        // ❶ 수포자들의 패턴
        int[][] pattern = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        // ❷ 수포자들의 점수를 저장할 배열
        int[] scores = new int[3];

        // ❸ 각 수포자의 패턴과 정답이 얼마나 일치하는지 확인
        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < pattern.length; j++) {
                if (answers[i] == pattern[j][i % pattern[j].length]) {
                    scores[j]++;
                }
            }
        }
        // ❹ 가장 높은 점수 저장
        int maxScore = Arrays.stream(scores).max().getAsInt();
        // ❺ 가장 높은 점수를 가진 수포자들의 번호를 찾아서 리스트에 담음
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == maxScore) {
                answer.add(i + 1);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

}