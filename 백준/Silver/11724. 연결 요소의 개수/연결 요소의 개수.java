import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] A;
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        //방향 없는 그래프 = 양쪽 다 연결
        //연결 요소의 개수 = 덩어리 개수

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        A = new ArrayList[n+1]; //인덱스 1부터 저장
        visited = new boolean[n+1];

        //인접리스트 구조 만들기
        for(int i=1; i<=n; i++){
            A[i] = new ArrayList<Integer>();
        }

        //엣지 개수만큼 돌면서 인접리스트에 값 저장
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            //양방향이므로 양쪽에 추가하기
            A[u].add(v);
            A[v].add(u);
        }

        int count = 0;
        //전체 노드 돌면서 dfs 수행
        for(int i=1; i<=n; i++){
            //방문한 적 없는 것에만 가서 dfs 수행
            if(!visited[i]){
                count++;
                dfs(i);
            }
        }
        System.out.print(count);
    }

    public static void dfs(int v){
        //재귀함수 종료조건
        if(visited[v]){
            return;
        }

        //방문한 적 없으면,
        visited[v] = true; //방문
        for(int i : A[v]){
            //연결된 노드 돌면서 방문 안한 거 있으면 그 노드에 대해 dfs 수행
            if(visited[i] == false)
                dfs(i);
        }
    }
}