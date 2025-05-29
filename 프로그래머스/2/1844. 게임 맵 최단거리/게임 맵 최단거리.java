import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        //dist 리턴
        int n = maps.length;
        int m = maps[0].length;

        int dr[] = {1,-1,0,0};
        int dc[] = {0,0,-1,1};

        //bfs -> visited, 큐 필요
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new ArrayDeque<>();

        //첫 값 넣기
        queue.add(new int[]{0,0,1});
        visited[0][0] = true;

        while(!queue.isEmpty()){
            //큐에서 값 꺼내기
            int[] cur = queue.poll();
            int row = cur[0];
            int col = cur[1];
            int dist = cur[2];

            //현재 위치가 오른쪽 아래이면 리턴 끝
            if(row == n-1 && col == m-1)
                return dist;
            
            for(int d=0; d<4; d++){
                //next row, next col
                int nr = row + dr[d];
                int nc = col + dc[d];

                //범위에 들어오고 벽이 아닐때
                if(nr>=0 && nr<n && nc >= 0 && nc <m && maps[nr][nc]==1){
                    if(!visited[nr][nc]){
                        queue.add(new int[]{nr, nc, dist+1});
                        visited[nr][nc] = true;
                    }
                }
            }
        }
        return -1;
    }
}