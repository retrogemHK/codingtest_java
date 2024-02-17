import java.util.HashSet;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        HashSet<Integer> win = new HashSet<>();
        for (int winNum : win_nums) {
            win.add(winNum);
        }

        int zero = 0, match = 0;

        for (int lotto : lottos) {
            if (lotto == 0) zero++;
            else if (win.contains(lotto)) match++;
        }

        return new int[]{7 - Math.max((match + zero), 1), 7 - Math.max(match, 1)};
    }
}