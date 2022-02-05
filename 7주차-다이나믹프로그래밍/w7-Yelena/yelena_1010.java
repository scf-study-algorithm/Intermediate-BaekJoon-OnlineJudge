import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class yelena_1010 {
    static int n = 0, m = 0;
    static int[][] dp = null;
    public static void main(String[] args){
        ArrayList<Integer> answer = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int testCase = Integer.parseInt(br.readLine());
            while(--testCase >= 0){
                // input
                StringTokenizer st = new StringTokenizer(br.readLine());
                n = Integer.parseInt(st.nextToken());
                m = Integer.parseInt(st.nextToken());
                dp = new int[m+1][n+1];

                // exec
                answer.add(findCount(m,n));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        // output
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < answer.size(); i++){
            sb.append(answer.get(i)+"\n");
        }
        System.out.print(sb);
    }
    static int findCount(int l, int r){
        if(r == 0) return 1;

        if(l < 0 || r < 0 || l < r) return 0;
        if(dp[l][r] != 0) return dp[l][r];

        dp[l][r] = findCount(l-1,r-1) + findCount(l-1,r);
        return dp[l][r];
    }
}