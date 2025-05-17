import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] A; //ArrayList들의 배열 A => 배열 크기 선언 필요
    static int visited[]; //방문여부 체크 + 거리 정보 넣을 배열
    static List<Integer> result = new ArrayList<>(); //결과 도시들 넣을 리스트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cityNumber = Integer.parseInt(st.nextToken());
        int roadNumber = Integer.parseInt(st.nextToken());
        int shortDist = Integer.parseInt(st.nextToken());
        int startCity = Integer.parseInt(st.nextToken());

        A = new ArrayList[cityNumber + 1];
        visited = new int[cityNumber+1];

        for(int i=1; i<=cityNumber;i++){
            // 각 노드에 대하여 빈 리스트 추가
            A[i] = new ArrayList<Integer>();
        }
        //간선 개수만큼 돌면서 데이터 입력 받은 후 리스트에 넣기 => 인접리스트 완성
        for(int i=0; i<roadNumber;i++){
            st = new StringTokenizer(br.readLine());
            int startNode = Integer.parseInt(st.nextToken());
            int endNode = Integer.parseInt(st.nextToken());
            A[startNode].add(endNode);
        }

        // 방문 안 한 노드에 -1로 초기화 -> 방문 하면 0으로 바꿔주고,
        // 이후에 거리+1 해주면서 최단 거리 구함
         for(int i=1; i<=cityNumber; i++){
             visited[i] = -1;
         }
         BFS(startCity);

         //BFS 결과, visited 값이 최단거리와 같은 노드만 리스트에 저장
         for(int i=1; i<=cityNumber; i++){
             if(visited[i] == shortDist){
                 result.add(i);
             }
         }
         //리스트 비어있으면 -1 출력
        if(result.isEmpty())
            System.out.println(-1);
        //리스트 비어있지 않으면 오름차순 정렬 후 출력
         else{
            Collections.sort(result);
            for(int r : result)
                System.out.println(r);
        }
    }
    public static void BFS(int startNode){
        Queue<Integer> queue = new LinkedList<>();
        //현재 노드 큐에 넣어서 예약
        queue.add(startNode);
        visited[startNode]++; //시작 노드의 visited 값을 0으로 변경
        //큐 비어있지 않은 동안 현재 노드와 연결된 리스트 돌면서 거리 정보 업데이트
        while(!queue.isEmpty()){
            int nowNode = queue.poll();
            for(int n : A[nowNode]){
                //첫 방문일 때만 현재 노드까지의 거리에 +1하고 큐에 넣기
                if(visited[n] == -1){
                    visited[n] = visited[nowNode] +1;
                    queue.add(n);
                }
            }
        }
    }
}
