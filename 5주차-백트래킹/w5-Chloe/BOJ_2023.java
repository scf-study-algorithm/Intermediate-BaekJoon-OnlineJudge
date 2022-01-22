package BOJ;
//https://www.acmicpc.net/problem/2023
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2023 {

    public static int N;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dfs("", 0);
        System.out.println(sb.toString());

    }

    private static void dfs(String s, int cnt) {
        if (cnt == N) {
            sb.append(s+'\n');
            return;
        }
        for(int i=1; i<=9; i++) {
            if(check(Integer.parseInt(s+i))) {
                dfs(s+i,cnt+1);
            }
        }

    }

    public static boolean check(int num){
        if(num==1) return false;

        //해당 숫자에 대한 소수 체크
        int sqrt=(int)Math.sqrt(num);
        for(int i=2; i<=sqrt; i++) {
            if(num%i==0) return false;
        }
        return true;
    }
}
