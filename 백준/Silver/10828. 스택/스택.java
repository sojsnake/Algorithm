import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Stack<Integer> stackInt = new Stack<>();

        for(int i = 0; i < n; i++) {
            String[] s = sc.nextLine().split(" ");
            String command = s[0];

            switch (command) {
                case "push":
                    stackInt.push(Integer.parseInt(s[1]));
                    break;
                case "top":
                    System.out.println(stackInt.isEmpty() ? -1 : stackInt.peek());
                    break;
                case "size":
                    System.out.println(stackInt.size());
                    break;
                case "empty":
                    System.out.println(stackInt.isEmpty() ? 1 : 0);
                    break;
                case "pop":
                    System.out.println(stackInt.isEmpty() ? -1 : stackInt.pop());
                    break;
            }
        }
    }
}