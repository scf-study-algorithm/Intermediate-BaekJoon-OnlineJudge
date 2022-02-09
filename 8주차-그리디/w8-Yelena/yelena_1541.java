import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class yelena_1541 {
    public static void main(String[] args){
        try{
            // 1. input
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine().replaceAll("-"," "));
            int cnt = st.countTokens();

            // 2. exec
            String first = st.nextToken();
            int sum = findSum(first);
            for(int i = 1; i < cnt; i++){
                String tmp = st.nextToken();
                sum -= findSum(tmp);
            }

            // 3. output
            System.out.println(sum);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    static int findSum(String s){
        // parsing
        String str = s.replaceAll("[+]"," ");
        StringTokenizer st = new StringTokenizer(str);
        int cnt = st.countTokens();

        // sum
        int sum = Integer.parseInt(st.nextToken());
        for(int i = 1; i < cnt; i++){
            sum += Integer.parseInt(st.nextToken());
        }
        return sum;
    }
}