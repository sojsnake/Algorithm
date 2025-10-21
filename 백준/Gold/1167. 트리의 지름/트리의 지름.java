import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static ArrayList<Edge>[] A;
    static boolean visited[];
    static int[] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        A = new ArrayList[N+1];

        for(int i=1; i<=N; i++){
            A[i] = new ArrayList<Edge>();
        }
        
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            while(true){
                int E = Integer.parseInt(st.nextToken());
                if(E == -1)
                    break;
                int value = Integer.parseInt(st.nextToken());
                A[start].add(new Edge(E, value));
            }
        }

        distance = new int[N+1];
        visited = new boolean[N+1];
        
        //임의의 노드에서 시작(여기선 1, X)
        bfs(1);
        int max = 1;
        for(int i=2; i<=N; i++){
            if(distance[max] < distance[i])
                max = i; //가장 멀리 떨어진 노드가 지름의 한 쪽 끝에 해당(Y)
        }

        distance = new int[N+1];
        visited = new boolean[N+1];
        bfs(max); //이 결과에서 가장 거리가 먼 것이 Y와 지름의 나머지 끝(Z) 간의 거리
        Arrays.sort(distance);
        System.out.print(distance[N]);
    }

    public static void bfs(int index){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(index);
        visited[index] = true;

        while(!queue.isEmpty()){
            int now = queue.poll();
            for(Edge i : A[now]){
                int e = i.e;
                int value = i.value;
                if(!visited[e]){
                    visited[e] = true;
                    queue.add(e);
                    distance[e] = distance[now] + value;
                }
            }
        }
    }

}
class Edge{
    int e;
    int value;
    public Edge(int e, int value){
        this.e = e;
        this.value = value;
    }
}