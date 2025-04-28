import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //카드의 갯수
        int m = Integer.parseInt(st.nextToken()); //최대 합
        int[] card = new int[n];

        st = new StringTokenizer(br.readLine());
        //1번 for문: card 배열 완성하기
        for(int i=0; i<n; i++){
            card[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0; //카드 세 장의 합
        int max = 0; //카드 세 장의 합이 최대 합과 가장 가까울 때
        
        //2번 for문: i, j, k를 각각 범위가 다르게 해서 한 번에 같은 카드를 고르지 않게 함
        //카드 세 장의 합을 구하고, 최대 합인 max 구하기
        for(int i=0; i<n-2; i++){
            for(int j=i+1; j<n-1; j++){
                for(int k=j+1; k<n; k++){
                    sum = card[i] + card[j] + card[k];
                    if(sum > max && sum <= m)
                        max = sum;
                }
            }
        }
        System.out.println(max);
    }
}
