import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[][] items1 = {{10, 19}, {7, 10}, {6, 10}};
        System.out.println(solution(items1, 15));
        int[][] items2 = {{10, 60}, {20, 100}, {30, 120}};
        System.out.println(solution(items2, 50));
    }

    private static class Item {
        int value, weight;
        double valuePerWeight;

        public Item(int value, int weight, double valuePerWeight) {
            this.value = value;
            this.weight = weight;
            this.valuePerWeight = valuePerWeight;
        }
    }

    // 이 부분을 변경해서 실행해보세요.
    private static double solution(int[][] items, int weight_limit) {
        // ❶ 각 물건의 단위 무게당 가치를 계산하여 item 배열에 추가
        Item[] item = new Item[items.length];
        for (int i = 0; i < items.length; i++) {
            item[i] = new Item(items[i][1], items[i][0],(double)items[i][1] / items[i][0]);
        }

        // ❷ 단위 무게당 가치가 높은 순으로 물건을 정렬
        Arrays.sort(item, (o1, o2) -> Double.compare(o2.valuePerWeight, o1.valuePerWeight));

        double totalValue = 0; // ❸ 선택한 물건들의 총 가치를 저장하는 변수
        int remainingWeight = weight_limit; // ❹ 남은 무게 한도를 저장하는 변수

        // ❺ 물건을 선택합니다.
        for (Item i : item) {
            if (i.weight <= remainingWeight) {
                // ❻ 남은 무게 한도 내에서 물건을 통째로 선택
                totalValue += i.value;
                remainingWeight -= i.weight;
            }
            else {
                // ❼ 남은 무게 한도가 물건의 무게보다 작으면 쪼개서 일부분만 선택
                double fraction = (double) remainingWeight / i.weight;
                totalValue += i.value * fraction;
                break; // ❽ 이미 배낭의 무게 한도를 모두 사용한 경우
            }
        }

        return totalValue;
    }

}