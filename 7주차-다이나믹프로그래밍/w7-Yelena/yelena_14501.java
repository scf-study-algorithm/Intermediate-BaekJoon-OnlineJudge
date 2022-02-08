import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class yelena_14501 {
    static int n = 0;
    static int[] day = null;
    static int[] price = null;
    static int[] dp = null;
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            n = Integer.parseInt(br.readLine());
            day = new int[n];
            price = new int[n];
            dp = new int[n];
            for(int i = 0; i < n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                day[i] = Integer.parseInt(st.nextToken());
                price[i] = Integer.parseInt(st.nextToken());
            }
            // output
            System.out.print(findWork(0));

        } catch (IOException e){
            e.printStackTrace();
        }
    }
    static int findWork(int d){
        if(d >= n) return 0;
        if(dp[d] != 0) return dp[d];

        int t1 = 0;
        if(d + day[d] <= n){
            t1  = price[d] + findWork(d+day[d]);
        }
        int t2 = findWork(d+1);
        return dp[d] = Math.max(t1, t2);
    }
}