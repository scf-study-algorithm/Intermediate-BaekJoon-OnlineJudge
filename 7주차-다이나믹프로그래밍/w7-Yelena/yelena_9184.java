import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class yelena_9184{
    static int[][][] info = new int[21][21][21];
    public static void main(String args[]){
        ArrayList<String> answer = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while(true){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                if(a == -1 && b == -1 && c == -1) break;
                int ans = w(a,b,c);
                answer.add("w("+a+", "+b+", "+c+") = "+ans);
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        // output
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < answer.size(); i++){
            sb.append(answer.get(i) + "\n");
        }
        System.out.print(sb);
    }
    static int w(int a, int b, int c){
        if (a <= 0 || b <= 0 || c <= 0){
            return 1;
        }

        if (a > 20  || b > 20 || c > 20) {
            return w(20,20,20);
        }

        if (info[a][b][c] != 0){
            return info[a][b][c];
        }

        if (a < b && b < c){
            info[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
        } else {
            info[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
        }
        return info[a][b][c];
    }
}