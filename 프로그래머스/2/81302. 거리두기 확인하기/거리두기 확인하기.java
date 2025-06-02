import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int i = 0; i < places.length; i++) {
            if (checkPlace(places[i])) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }

        return answer;
    }

    // 한 대기실에 대해 거리두기 확인
    private boolean checkPlace(String[] place) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (place[i].charAt(j) == 'P') {
                    if (!bfs(place, i, j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // BFS 탐색: (x, y)에서 시작하여 거리 2 이내의 사람 확인
    private boolean bfs(String[] place, int x, int y) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[5][5];
        queue.offer(new int[]{x, y, 0});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0], cy = current[1], dist = current[2];

            // 거리 제한
            if (dist >= 2) continue;

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                // 범위 초과 or 방문함
                if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5 || visited[nx][ny]) continue;

                visited[nx][ny] = true;

                char c = place[nx].charAt(ny);
                if (c == 'P') return false;      // 사람 발견: 거리두기 위반
                if (c == 'O')                    // 빈 자리: 다음 탐색 가능
                    queue.offer(new int[]{nx, ny, dist + 1});
            }
        }

        return true;
    }
}
