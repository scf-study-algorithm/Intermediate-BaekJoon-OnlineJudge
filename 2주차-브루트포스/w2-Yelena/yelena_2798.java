package bj2798_2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] card;

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int n, m, ans = 0;

        n = in.nextInt();
        m = in.nextInt();
        card = new int[n];

        for(int i = 0; i < n; i++){
            card[i] = in.nextInt();
        }
        in.close();

        Arrays.sort(card);
        for(int i = 0; i < n; i++){
            if(ans == m) break;
            for(int j = i+1; j < n; j++){
                if(ans == m) break;
                for(int k = j+1; k < n; k++){
                    int sum = card[i] + card[j] + card[k];
                    if(sum > m) break;
                    if(ans < sum) ans = sum;
                }
            }
        }
        System.out.print(ans);
    }
}
