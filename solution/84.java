class Code702_택배배달과수거하기 {

    public static void main(String[] args) {
        System.out.println(solution(4, 1, new int[]{0}, new int[]{0}));
    }

    public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        int deliveries_idx = n - 1;
        int pickups_idx = n - 1;

        while (deliveries_idx >= 0 && deliveries[deliveries_idx] == 0) {
            deliveries_idx--;
        }
        while (pickups_idx >= 0 && pickups[pickups_idx] == 0) {
            pickups_idx--;
        }

        long answer = 0;

        while (deliveries_idx >= 0 || pickups_idx >= 0) {
            answer += (Math.max(deliveries_idx, pickups_idx) + 1) * 2L;
            deliveries_idx = getMaxIdx(cap, deliveries, deliveries_idx);
            pickups_idx = getMaxIdx(cap, pickups, pickups_idx);
        }

        return answer;
    }

    private static int getMaxIdx(int cap, int[] target, int idx) {
        while (idx >= 0 && (cap > 0 || target[idx] == 0)) {
            if (target[idx] > cap) {
                target[idx] -= cap;
                cap = 0;
            }
            else {
                cap -= target[idx];
                target[idx] = 0;
                idx--;
            }
        }
        return idx;
    }

}