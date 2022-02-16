import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class yelena_9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while(--testCase >= 0){
            Map<String, Integer> cloth = new HashMap<>();
            int n = Integer.parseInt(br.readLine());

            for(int i = 0; i < n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String key = st.nextToken();
                if(!cloth.containsKey(key)){
                    cloth.put(key, 1);
                } else{
                    cloth.put(key, cloth.get(key)+1);
                }
            }

            int sum = 1;
            for (String s : cloth.keySet()) {
                sum *= (cloth.get(s)+1);
            }
            System.out.println(sum-1);
        }
        br.close();
    }

}
