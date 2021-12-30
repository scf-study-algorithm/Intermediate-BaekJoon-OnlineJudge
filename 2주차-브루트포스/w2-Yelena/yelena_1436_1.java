package bj1436_2;

import java.util.Scanner;

public class Main {

    static String num = "666";
    static int n, curRank = 1,ans = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int idx = 1;
        n = in.nextInt();

        // 첫번째 영화는..
        if (n == 1) {
            System.out.print(666);
            return;
        }
        // 가장 단순한 방법
        for(int i = 1666; ; i++){
            String nn = Integer.toString(i);
            if(nn.contains("666")) idx++;
            if(idx == n){
                ans = i;
                break;
            }
        }
    }
}
