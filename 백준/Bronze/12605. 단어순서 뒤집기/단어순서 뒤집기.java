import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        
        for (int i = 0; i < n; i++) {
            Stack<String> stack = new Stack<>();
            String[] input = sc.nextLine().split(" ");
            
            for (String s : input) {
                stack.push(s);
            }
            System.out.print("Case #" + (i + 1) + ": ");

            while (!stack.isEmpty()) {
                System.out.print(stack.pop() + " ");
            }
            System.out.println();
        }

    }

}

