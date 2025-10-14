import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Integer[] A = new Integer[str.length()];

        for(int i=0; i<str.length(); i++){
            A[i] = Integer.parseInt(str.substring(i, i+1));
        }

        Arrays.sort(A, Collections.reverseOrder());

        for(int i=0; i<str.length(); i++){
            System.out.print(A[i]);
        }
    }
}