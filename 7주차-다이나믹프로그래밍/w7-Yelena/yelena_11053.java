import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class yelena_11053 {
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());

            int[] matrix = new int[n];
            int[] max = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i ++){
                matrix[i] = Integer.parseInt(st.nextToken());
            }

            int allMax = -1;
            max[0] = 1;
            for(int i = 0; i < n; i++){
                int m = 1;
                for(int j = 0; j < i; j++){
                    if(matrix[i] == matrix[j]){
                        m = (max[j] > m) ? max[j] : m;
                    }
                    if(matrix[i] > matrix[j]){
                        m = ((max[j] + 1) > m) ? (max[j] + 1) : m;
                    }
                }
                max[i] = m;
                if(allMax == -1 || max[i] > allMax){
                    allMax = max[i];
                }
            }
            System.out.println(allMax);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}