import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        //총 이동횟수 (참고)
        sb.append((int) (Math.pow(2, N) - 1)).append('\n');
//        System.out.println((int)Math.pow(2,N)-1);

        //하노이탑은 대부분 3단계로 풀이
        // n =1 일때가 재귀의 탈출조건.
        //n=2 이상일때
        //1. A 의 1개를 C로 옮긴다.
        //2. A의 나머지를 B로 옮긴다.
        //3. C를 B로 옮긴다.
        sol(N,1,2,3);
        System.out.println(sb);
    }

    static void sol(int N,int one,int two,int three){

        //마지막 제일 큰 원판 1개 옮겨준다.
        if(N ==1){
            //이동 값 출력
//            System.out.println(one+" "+three);
            sb.append(one + " " + three + "\n");
            return;
        }

        //원판이 아직 남아있으면 재귀호출한다.
        //원판 시작이 바뀌는거 고려해야함. 잘생각해.

        sol(N-1,one,three,two);
        //이동 값 출력 (참고)
//        System.out.println(one+" "+three);
        sb.append(one + " " + three + "\n");

        sol(N-1,two,one,three);

        return;
    }
}

