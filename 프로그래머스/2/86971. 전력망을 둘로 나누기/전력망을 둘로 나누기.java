//트리 맵으로 그래프 구현하고 양방향 연결
//dfs count+=dfs()
import java.util.*;
class Solution {
    int answer;
    Map<Integer, List<Integer>> graph = new HashMap<>();
    boolean[] visited;
    
    public int solution(int n, int[][] wires) {
        answer = n;
        visited = new boolean[n+1];
        
        for(int i=1; i<=n; i++){
            graph.put(i, new ArrayList<>());
        }
        
        for(int[] wire : wires){
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }
        
        dfs(1, n);
        
        return answer;
    }
    int dfs(int cur, int n){
        int count = 1;
        visited[cur] = true;
        for(int next : graph.get(cur)){
            if(!visited[next]){
                count += dfs(next, n);
            }
            
        }
        
        answer = Math.min(answer, Math.abs(n-count*2));
        
        return count;
    }
}