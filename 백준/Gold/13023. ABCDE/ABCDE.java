import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] A;
    static boolean visited[];
    static boolean arrive;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arrive = false;
        A = new ArrayList[N];
        visited = new boolean[N];
        
        for(int i=0; i<N; i++){
            A[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);
            A[e].add(s);
        }

        for(int i=0; i<N; i++){
            dfs(i, 1);
            if(arrive)
                break;
        }

        if(arrive)
            System.out.print("1");
        else
            System.out.print("0");
    }

    public static void dfs(int i, int depth){
        //재귀함수 종료조건
        //깊이가 5 이상일 때 또는 전체에서 깊이 5인 경우를 하나라도 찾았을때
        if(depth == 5 || arrive){
            arrive = true;
            return;
        }

        visited[i] = true;
        for(int k : A[i]){
            //A[i]와 연결된 노드 돌면서 방문 안된 것만 dfs
            if(!visited[k]){
                dfs(k, depth+1);
            }
        }
        //다른 경우에도 탐색할 수 있도록
        visited[i] = false;
    }
}