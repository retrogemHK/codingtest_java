class Solution {

    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    public int[] solution(String[][] places) {
        int[] answer = {1, 1, 1, 1, 1};

        for (int t = 0; t < places.length; t++) {
            char[][] place = new char[5][5];
            for (int i = 0; i < 5; i++) {
                place[i] = places[t][i].toCharArray();
            }

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (place[i][j] == 'P') {
                        for (int k = 0; k < 4; k++) {
                            int x = i + dx[k];
                            int y = j + dy[k];

                            if (x < 0 || x > 4 || y < 0 || y > 4)
                                continue;

                            if (place[x][y] == 'P' || place[x][y] == 'p')
                                answer[t] = 0;

                            if (place[x][y] == 'O')
                                place[x][y] = 'p';
                        }
                    }
                }
            }

        }

        return answer;
    }
}