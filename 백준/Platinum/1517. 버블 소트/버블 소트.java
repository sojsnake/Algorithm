import java.util.*;
import java.io.*;

class Main {
    public static int[] A, tmp;
    public static long result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        A = new int[N+1];
        tmp = new int[N+1]; //임시 배열

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        merge_sort(1, N);
        System.out.print(result);
    }

    public static void merge_sort(int start, int end){
        //재귀함수 종료 조건
        if(end - start < 1)
            return;

        int middle = start + (end - start)/2;
        merge_sort(start, middle);
        merge_sort(middle+1, end);

        //임시 배열에 정렬하고자 하는 범위만큼 원래 배열의 값 넣기
        for(int i=start; i<=end; i++){
            tmp[i] = A[i];
        }

        int index1 = start;
        int index2 = middle+1;
        int k=start; //원본 배열에 값 업데이트 할 위치

        //병합 진행
        //두 배열 중 한 배열이라도 끝에 도달하면 멈춤
        while(index1<= middle && index2<=end){
            if(tmp[index1] > tmp[index2]){
                //뒷 배열 값이 더 작은 경우에 swap 일어남
                result += index2 - k; //이동 거리 = 원래 위치-정렬 후 위치
                A[k] = tmp[index2];
                index2++;
                k++;
            }
            else{
                A[k] = tmp[index1];
                index1++;
                k++;
            }
        }
        
        //병합 후에도 남아있는 데이터 넣어주기(뒷 배열에 작은 값 몰려있으면 앞 배열은 값 남아있음)
        //각 배열의 처음부터 끝까지 남아있는 거 있는지 다 봐줘야 함
        //배열 두 개 중 하나는 끝까지 돌았으므로 while문 두 개 중 하나만 실행될 것
        while(index1<=middle){
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