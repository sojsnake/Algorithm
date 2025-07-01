//dfs(numbers, target, index, cur)
import java.util.*;
class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }
    
    int dfs(int[] numbers, int target, int index, int cur){
        int sum = 0;
        if(index == numbers.length){
            return (cur == target) ? 1:0;
        }
        
        sum += dfs(numbers, target, index+1, cur+numbers[index]);
        sum += dfs(numbers, target, index+1, cur-numbers[index]);
        
        return sum;
    }
}