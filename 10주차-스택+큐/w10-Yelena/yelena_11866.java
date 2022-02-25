import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class yelena_11866{
    static boolean[] visited = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        visited = new boolean[n];

        int all = 0, cnt = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for(int i = 0; all < n; i=(i+1)%n){
            if(!visited[i]){
                cnt++;
                if(cnt == k){
                    visited[i] = true;
                    all++;
                    cnt = 0;
                    if(all >= n){
                        sb.append(i+1+">");
                    } else{
                        sb.append(i+1+", ");
                    }
                }
            }
        }
        System.out.println(sb);
    }
}