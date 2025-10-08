import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Deque<Node> deque = new LinkedList<>();
        for(int i=0; i<N; i++){
            int now = Integer.parseInt(st.nextToken());

            //현재 마지막 수보다 큰 값은 제거
            while(!deque.isEmpty() && deque.getLast().value > now){
                deque.removeLast();
            }
            deque.addLast(new Node(i, now));

            //범위 벗어나면 인덱스 제일 작은 거 제거
            if(deque.getFirst().index <= i-L){
                deque.removeFirst();
            }

            //맨 앞 값이 최소값
            bw.write(deque.getFirst().value+" ");
        }

        bw.flush();
        bw.close();
    }

    static class Node{
        public int index;
        public int value;

        Node(int index, int value){
            this.index = index;
            this.value = value;
        }
    }
}