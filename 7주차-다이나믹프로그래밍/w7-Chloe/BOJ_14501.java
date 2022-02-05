package BOJ;
//https://www.acmicpc.net/problem/14501
import java.util.*;

public class BOJ_14501 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        int[] t = new int[N];
        int[] p = new int[N];

        //입력
        for(int i=0; i<N; i++){
            t[i]= in.nextInt();
            p[i] = in.nextInt();
        }

        //dp : N일에 얻을 수 있는 최대 수익
        int[] dp = new int[N+1];

        for(int j=0; j<N; j++){
            if (j + t[j] <= N) {  //날짜가 범위를 넘어가지 않는 경우
                dp[j + t[j]] = Math.max(dp[j + t[j]], dp[j] + p[j]);
            }
            //현재 경우의 수가 0일 수 있기 때문에 이전의 최대값을 넣어줌.
            //해당 날짜에 일할 수 없다면, 이전까지 일한 최대 수당을 넣어주어야 한다.
            dp[j+1] = Math.max(dp[j+1], dp[j]);
        }
        System.out.println(dp[N]);
    }
}
