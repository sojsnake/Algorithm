class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int count = 0;

        for(int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, computers, visited); // 연결된 애들 탐색하기
                count++; // 새로운 네트워크 시작할 때 카운트
            }
        }

        return count;
    }

    public void dfs(int current, int[][] computers, boolean[] visited) {
        visited[current] = true; //현재 방문한 정점 true로 바꾸기

        for (int i = 0; i < computers.length; i++) {
            // 연결되어 있고, 아직 방문하지 않았으면,
            if (computers[current][i] == 1 && !visited[i]) {
                dfs(i, computers, visited);
                //재귀 호출해서 더 탐색
            //다 탐색했으면 그 다음꺼로 넘어감
            }
        }
    }
}
