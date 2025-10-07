import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int C = Integer.parseInt(br.readLine());

        for(int i=0; i<C; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            
            int A[] = new int[N];
            double sum = 0;
            int count = 0;

            for(int j=0; j<N; j++){
                A[j] = Integer.parseInt(st.nextToken());
                sum += A[j];
            }

            double avg = sum / N;
            
            for(int k=0;k<N; k++){
                if(A[k]>avg) count++;
            }

            double ratio = (double) count / N * 100;
            System.out.println(String.format("%.3f", ratio) + "%");
        }  
    }
}