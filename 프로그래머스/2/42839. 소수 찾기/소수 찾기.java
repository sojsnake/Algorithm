//dfs, 백트래킹. HashSet, boolean visited, backtrack(), isPrime() 
import java.util.*;
class Solution {
    Set<Integer> primeSet;
    
    public int solution(String numbers) {
        int answer = 0;
        
        primeSet = new HashSet<>();
        boolean[] visited = new boolean[numbers.length()];
        
        backtrack(numbers, visited, "");
        
        return primeSet.size();
    }
    //dfs
    void backtrack(String numbers, boolean[] visited, String cur){
        //cur가 소수인지 판별
        if(cur.length() !=0){
            int num = Integer.parseInt(cur);
            if(isPrime(num))
                primeSet.add(num);
        }
        
        //cur 만들기
        for(int i=0; i<numbers.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                backtrack(numbers, visited, cur+numbers.charAt(i));
                visited[i] = false;
            }
        }
    }
    
    //소수판별
    boolean isPrime(int num){
        if(num < 2) return false;
        for(int i=2; i*i<=num; i++){
            if(num%i==0) return false;
        }
        return true;
    }
}