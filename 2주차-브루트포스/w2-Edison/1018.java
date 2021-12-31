import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.*;

public class Main {

    static int min = Integer.MAX_VALUE;
    static char[][] arr;

    public static void main(String[] args) throws IOException{

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        arr = new char[N][M];

        for (int i = 0; i < N; i++) {
            String str = sc.next();
//            System.out.println(str);
            for (int j = 0; j < M; j++) {
                if(str.charAt(j) == 'W'){
                    arr[i][j]=str.charAt(j);
                }
                else{
                    arr[i][j]=str.charAt(j);
                }
            }
        }

//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                System.out.print(arr[i][j]);
//            }
//            System.out.println("");
//        }

        for (int i = 0; i < N-7; i++) {
            for (int j = 0; j < M-7; j++) {
                sol(i,j);
            }
        }
        System.out.println(min);

    }

    static void sol(int i_x,int j_y) {
//        System.out.println("sol start "+i_x+" "+j_y);

        int answer = 0;
        //첫번쨰 타일 색깔
        char tile = arr[i_x][j_y];

        //8칸x8칸 탐색
        for (int i = i_x; i < i_x+8; i++) {
            for (int j = j_y; j < j_y+8; j++) {
                //
                if(arr[i][j] != tile){
                    answer++;
                }

                if(tile == 'W'){
                    tile = 'B';
                }else{
                    tile = 'W';
                }
            }
            //다음행은 색깔이 또 바뀐다.
            if(tile == 'W'){
                tile = 'B';
            }else{
                tile = 'W';
            }
        }

        //오답 -> 블로그 참고
        //1. 체스판 시작이 검은색,흰색 둘중 하나다.
        // 현재 타일의 시작과 반대로도 체크해봐야함.
        // 처음 들어온 타일 색을 기준으로 구한값과 반대색을 기준으로 칠했을때도 구해봐야 한다.
        //8x8은 총 64칸에서 현재 타일색 카운트를 빼면 반대의 카운트가 나온다.

//        System.out.println(answer);
        min = Math.min(min, Math.min(answer, 64 - answer));
    }
}