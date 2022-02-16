import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class yelena_1676 {

    public static void main(String[] args) throws IOException {
        BigInteger num = new BigInteger("1");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for(int i = 2; i <= n; i++){
            String s = Integer.toString(i);
            num = num.multiply(new BigInteger(s));
        }
        String s = num.toString();
        int cnt = 0;
        for(int i = s.length()-1; i >= 0; i--){
            if(s.charAt(i) != '0') break;
            cnt++;
        }
        System.out.println(cnt);
    }
}