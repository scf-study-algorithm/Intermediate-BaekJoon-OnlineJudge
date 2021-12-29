package bj2447;

import java.util.Scanner;

public class Main {

    static char[][] stars;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        stars = new char[n][n];
        makeStar(0,0,n,false);

        // 프린트
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                sb.append(stars[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb);

    }
    static void makeBlank(int r, int c, int n){
        for(int i = r; i < r+n; i++){
            for(int j = c; j < c+n; j++){
                stars[i][j] = ' ';
            }
        }
    }
    static void makeStar(int r, int c, int n, boolean chk){

        if(chk == true){
            makeBlank(r,c,n);
            return;
        }

        if(n == 1){
            stars[r][c] = '*';
            return;
        }

        // 분할 하기
        int nn = n/3;
        for(int i = r; i < r+n; i+= nn){
            for(int j = c; j < c+n; j+= nn){
                if(r+nn == i && c+nn == j) makeStar(i,j,nn,true);
                else makeStar(i,j,nn,false);
            }
        }
        return;
    }
}
