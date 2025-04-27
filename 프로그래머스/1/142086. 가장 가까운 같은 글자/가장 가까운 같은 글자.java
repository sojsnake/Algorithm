import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        char[] arr = s.toCharArray();
        answer[0] = -1;
        for(int i=1; i<s.length(); i++){
            char target = arr[i];
            for(int j=0; j<i; j++){
                if(arr[i] == arr[j])
                    answer[i] = i-j;
            }
            if(answer[i] == 0)
                answer[i] = -1;
        }
        
        return answer;
    }
}