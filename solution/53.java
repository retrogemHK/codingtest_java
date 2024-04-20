import java.util.Arrays;
import java.util.Collections;

public class Solution {

    public long solution(long n) {
        // ❶ 정수 n을 문자열로 변환하고 각 자릿수를 배열로 저장합니다.
        String[] digits = String.valueOf(n).split("");

        // ❷ 내림차순으로 정렬합니다.
        Arrays.sort(digits, Collections.reverseOrder());

        // ❸ 정렬된 숫자를 다시 하나의 문자열로 합칩니다.
        StringBuilder sb = new StringBuilder();
        for (String digit : digits)
            sb.append(digit);

        // ❹ 문자열을 long형으로 변환하여 반환합니다.
        return Long.parseLong(sb.toString());
    }

}