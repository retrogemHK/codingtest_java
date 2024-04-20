import java.util.Arrays;
import java.util.HashSet;

public class Solution {

    public int[] solution(String s) {
        // ❶ 문자열 s에서 대괄호를 제거하고 ","을 기준으로 나누어 배열에 저장한 후 길이 기준으로 오름차순 정렬합니다.
        s = s.substring(0, s.length() - 2).replace("{", "");
        String[] arr = s.split("},");
        Arrays.sort(arr, (o1, o2) -> Integer.compare(o1.length(), o2.length()));

        HashSet<String> set = new HashSet<>();
        int[] answer = new int[arr.length];

        // ❷ 각 원소를 순회하면서 이전 원소와 차이 나는 부분을 구합니다.
        for (int i = 0; i < arr.length; i++) {
            String[] numbers = arr[i].split(",");
            for (String number : numbers) {
                if (!set.contains(number)) {
                    answer[i] = Integer.parseInt(number);
                    set.add(number);
                }
            }
        }

        return answer;
    }

}