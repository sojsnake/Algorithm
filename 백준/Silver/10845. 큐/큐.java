import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Deque<Integer> deque = new ArrayDeque<>();

        for(int i = 0; i < n; i++) {
            String[] s = sc.nextLine().split(" ");
            String command = s[0];

            switch (command) {
                case "push":
                    deque.add(Integer.parseInt(s[1]));
                    break;
                case "pop":
                    System.out.println(deque.isEmpty() ? -1 : deque.removeFirst());
                    break;
                case "size":
                    System.out.println(deque.size());
                    break;
                case "empty":
                    System.out.println(deque.isEmpty() ? 1 : 0);
                    break;
                case "front":
                    System.out.println(deque.isEmpty() ? -1 : deque.getFirst());
                    break;
                case "back":
                    System.out.println(deque.isEmpty() ? -1 : deque.getLast());
                    break;
            }
        }
    }
}
