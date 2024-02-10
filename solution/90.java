class Solution {

    public static void main(String[] args) {
        System.out.println(solution(437674, 3));
        System.out.println(solution(110011, 2));
    }

    public static int solution(int n, int k) {
        String[] p = Integer.toString(n, k).split("0");
        int answer = 0;
        for (String s : p) {
            if(!s.isEmpty() && isPrimeNumber(Long.parseLong(s)))
                answer++;
        }
        return answer;
    }

    private static boolean isPrimeNumber(long num) {
        if (num == 1) return false;
        boolean isPrime = true;
        int sqrt = (int)Math.sqrt(num + 1);

        for(int i = 2; i <= sqrt; i++) {
            if(num % i == 0) {
                isPrime = false;
                break;
            }
        }

        return isPrime;
    }

}