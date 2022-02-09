import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class yelena_11047{
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] money = new int[n];

            for(int i = 0; i < n; i++){
                money[i] = Integer.parseInt(br.readLine());
            }

            int sum = 0, count = 0;
            for(int i = n-1; i >= 0; i--){
                while(true){
                    if(sum + money[i] > k) break;
                    sum += money[i];
                    count++;
                }
                if(sum == k) break;
            }

            System.out.println(count);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}