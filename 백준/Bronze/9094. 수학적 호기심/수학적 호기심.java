import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int test = Integer.parseInt(br.readLine());

        for(int i=0; i<test; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int count = 0;

            //0<a<b<n
            for(int a = 1; a<n-1; a++){
                for(int b=(a+1); b<n; b++){
                    if((a*a + b*b + m) % (a*b) == 0)
                        count++;
                }
            }
            sb.append(count + "\n");
        }
        System.out.println(sb);
    }
}
