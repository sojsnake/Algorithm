import java.util.*;
import java.io.*;

public class Main {
    //자릿수를 하나씩 늘려가면서 소수인지 판별
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        //한 자리 수가 소수이려면 2, 3, 5, 7뿐
        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);
    }

    public static void dfs(int number, int jarisu){
        //재귀함수 종료조건
        if(jarisu == N){
            if(isPrime(number)){
                System.out.println(number);
            }
            return;
        }

        //자리수가 N이 아닐 때, 자리수 늘려주기
        for(int i=1; i<10; i++){
            //다음자리 수가 짝수이면 소수일 수 없음
            if(i%2 == 0)
                continue;

            //자리수 늘린 값이 소수이면
            if(isPrime(number*10 + i)){
                dfs(number*10 + i, jarisu+1);
            }
        }
    }

    //소수판별 함수
    public static boolean isPrime(int num){
        //약수는 자기 자신의 절반을 넘어설 수 없음
        for(int i=2; i<=num/2; i++){
            //나누어 떨어지는 수가 존재하면
            if(num%i == 0)
                return false;
        }
        return true;
    }
}