import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int[][] A;
    static boolean[][] visited;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for(int j=0; j<M; j++){
                A[i][j] = Integer.parseInt(line.substring(j, j+1));
            }
        }
        
        bfs(0, 0);
        System.out.print(A[N-1][M-1]);
    }

    public static void bfs(int i, int j){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {i, j});
        visited[i][j] = true;

        while(!queue.isEmpty()){
            int now[] = queue.poll();

            //네 방향으로 돌면서
            for(int k=0; k<4; k++){
                //다음으로 갈 곳 찾기
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                if(x>=0 && y>=0 && x<N && y<M){
                    //좌표 유효성 검사 통과하면
                    if(A[x][y] !=0 && !visited[x][y]){
                        //0이 아니고, 간 적 없는 거만
                        visited[x][y] = true;
                        A[x][y] = A[now[0]][now[1]] + 1; //깊이 업데이트하기
                        queue.add(new int[] {x, y}); //다음 갈 곳 넣기
                    }
                }
            }
        }
    }
}