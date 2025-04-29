//dungeons의 세로(행) 길이(즉, 던전의 개수)는 1 이상 8 이하 => dfs 가능

import java.lang.Math;

class Solution {
    public static boolean visited[]; //방문 여부 저장
    public static int max = 0; //최대 던전 수
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(k, dungeons, 0);
            
        return max;
    }
    public static void dfs(int hp, int[][] dungeons,int count){
        for(int i=0; i<dungeons.length; i++){
            //방문한 적 없고, 현재 피로도가 최소 필요 피로도 이상이면,
            if(!visited[i] && hp>=dungeons[i][0]){
                //해당 던전 방문
                visited[i] = true;
                //필요한 피로도를 소모한 피로도, 던전 배열, count를 1 증가시켜 방문한 던전 수 저장
                dfs(hp-dungeons[i][1], dungeons, count+1);
                //다른 경우의 수를 위해 방문 여부 false로 바꾸기
                visited[i] = false;
            }
        }
        //최대 던전 수 구해서 max에 넣기
        max = Math.max(max, count);
    }
}
