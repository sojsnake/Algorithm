import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int[][] arr=new int[a][b];
        for (int i=0; i<a; i++){
            for(int j=0; j<b; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        for (int n=0; n<arr.length;n++){
            for(int m=0; m<arr[0].length; m++){
                arr[n][m] += sc.nextInt();
            }
        }

        for (int i=0; i<a; i++){
            for(int j=0; j<b; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}