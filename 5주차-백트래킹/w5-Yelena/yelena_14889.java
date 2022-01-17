import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class yelena_14889 {
    static int n = 0, ans = -1;
    static int[][] power = null;
    static boolean[] visited = null;

    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            n = Integer.parseInt(br.readLine());
            power = new int[n][n];
            visited = new boolean[n];

            StringTokenizer st;
            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++){
                    power[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            br.close();
        }catch (IOException e){
            e.printStackTrace();
        }

        // power 합을 구하기
        calcSum(0,0);

        // 능력치 차이 최소값 찾기
        System.out.print(ans);
    }

    static void calcSum(int idx, int cnt){
        if(cnt >= (n/2)){
            findMin();
            return;
        }

        for(int i = idx; i < n; i++){
            visited[i] = true;
            calcSum(i+1, cnt+1);
            visited[i] = false;
        }
    }

    static void findMin(){
        int[] arr1 = new int[n/2];
        int[] arr2 = new int[n/2];
        int idx1 = 0, idx2 = 0;
        for(int i = 0; i < n; i++){
            if(visited[i]) arr1[idx1++] = i;
            else arr2[idx2++] = i;
        }
        int sum1 = 0, sum2 = 0;
        for(int i = 0; i < (n/2); i++){
            for(int j = i+1; j < (n/2); j++){
                sum1 += (power[arr1[i]][arr1[j]] + power[arr1[j]][arr1[i]]);
                sum2 += (power[arr2[i]][arr2[j]] + power[arr2[j]][arr2[i]]);
            }
        }

        if(ans == -1 || ans > Math.abs(sum1-sum2)){
            ans = Math.abs(sum1-sum2);
        }
    }
}