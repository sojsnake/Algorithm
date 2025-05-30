//word클래스, getDiffCount, set으로 visited 구현, bfs
import java.util.*;
class Solution {
    class Word{
        String word;
        int count;
        Word(String word, int count){
            this.word = word;
            this.count = count;
        }
    }
    
    //다른 거 세주기
    int getDiffCount(String word1, String word2){
        int count = 0;
        
        for(int i=0; i<word1.length(); i++){
            if(word1.charAt(i) != word2.charAt(i))
                count++;
        }
        
        return count;
    }
    
    public int solution(String begin, String target, String[] words) {
        
        Queue<Word> queue = new ArrayDeque<>();
        Set<String> set = new HashSet<>();
        
        //첫 값 넣기
        queue.offer(new Word(begin, 0));
        set.add(begin);
        
        //큐 돌면서 
        while(!queue.isEmpty()){
            Word cur = queue.poll();
            
            //현재 노드가 타겟 노드와 같으면 count 리턴
            if(cur.word.equals(target)){
                    return cur.count;
            }
            
            //현재 노드가 타겟 노드와 다르면
            //words배열 돌면서 현재 노드와의 다른 알파벳 세주고
            //1일때만 방문
            for(String word : words){
                if(!set.contains(word)){
                    if(getDiffCount(cur.word, word) == 1){
                        queue.add(new Word(word, cur.count+1));
                        set.add(word);
                    }
                    
                }
            }
        }
        
        return 0;
    }
}