import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            int m = Integer.parseInt(br.readLine());
            list.add(m);
        }
        Collections.sort(list);
        for(int l : list){
            System.out.println(l);
        }
    }
}