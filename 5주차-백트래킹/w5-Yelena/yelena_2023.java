import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class yelena_2023{
    static int n = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try{
            n = Integer.parseInt(br.readLine());
        } catch (IOException e){
            e.printStackTrace();
        }

        backTracking(0,0);
        System.out.print(sb);
    }

    static void backTracking(int cnt, int p){
        if(cnt >= (n)){
            sb.append(Integer.toString(p) + "\n");
            return;
        }

        int prime = p * 10;
        for(int i = 0; i <= 9; i++){
            if(isPrime(i+prime)){
                backTracking(cnt+1, i+prime);
            }
        }
    }
    static boolean isPrime(int n){
        if(n == 0 || n == 1) return false;
        for(int i = 2; i < n; i++){
            if(n % i == 0) return false;
        }
        return true;
    }
}