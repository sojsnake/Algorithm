 import java.util.Scanner;

 public class Main {
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int[] arr1 = new int[]{1,1,2,2,2,8};
         int[] arr2 = new int[6];

         for(int i=0; i<arr1.length; i++){
             int a = sc.nextInt();
             arr2[i] = a;
             arr1[i] -= arr2[i];
             System.out.print(arr1[i] +" ");
         }
     }
 }