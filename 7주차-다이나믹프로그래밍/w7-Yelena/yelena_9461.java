import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class yelena_9461{
    static Long[] p = new Long[101];
    public static void main(String args[]){
        ArrayList<Long> answer = new ArrayList<>();
        p[1] = 1L;
        p[2] = 1L;
        p[3] = 1L;
        p[4] = 2L;
        for(int i = 5; i < 101; i++){
            p[i] = 0L;
        }
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int testCase = Integer.parseInt(br.readLine());
            while(--testCase >= 0){
                int n = Integer.parseInt(br.readLine());
                answer.add(pado(n));
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        // output
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < answer.size(); i++){
            sb.append(answer.get(i)+"\n");
        }
        System.out.println(sb);
    }
    static Long pado(int n){
        if (n <= 0) return 0L;
        if (p[n] != 0L) return p[n];
        p[n] = pado(n-1) + pado(n-5);
        return p[n];
    }
}
