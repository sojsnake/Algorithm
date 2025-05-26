import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        //인접리스트로 변환
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] e : edge){
            int a = e[0];
            int b = e[1];
            //양방향
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        //거리 저장할 배열
        int[] dist = new int[n + 1];
        //방문 여부 저장할 배열
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();

        //1번 노드 큐에 넣어서 예약 걸고 방문 표시
        queue.add(1);
        visited[1] = true;

        while(!queue.isEmpty()){
            //큐에서 꺼낸 노드에
            int now = queue.poll();
            //연결된 인접 노드들 중에서
            for(int next : graph.get(now)){
                //방문 아직 안한 애들만
                if(!visited[next]){
                    //방문하고
                    visited[next] = true;
                    //현재 거리에서 1 증가시켜 넣기
                    dist[next] = dist[now] + 1;
                    queue.add(next);
                }
            }
        }

        //거리 배열에 저장해 둔 정보에서 max 값 찾기
        int max = 0;
        for(int d : dist){
            max = Math.max(max, d);
        }

        //max 거리인 애들 개수 세기
        int answer = 0;
        for(int d : dist){
            if(d == max) answer++;
        }
        
        return answer;
    }
}
