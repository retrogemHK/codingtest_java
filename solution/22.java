import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Solution {

    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, ArrayList<int[]>> genreMap = new HashMap<>();
        HashMap<String, Integer> playMap = new HashMap<>();

        // ❶ 장르별 총 재생 횟수와 각 곡의 재생 횟수 저장
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            if (!genreMap.containsKey(genre)) {
                genreMap.put(genre, new ArrayList<>());
                playMap.put(genre, 0);
            }
            genreMap.get(genre).add(new int[]{i, play});
            playMap.put(genre, playMap.get(genre) + play);
        }

        ArrayList<Integer> answer = new ArrayList<>();

        // ❷ 총 재생 횟수가 많은 장르순으로 내림차순 정렬
        Stream<Map.Entry<String, Integer>> sortedGenre = playMap.entrySet()
                                                                .stream()
                                                                .sorted((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()));

        // ❸ 각 장르 내에서 노래를 재생 횟수 순으로 정렬해 최대 2곡까지 선택
        sortedGenre.forEach(entry -> {
            Stream<int[]> sortedSongs = genreMap.get(entry.getKey()).stream()
                                                                    .sorted((o1, o2) -> Integer.compare(o2[1], o1[1]))
                                                                    .limit(2);
            sortedSongs.forEach(song -> answer.add(song[0]));
        });

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

}