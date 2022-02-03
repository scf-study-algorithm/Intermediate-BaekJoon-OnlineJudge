import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class yelena_1932{
    static int[][] tri = null;
    static int[][] mx = null;
    static int n = 0;
    public static void main(String args[]){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            tri = new int[n][n];
            mx = new int[n][n];

            // input
            tri[0][0] = Integer.parseInt(br.readLine());
            StringTokenizer st = null;
            for(int i = 1; i < n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < i+1; j++){
                    tri[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // func exec + output
            System.out.println(findResult(0,0));
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    static int findResult(int r, int c){
        if(r < 0 || c < 0) return 0;
        if(r >= n || c >= n) return 0;
        if(mx[r][c] != 0) return mx[r][c];

        int r1 = findResult(r+1, c);
        int r2 = findResult(r+1, c+1);
        mx[r][c] = tri[r][c] + Math.max(r1,r2);
        return mx[r][c];
    }
}