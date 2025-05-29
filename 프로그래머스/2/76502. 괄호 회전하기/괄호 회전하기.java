import java.util.*;
class Solution {
    boolean isValid(String s){
        Deque<Character> stack = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            //오른쪽 괄호이면 스택에 추가
            if(c == '(' || c == '[' || c=='{'){
                stack.push(c);
            }
            //왼쪽 괄호가 들어올 때
            else{
                if(stack.isEmpty()){
                    return false;
                }

                char target = stack.pop();
                if((target=='(' && c!=')')
                        || (target=='{' && c!='}')
                        || (target=='[' && c!=']')){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public int solution(String s) {
        int answer = 0;
        String doubleS = s+s;
        for(int i=0; i<s.length(); i++){
            if(isValid(doubleS.substring(i, s.length()+i))){
                answer++;
            }
        }

        return answer;
    }
}