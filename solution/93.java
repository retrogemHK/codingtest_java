import java.util.ArrayDeque;

class Solution {

    public int solution(int[] queue1, int[] queue2) {
        long sum1 = 0, sum2 = 0;
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i : queue1) {
            queue.add(i);
            sum1 += i;
        }

        for (int i : queue2) {
            sum2 += i;
        }

        long target = (sum1 + sum2) / 2;

        int q2 = 0;

        int count = 0;

        while (!queue.isEmpty() && q2 < queue2.length) {
            if (sum1 == target)
                break;

            if (sum1 < target) {
                queue.add(queue2[q2]);
                sum1 += queue2[q2];
                q2++;
            }
            else {
                sum1 -= queue.poll();
            }

            count++;
        }

        if (sum1 != target)
            return -1;

        return count;
    }

}