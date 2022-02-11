import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class yelena_13305 {

    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());

            Long[] km = new Long[n-1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n-1; i++){
                km[i] = Long.parseLong(st.nextToken());
            }

            Long[] price = new Long[n];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                price[i] = Long.parseLong(st.nextToken());
            }

            // 옆에 주유소가 싸면 그냥 해당 만큼만
            // 현재 주유소가 싸면 어디까지 싼지 미리 충전
            int i = 0;
            Long sum = 0L;
            while(i < n-1){
                Long chargeKm = km[i];
                int j = i+1;
                for(; j < n-1; j++){
                    if(price[i] >= price[j]){
                        break;
                    }
                    chargeKm += km[j];
                }
                sum += (chargeKm * price[i]);
                i = j;
            }
            System.out.println(sum);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}