import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class yelena_9663{
    static boolean[] ver, hor, dia, reDia;
    static int n = 0, cnt = 0;

    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try{
            n = Integer.parseInt(br.readLine());
        } catch(IOException e){
            e.printStackTrace();
        }
        int sz = (n*2)-1;
        ver = new boolean[n];
        hor = new boolean[n];
        dia = new boolean[sz];
        reDia = new boolean[sz];

        backtracking(0);

        System.out.print(cnt);
    }
    static void backtracking(int i) {
        if(i >= n){
            cnt++;
            return;
        }

        for(int j = 0; j < n; j++){
            if(!ver[i] && !hor[j] &&
                    !dia[(n-1)-(i-j)] && !reDia[i+j]){
                ver[i] = hor[j] = true;
                dia[(n-1)-(i-j)] = reDia[i+j] = true;
                backtracking(i+1);
                ver[i] = hor[j] = false;
                dia[(n-1)-(i-j)] = reDia[i+j] = false;
            }
        }
    }
}