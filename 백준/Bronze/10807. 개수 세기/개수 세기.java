import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<n; i++){
            int m = sc.nextInt();
            list.add(m);
        }
        int v = sc.nextInt();
        for(int j : list){
            if(v == j)
                count++;
        }
        System.out.println(count);
    }
}
