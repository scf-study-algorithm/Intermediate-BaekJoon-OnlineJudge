package bj2w;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int n, k, cnt = 0;
        int ans = 0;
        n = in.nextInt();
        k = in.nextInt();

        for(int i = 1; i <= n; i++){
            if(n % i == 0) cnt++;
            if(cnt == k){
                ans = i;
                break;
            }
        }
        System.out.println(ans);
    }
}
