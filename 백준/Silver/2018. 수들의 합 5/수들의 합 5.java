import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int sum = 1;
        int count = 0;
        int start = 1, end = 1;

        while(end <= N){
            if(sum == N){
                count++;
                end++;
                sum += end;
            }
            else if(sum < N){
                end++;
                sum += end;
            }
            else{
                sum -= start;
                start++;
            }
        }
        System.out.print(count);
    }
}