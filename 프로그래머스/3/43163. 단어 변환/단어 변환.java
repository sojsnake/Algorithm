import java.util.*;
class Solution {
    class Word{
        String word;
        int count;
        public Word(String word, int count){
            this.word = word;
            this.count = count;
        }
    }

    int getDiffCount(String word1, String word2){
        int count = 0;
        for(int i=0; i<word1.length(); i++){
            if(word1.charAt(i) != (word2.charAt(i)))
                count++;
        }
        return count;
    }

    public int solution(String begin, String target, String[] words) {
        //큐에 들어갈 타입을 Word로 지정해야 함
        Queue<Word> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();

        //큐에 넣고 방문 처리
        queue.offer(new Word(begin, 0));
        visited.add(begin);

        while(!queue.isEmpty()){
            Word cur = queue.poll();
            if(cur.word.equals(target))
                return cur.count;
            
            for(String word : words){
                if(getDiffCount(cur.word, word) == 1){
                    if(!visited.contains(word)) {
                        queue.offer(new Word(word, cur.count + 1));
                        visited.add(word);
                    }
                }
            }
        }
        return 0;
    }
}