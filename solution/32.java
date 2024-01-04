import java.util.HashSet;

public class Solution {

    public int[] solution(int n, String[] words) {
        // ❶ 이미 사용한 단어를 저장하는 set
        HashSet<String> usedWords = new HashSet<>();
        // ❷ 이전 단어의 마지막 글자
        char prevWord = words[0].charAt(0);

        for (int i = 0; i < words.length; i++) {
            // ❸ 이미 사용한 단어이거나 첫 글자가 이전 단어와 일치하지 않으면
            if (usedWords.contains(words[i]) || words[i].charAt(0) != prevWord) {
                // ❹ 탈락하는 사람의 번호와 차례를 반환
                return new int[]{(i % n) + 1, (i / n) + 1};
            }
            // ❺ 사용한 단어로 추가
            usedWords.add(words[i]);
            // ❻ 이전 단어의 마지막 글자 업데이트
            prevWord = words[i].charAt(words[i].length() - 1);
        }

        // ❼ 모두 통과했을 경우 반환값
        return new int[]{0, 0};
    }

}