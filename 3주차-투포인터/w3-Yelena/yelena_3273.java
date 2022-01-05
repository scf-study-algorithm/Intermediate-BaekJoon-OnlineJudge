package bj2w;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static long[] arr;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int n, x, cnt = 0;

        n = in.nextInt();
        arr = new long[n];
        for(int i = 0; i < n; i++){
            arr[i] = in.nextInt();
        }
        x = in.nextInt();
        in.close();

        Arrays.sort(arr);

        // 하나는 끝에서 하나는 반대끝에서
        int l = 0, r = arr.length-1;
        while(l < r){
            // 작으면 왼쪽을 땡김
            if(arr[l]+arr[r] < x) l++;
            // 크면 오른쪽을 땡김
            else if(arr[l]+arr[r] > x) r--;
            // 같으면?
            else{
                cnt++;
                l++;
                r--;
            }
        }
        System.out.println(cnt);
    }
}
