package sort;

import java.util.Arrays;
import java.util.Scanner;

public class bj2750 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = in.nextInt();
        in.close();

        Arrays.sort(arr);
        for(int i = 0; i < n; i++){
            System.out.println(arr[i]);
        }
    }
}