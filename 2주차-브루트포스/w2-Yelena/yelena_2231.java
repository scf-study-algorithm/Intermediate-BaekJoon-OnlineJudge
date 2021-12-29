package bj2231_2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n, ans = 0;

        n = in.nextInt();
        String num = Integer.toString(n);
        int sz = num.length() * 9;

        for(int i = n-sz; i < n; i++){
            String tmp = Integer.toString(i);
            int sum = 0;
            for(int j = 0; j < tmp.length(); j++)
                sum += (tmp.charAt(j) - '0');
            if(sum + i == n){
                if(ans == 0 || ans > i) ans = i;
            }
        }

        System.out.print(ans);
    }
}
