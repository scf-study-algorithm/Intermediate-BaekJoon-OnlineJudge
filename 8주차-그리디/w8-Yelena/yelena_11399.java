import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class yelena_11399 {

    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            int[] list = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                list[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(list);
            int sum = list[0];
            int prev = list[0];
            for(int i = 1; i < n; i++){
                prev += list[i];
                sum += prev;
            }

            System.out.println(sum);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}