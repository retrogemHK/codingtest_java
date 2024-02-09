import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

class Solution {

    private static final int MONTH_OF_YEAR = 12;
    private static final int DAY_OF_MONTH = 28;

    public int[] solution(String today, String[] terms, String[] privacies) {
        int todayDay = stringToDay(today);

        HashMap<Character, Integer> term = new HashMap<>();
        for (String s : terms) {
            StringTokenizer st = new StringTokenizer(s);
            term.put(st.nextToken().charAt(0), Integer.parseInt(st.nextToken()) * DAY_OF_MONTH);
        }

        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 1; i <= privacies.length; i++) {
            StringTokenizer st = new StringTokenizer(privacies[i - 1]);
            int day = stringToDay(st.nextToken()) + term.get(st.nextToken().charAt(0));
            if (todayDay >= day) {
                answer.add(i);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    private static int stringToDay(String s) {
        StringTokenizer st = new StringTokenizer(s, ".");
        int month = (Integer.parseInt(st.nextToken()) - 2000) * MONTH_OF_YEAR + Integer.parseInt(st.nextToken()) - 1;
        int day = Integer.parseInt(st.nextToken());
        return month * DAY_OF_MONTH + day;
    }

}