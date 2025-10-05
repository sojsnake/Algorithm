import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A[] = new int[N];
        for(int i=0; i<N; i++){
            A[i] = sc.nextInt();
        }
        
        double sum = 0;
        int max = 0;
        for(int i=0; i<N; i++){
            if(A[i] > max)
                max = A[i];
        }
        for(int i=0; i<N; i++){
            double newScore = (double)A[i] / max * 100;
            sum += newScore;
        }
        System.out.print(sum/N);
    }
}