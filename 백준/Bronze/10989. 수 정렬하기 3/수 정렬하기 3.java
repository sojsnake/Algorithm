import java.util.*;
import java.io.*;

class Main {
    public static int[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        A = new int[N];
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        Radix_sort(A, 5);

        for(int i=0; i<N; i++){
            bw.write(A[i] + "\n");
        }

        bw.flush();
        bw.close();
    }

    public static void Radix_sort(int[] A, int max_size){
        int[] output = new int[A.length]; //정렬 완료한 값이 들어갈 배열
        int jarisu = 1; //일의 자리부터 시작
        int count = 0;

        //최대 자릿수만큼 반복
        while(count != max_size){
            int[] bucket = new int[10]; //자릿수별 값의 개수 저장할 배열

            //자리수별 개수 저장
            for(int i=0; i<A.length; i++){
                bucket[(A[i]/jarisu) % 10]++;
            }

            //누적 합 -> 해당 자릿수까지 값 총 몇 개인지 저장
            for(int i=1; i<10; i++){
                bucket[i] += bucket[i-1];
            }

            //안정성 위해 뒤->앞
            for(int i=A.length-1; i>=0; i--){
                //해당 자릿수까지의 개수 = 인덱스 + 1
                //-> 개수에서 1뺀 위치에 값 넣기
                output[bucket[(A[i]/jarisu)%10] -1] = A[i];
                
                //해당 자리수의 값은 1개 빼주기
                bucket[(A[i]/jarisu) %10]--;
            }

            //현재까지 정렬된 순서로 원본 배열 업데이트
            for(int i=0; i<A.length; i++){
                A[i] = output[i];
            }

            //앞 자리수
            jarisu*=10;
            count++;
        }
    }
}