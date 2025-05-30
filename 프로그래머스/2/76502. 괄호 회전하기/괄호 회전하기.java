//스택 isValid 메서드
import java.util.*;
class Solution {
    boolean isValid(String s){
        Deque<Character> stack = new ArrayDeque<>();
        
        for(char current : s.toCharArray()){
            //여는 괄호가 들어오면 스택에 추가
            if(current == '(' || current == '{' || current == '[')
                stack.push(current);
            
            //닫는 괄호가 들어올 때
            else{
                if(stack.isEmpty())
                    return false;

                char target = stack.pop();
                if((target == '(' && current != ')')
                  || (target == '{' && current != '}')
                  || (target == '[' && current != ']'))
                    return false;
            }
                
        }
        
        return stack.isEmpty();
    }
    
    public int solution(String s) {
        int answer = 0;
        String doubleS = s+s;
        
        for(int i=0; i<s.length(); i++){
            if(isValid(doubleS.substring(i, i+s.length())))
                answer++;
        }
        
        
        return answer;
    }
}