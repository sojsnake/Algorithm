import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] e : edge){
            int a = e[0];
            int b = e[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        int[] dist = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(1);
        visited[1] = true;
        
        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int next : graph.get(now)){
                if(!visited[next]){
                    visited[next] = true;
                    dist[next] = dist[now] + 1;
                    queue.add(next);
                }
            }
        }
        
        int max = 0;
        for(int d : dist){
            max = Math.max(max, d);
        }
        
        int answer = 0;
        for(int d : dist){
            if(d == max) answer++;
        }
        
        return answer;
    }
}
