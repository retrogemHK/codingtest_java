public class Code519A {

    public static void main(String[] args) {
        System.out.println(solution("hello"));
        System.out.println(solution("algorithm"));
    }

    // 이 부분을 변경해서 실행해보세요.
    private static String solution(String s) {
        int[] counts = new int[26]; // ❶ 알파벳 개수(26개)만큼 빈도수 배열 생성

        // ❷ 문자열의 각 문제에 대한 빈도수를 count배열에 저장
        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }

        // ❸ 빈도수 배열을 순회화면서 정렬된 문자열을 생성
        StringBuilder sortedStr = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < counts[i]; j++) {
                sortedStr.append((char)(i + 'a'));
            }
        }

        return sortedStr.toString();
    }

}