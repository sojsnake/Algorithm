//단어변환 - Word 클래스, getDiffCount 메서드, bfs, set으로 visited 처리
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
    //다른 알파벳 개수 세는 메서드
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
        Set<String> visited = new HashSet<>();
        
        //첫 값 넣기
        queue.add(new Word(begin, 0));
        visited.add(begin);
        
        while(!queue.isEmpty()){
            Word cur = queue.poll();
            
            //target과 cur.word 비교
            if(cur.word.equals(target))
                return cur.count;
            
            //서로 다르면 다음으로 넘어가기
            for(String next : words){
                if(!visited.contains(next)){
                    if(getDiffCount(next, cur.word) == 1){
                        queue.add(new Word(next, cur.count+1));
                        visited.add(next);
                    }
                }
                
            }
        }
        
        
        return 0;
    }
}