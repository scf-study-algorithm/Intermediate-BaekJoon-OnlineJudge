import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class yelena_2217 {

    public static void main(String[] args){

        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            int[] weight = new int[n];

            for(int i = 0; i < n; i++){
                weight[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(weight);
            int max = 0;
            for(int i = 0; i < n; i++){
                int tmp = weight[i] * (n-i);
                if(max < tmp){
                    max = tmp;
                }
            }
            System.out.println(max);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}