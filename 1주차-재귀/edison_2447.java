백준 2447
별 찍기-10

import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {

    static char[][] star;
//    static int N;

    public static void main(String[] args) throws IOException{

        Scanner sc = new Scanner(System.in);

        //N은 3의 제곱임. 3으로 나누면서 들어가야할거 같다.
        int N = sc.nextInt();

        star = new char[N][N];

        sol(0,0,N,false);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
//                System.out.print(star[i][j]);
                sb.append(star[i][j]);
            }
//            System.out.println("");
            sb.append('\n');
        }
        System.out.print(sb);
    }

    static void sol(int x,int y,int N,boolean check){

        //공백 블록이면 출력.
        if(check){
            for (int i = x; i < x+N; i++) {
                for (int j = y; j <y+N ; j++) {
                    star[i][j]=' ';
//                    System.out.print(' ');
                }
            }
            return;
        }
        //한 블록 길이 1일때 && 공백이 아닐때 재귀로 와서 1까지 오게 된다.
        if(N == 1){
            //별하나 찍기
//            System.out.print('*');
            star[x][y]='*';
            return;
        }

        //27일때 한 블록 길이 9 -> 재귀
        //9일때 한 블록 길이 3 -> 재귀
        //3일때 한 블록 길이 1 -> 별 찍기

        //한블록 길이
        int block = N / 3;

        //한블록씩 만들기
        //27일때 9x9 가 9개 정사각형임

        // 항상 9개 중에 가운데 5는 빈칸임
        int temp=0;

        for (int i = x; i < x+N; i+=block) {
            for (int j = y; j < y+N; j+=block) {
                temp++;
                //가운데는 빈칸
                if(temp == 5){
                    sol(i,j,block,true); //빈칸 재귀
                }
                else{
                    sol(i,j,block,false); //다음 블록 재귀
                }

            }
        }
    }
}

