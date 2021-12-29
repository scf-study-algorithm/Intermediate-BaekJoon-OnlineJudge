package bj7568_2;

import java.util.Scanner;

public class Main {
    static int[][] person;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n;
        n = in.nextInt();
        person = new int[n][2];
        int[] prank = new int[n];

        for(int i = 0; i < n; i++){
            person[i][0] = in.nextInt();
            person[i][1] = in.nextInt();
        }
        in.close();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j) continue;

                if(person[i][0] < person[j][0] && person[i][1] < person[j][1])
                    prank[i]++;
            }
        }

        for(int i = 0; i < n; i++){
            System.out.print(prank[i]+1 + " ");
        }
    }
}
