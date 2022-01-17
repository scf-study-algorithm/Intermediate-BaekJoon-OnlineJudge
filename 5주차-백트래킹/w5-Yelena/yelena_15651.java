import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class yelena_15651 {
    static int n, m;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String args[]){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            arr = new int[m];
        } catch (IOException e){
            e.printStackTrace();
        }

        dfs(0);
        System.out.print(sb);
    }

    public static void dfs(int cnt){
        if(cnt >= m){
            for(int i = 0; i < m; i++){
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= n; i++){
            arr[cnt] = i;
            dfs(cnt+1);
        }
    }
}
