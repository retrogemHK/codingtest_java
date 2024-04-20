import java.util.Arrays;

public class Solution {

    public boolean solution(String[] phone_book) {
        // ❶ 전화번호부 정렬
        Arrays.sort(phone_book);

        // ❷ 전화번호부에서 연속된 두 개의 전화번호 비교
        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i]))
                return false;
        }

        // ❸ 모든 전화번호를 비교한 후에도 반환되지 않았다면, 접두어가 없는 경우이므로 true 반환
        return true;
    }

}