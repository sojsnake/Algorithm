import java.util.*;
import java.io.*;

public class Main {
    public static int[] A, tmp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        A = new int[N+1];
        tmp = new int[N+1];
        
        for(int i=1; i<=N; i++){
            A[i] = Integer.parseInt(br.readLine());
        }
        
        merge_sort(1, N);
        
        for(int i=1; i<=N; i++){
            bw.write(A[i] + "\n");
        }

        bw.flush();
        bw.close();
    }

    public static void merge_sort(int start, int end){
        //재귀함수 종료 조건
        if(end - start < 1)
            return;

        int middle = start + (end - start)/2;

        //두 그룹으로 분할
        merge_sort(start, middle);
        merge_sort(middle+1, end);
        for(int i=start; i<=end; i++){
            tmp[i] = A[i];
        }

        //정렬된 두 그룹 병합하면서 정렬 끝
        int k = start;
        int index1 = start; //앞 그룹의 시작
        int index2 = middle+1; //뒷 그룹의 시작

        while(index1 <= middle && index2 <= end){
            //두 그룹 각각에서 인덱스가 가리키는 위치의 값 중 작은 값을 저장
            if(tmp[index1] > tmp[index2]){
                A[k] = tmp[index2];
                k++;
                index2++;
            }
            else{
                A[k] = tmp[index1];
                k++;
                index1++;
            }
        }

        //남아있는 값 저장(한 쪽에 큰 값 몰린 경우 남아있을 것)
        while(index1 <= middle){
            A[k] = tmp[index1];
            k++;
            index1++;
        }
        while(index2 <= end){
            A[k] = tmp[index2];
            k++;
            index2++;
        }
    }
}