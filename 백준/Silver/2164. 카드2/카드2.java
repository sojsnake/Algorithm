import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=n; i>0; i--){
            deque.add(i);
        }
        while(deque.size() > 1){
            deque.removeLast();
            int back = deque.removeLast();
            deque.addFirst(back);
        }

        System.out.print(deque.peek());
    }
}