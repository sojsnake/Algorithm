import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        mData A[] = new mData[N];

        for(int i=0; i<N; i++){
            A[i] = new mData(Integer.parseInt(br.readLine()), i);
        }
        Arrays.sort(A);

        //이동한 인덱스 최대값
        int max = 0;
        for(int i=0; i<N; i++){
            int originalIndex = A[i].index;
            int currentIndex = i;
            if(max < originalIndex - currentIndex)
               max = originalIndex - currentIndex;
        }
        System.out.print(max+1);
    }
}

class mData implements Comparable<mData> {
    //인덱스 함께 저장하기 위한 클래스
    int value;
    int index;

    public mData(int value, int index){
        this.value = value;
        this.index = index;
    }

    //value 기준 오름차순 정렬
    @Override
    public int compareTo(mData o){
        return this.value - o.value;
    }
}