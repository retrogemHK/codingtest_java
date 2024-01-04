import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Solution {

    public int[] solution(String[] id_list, String[] report, int k) {
        // 신고당한 유저 - 신고 유저 집합을 저장할 해시맵
        HashMap<String, HashSet<String>> reportedUser = new HashMap<>();
        // 처리 결과 메일을 받은 유저 - 받은 횟수를 저장할 해시맵
        HashMap<String, Integer> count = new HashMap<>();

        // ❶ 신고 기록 순회
        for (String r : report) {
            String[] s = r.split(" ");
            String userId = s[0];
            String reportedId = s[1];

            if (!reportedUser.containsKey(reportedId)) { // ❷ 신고당한 기록이 없다면
                reportedUser.put(reportedId, new HashSet<>());
            }
            // ❸ 신고한 사람의 아이디를 해시맵의 value인 해시셋에 추가
            reportedUser.get(reportedId).add(userId);
        }

        for (Map.Entry<String, HashSet<String>> entry : reportedUser.entrySet()) {
            if (entry.getValue().size() >= k) { // ❹ 정지 기준에 만족하는지 확인
                for (String uid : entry.getValue()) { // ❺ 해시셋을 순회하며 count 계산
                    count.put(uid, count.getOrDefault(uid, 0) + 1);
                }
            }
        }

        int[] answer = new int[id_list.length];

        // ❻ 각 아이디별 메일을 받은 횟수를 순서대로 정리
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = count.getOrDefault(id_list[i], 0);
        }

        return answer;
    }

}