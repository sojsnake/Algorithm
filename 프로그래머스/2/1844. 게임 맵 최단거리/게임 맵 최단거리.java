//bfs - boolean visited, queue
import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        int[] dr = new int[]{1,-1,0,0};
        int[] dc = new int[]{0,0,1,-1};
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new ArrayDeque<>();
        
        //첫 값 넣기
        queue.add(new int[]{0,0,1});
        visited[0][0] = true;
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            
            int r = cur[0], c = cur[1], dist = cur[2];
            
            if(r == n-1 && c == m-1)
                return dist;
            
            for(int d = 0; d<4; d++){
                int nr = r+dr[d], nc = c+dc[d];
                
                //방문 여부를 나중에
                if(nr>=0 && nr<n && nc>=0 && nc<m && maps[nr][nc] == 1){
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