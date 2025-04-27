import java.util.Arrays;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        String[][] arr = new String[strings.length][2];
        for(int i=0; i<strings.length; i++){
            arr[i][0] = strings[i];
            arr[i][1] = String.valueOf(strings[i].charAt(n));
        }
        
        Arrays.sort(arr, (o1, o2) -> {
            if(o1[1].equals(o2[1])){
                return o1[0].compareTo(o2[0]);
            }
            return o1[1].compareTo(o2[1]);
        });
        
        for(int i=0; i<strings.length; i++){
            answer[i] = arr[i][0];
        }
        
        return answer;
    }
}