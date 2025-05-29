import java.util.*;
class Solution {
    class Word{
        String word;
        int count;

        Word(String word, int count) {
            this.word = word;
            this.count = count;

        }
    }
    int diffCount(String word1, String word2){
        int count = 0;
        for(int i=0; i<word1.length(); i++){
            if(word1.charAt(i) != word2.charAt(i))
                count++;
        }
        return count;
    }
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        Set<String> visited = new HashSet<>();

        Queue<Word> queue = new LinkedList<>();
        queue.add(new Word(begin, 0));
        visited.add(begin);

        while(!queue.isEmpty()){
            Word cur = queue.poll();
            if(target.equals(cur.word)){
                return cur.count;
            }
            for(String word : words){
                if(!visited.contains(word)){
                    if(diffCount(word, cur.word)==1){
                        queue.add(new Word(word, cur.count+1));
                        visited.add(word);
                    }
                }
            }
        }

        return 0;
    }
}