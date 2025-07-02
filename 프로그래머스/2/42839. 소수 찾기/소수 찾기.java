//소수찾기 dfs(백트래킹), isPrime, HashSet, visited
import java.util.*;
class Solution {
    Set<Integer> primeSet;
    public int solution(String numbers) {
        primeSet = new HashSet<>();
        
        boolean[] visited = new boolean[numbers.length()];
        dfs(numbers, visited, "");
        
        return primeSet.size();
    }
    void dfs(String numbers, boolean[] visited, String cur){
        //cur의 길이
        if(cur.length()!=0){
            int num = Integer.parseInt(cur);
            if(isPrime(num)){
                primeSet.add(num);
            }
        }
        for(int i=0; i<numbers.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(numbers, visited, cur+numbers.charAt(i));
                visited[i] = false;
            }
        }
    }
    boolean isPrime(int num){
        //2보다 작은지 큰지로 나눠서
        if(num<2) return false;
        for(int i=2; i*i<=num; i++){
            if(num % i ==0)
                return false;
        }
        return true;
    }
}