import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class yelena_1149{
    static int[][] house = null;
    static int[][] color = null;
    static int n = 0;

    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            n = Integer.parseInt(br.readLine());
            house = new int[n][3];
            color = new int[n][3];

            // input
            StringTokenizer st = null;
            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 3; j++){
                    house[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // DP exec
            // output
            System.out.println(findColor(-1,0));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    // color -> 같은 색이 겹치면 안된다.
    // prev는 그전의 컬러를 말함
    static int findColor(int prev, int pos){
        if (pos >= n) return 0;

        int m = -1;
        for(int i = 0; i < 3; i++){
            if(prev == i) continue;
            if(color[pos][i] == 0){
                color[pos][i] = house[pos][i] + findColor(i, pos+1);
            }
            if(m == -1 || m > color[pos][i]){
                m = color[pos][i];
            }
        }
        return m;
    }
}