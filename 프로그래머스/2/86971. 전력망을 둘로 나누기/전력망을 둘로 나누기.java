import java.util.*;
class Solution {
    int answer;
    Map<Integer, List<Integer>> map;
    boolean[] visited;

    public int solution(int n, int[][] wires) {
        answer = n;
        map = new HashMap<>();
        visited = new boolean[n+1];

        for(int i=1; i<=n; i++){
            map.put(i, new ArrayList<>());
        }

        for(int[] wire : wires){
            map.get(wire[0]).add(wire[1]);
            map.get(wire[1]).add(wire[0]);
        }

        dfs(1, n);

        return answer;
    }

    int dfs(int cur, int n){
        int count = 1;
        visited[cur] = true;

        for(int next : map.get(cur)){
            if(!visited[next]){
                count += dfs(next, n);
            }
        }

        answer = Math.min(answer, Math.abs(n - count*2));

        return count;
    }
}