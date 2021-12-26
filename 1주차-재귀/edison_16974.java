import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.*;

public class Main {

    static String[] arr;

    private static StringTokenizer st;
    private static int N;
    private static long X;
    static long[] h;
    static long[] p;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer( br.readLine() );
        N = Integer.parseInt( st.nextToken() );
        X = Long.parseLong( st.nextToken() );

         h = new long[N+1];
         p = new long[N+1];
        h[0]=p[0]=1;
        for (int i = 1; i < N+1; i++) {
            h[i]=1+h[i-1]+1+h[i-1]+1;
            p[i]=p[i-1]+1+p[i-1];
        }

        System.out.println(sol(N,X));

    }

    static long sol(int N,long X){
//재귀호출로 인해 n이 0이 될경우 레밸 0의 패티는 한 장이다. bpb
        if(N==0){
//            return 1;
            if( X==0 ) return 0;
            else if( X==1 ) return 1;
        }
//각 레벨의 첫 번째 자료는 패티가 아니므로 0반환
        if(X==1){
            return 0;
        }//x가 중간패티 위치보다 작으면 맨 앞에 번을 빼고 이전 레밸의 햄버거 패티수를 호출
        //맨 앞에 번을 빼기 위해 x-1을 해준다.
        else if(X <= 1+h[N-1]){
            return sol(N-1,X-1);
        }//x가 중간패티의 위치라면 이전 패티수+1을 반환
        else if(X == 1+h[N-1]+1){
            return p[N-1]+1;
        }//x가 중간패티 위치보다 크면 
        else if(X <= 1+h[N-1]+1+h[N-1]){
            return p[N-1]+1+sol(N-1,X-(1+h[N-1]+1));
        }
        else {//x가 현재 레밸 재료수의 크기와 같다면 현재 레밸의 패티수를 반환
            return p[N-1]+1+p[N-1];
        }
    }
}