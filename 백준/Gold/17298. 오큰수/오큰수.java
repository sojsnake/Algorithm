import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int A[] = new int[N]; //입력 수열
        int ans[] = new int[N]; //정답 저장할 배열

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        } //입력 수열 완성

        //스택 선언 후 초기화
        Stack<Integer> stack = new Stack<>();
        stack.push(0); //스택에는 인덱스 넣을 것

        for(int i=1; i<N; i++){
            while(!stack.isEmpty() && A[i] > A[stack.peek()]){
                //스택 비어있지 않고, 현재 입력 수열 값이 스택 맨 위 인덱스 값보다 클 때
                //스택 맨 위 인덱스 빼고 정답 배열에 값을 저장
                int num = stack.pop();
                ans[num] = A[i];
            }

            //스택 비어있거나, 맨 위 인덱스 값보다 작을 때
            stack.push(i);
        }

        //다 끝났는데 비어있지 않으면, 남아있는 건 -1
        while(!stack.isEmpty()){
            ans[stack.pop()] = -1;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0; i<N; i++){
            bw.write(ans[i] + " ");
        }

        bw.flush();
        bw.close();
    }
}