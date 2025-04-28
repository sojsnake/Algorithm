import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //총 n개의 점
        int[][] arr = new int[n][2]; //n*2 2차원 배열

        //1번 for문: 총 n번 돌면서 x좌표를 1열, y 좌표를 2열에 넣어서 arr 배열 완성
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());;
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i][0] = x;
            arr[i][1] = y;
        }

        //o1과 o2 두 점을 비교해서
        Arrays.sort(arr, (o1, o2) -> {
            //x좌표가 같으면, y좌표 기준으로 오름차순 정렬
            if(o1[0] == o2[0]){
                return o1[1] - o2[1];
            }
            //x좌표가 같지 않으면, x좌표 기준으로 오름차순 정렬
            return o1[0] - o2[0];
        });

        //2번 for문: 2차원 배열 출력
        for(int[] array : arr){
            System.out.println(array[0]+" " +array[1]);
        }
    }
}
