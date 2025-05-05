//입력은 여러 개의 테스트 케이스로 이루어져 있으므로 배열 생성 부분이 while 내부에 있어야 한다.
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if (n == 0 && m == 0) break;

            int[] a = new int[n];
            int[] b = new int[m];

            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(br.readLine());
            }
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(br.readLine());
            }

            int i = 0, j = 0, count = 0;

            while (i < n && j < m) {
                if (a[i] < b[j]) {
                    i++;
                } else if (a[i] > b[j]) {
                    j++;
                } else {
                    count++;
                    i++;
                    j++;
                }
            }

            System.out.println(count);
        }
    }
}
