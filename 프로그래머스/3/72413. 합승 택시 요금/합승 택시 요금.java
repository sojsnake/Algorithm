//최소 비용 저장할 배열 선언 후 초기화, 무방향, 3중 for문, answer 합승 하는 경우와 아닌 경우 나눠서
import java.util.*;
class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] map = new int[n+1][n+1];
        
        for(int i=1; i<=n; i++){
            //충분히 큰 값
            Arrays.fill(map[i], 200*100000);
            //자기 자신은 비용 0
            map[i][i] = 0;
        }
        
        //무방향
        for(int[] fare : fares){
            map[fare[0]][fare[1]] = fare[2];
            map[fare[1]][fare[0]] = fare[2];
        }

        
        //3중 for문
        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    //k 경유하는 게 비용 더 적으면 그걸로 업데이트
                    if(map[i][j] > map[i][k] + map[k][j])
                        map[i][j] = map[i][k] + map[k][j];
                }
            }
        }
        
        //answer 합승 안하는 경우 s->a, s->b
        int answer = map[s][a] + map[s][b];
        
        //합승 하는 경우 s->i, i->a, i->b
        for(int i=1; i<=n; i++){
            answer = Math.min(answer, map[s][i] + map[i][a] + map[i][b]);
        }
        
        
        return answer;
    }
}