import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //오른쪽이 우선순위 높(먼저 poll)
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) ->{
            int first = Math.abs(o1);
            int second = Math.abs(o2);

            if(first == second){
                //절대값 같으면 음수 우선 정렬
                return o1>o2 ? 1 : -1;
            }
            else{
                //오름차순 정렬
                return first - second;
            }
        });

        for(int i=0; i<N; i++){
            int input = Integer.parseInt(br.readLine());
            if(input == 0){
                if(queue.isEmpty())
                    System.out.println("0");
                else
                    System.out.println(queue.poll());
            }
            else{
                queue.add(input);
            }
        }
    }
}