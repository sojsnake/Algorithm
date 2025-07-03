//dfs 백트래킹 아님, sum, return에 바로 dfs
import java.util.*;
class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }
    int dfs(int[] numbers, int target, int index, int cur){
        //종료조건
        if(index == numbers.length){
            return (target == cur) ? 1:0;
        }
        
        int sum = 0;
        
            sum += dfs(numbers, target, index+1, cur+numbers[index]);
            sum += dfs(numbers, target, index+1, cur-numbers[index]);
        
        
        
        return sum;
    }
}