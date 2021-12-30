package bj1018_2;

import java.util.Scanner;
import static java.lang.Math.min;

public class Main {

    static String[] board;
    static char[] ch = {'B','W'};

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n, m, ans = -1;

        n = in.nextInt();
        m = in.nextInt();

        board = new String[n];
        // input
        for(int i = 0; i < n; i++){
            board[i] = in.next();
        }
        in.close();

        for(int i = 0; i < n-7; i++){
            for(int j = 0; j < m-7; j++){
                int tmp = countColor(i,j);
                if(ans == -1 || ans > tmp) ans = tmp;
            }
        }
        System.out.print(ans);
    }
    static int countColor(int r, int c){
        int cnt0 = 0, cnt1 = 0, idx = 0;
        for(int i = r; i < r+8; i+=2){
            for(int j = c; j < c+8; j++){
                if(ch[idx] != board[i].charAt(j)) cnt0++;
                else cnt1++;
                if(ch[idx] == board[i+1].charAt(j)) cnt0++;
                else cnt1++;
                idx = (idx+1)%2;
            }
        }
        return min(cnt0, cnt1);
    }
}
