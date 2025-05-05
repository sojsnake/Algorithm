import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static int factorial(int num){
        int result = num;
        if(num == 0)
            return 1;
        if(num == 1)
            return result;
        return result * factorial(num-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.print(factorial(num));
    }
}