public class Solution {

    public int solution(int n) {
        return Integer.toBinaryString(n).replace("0","").length();
    }

}