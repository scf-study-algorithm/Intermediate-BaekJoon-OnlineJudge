import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class yelena_15650 {
    static int n, m;
    static int[] arr;
    static boolean[] chk;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
        } catch (IOException e){
            e.printStackTrace();
        }

        arr = new int[m];
        chk = new boolean[n+1];

        dfs(0);

        System.out.print(sb);
    }

    public static void dfs(int cnt){
        if(cnt >= m){
            for(int i = 0; i < cnt; i++){
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= n; i++){
            if(chk[i]) continue;
            if(cnt >= 1 && arr[cnt-1] > i) continue;
            chk[i] = true;
            arr[cnt] = i;
            dfs(cnt+1);
            chk[i] = false;
        }
    }
}
