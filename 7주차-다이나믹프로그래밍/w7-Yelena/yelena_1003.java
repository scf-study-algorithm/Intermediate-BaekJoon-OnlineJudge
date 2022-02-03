import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class yelena_1003{
    static class His{
        private int zero, one;

        public His(int zero, int one) {
            this.zero = zero;
            this.one = one;
        }

        public int getZero() {
            return zero;
        }

        public int getOne() {
            return one;
        }
    }
    static His[] histroy = new His[41];
    public static void main(String args[]){
        ArrayList<His> answer = new ArrayList<>();
        for(int i = 0; i < 41; i++){
            histroy[i] = new His(0,0);
        }
        histroy[0] = new His(1,0);
        histroy[1] = new His(0,1);
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int testCase = Integer.parseInt(br.readLine());
            while(--testCase >= 0){
                int n = Integer.parseInt(br.readLine());
                His h = fibo(n);
                answer.add(new His(h.getZero(), h.getOne()));
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        // output
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < answer.size(); i++){
            sb.append(answer.get(i).getZero() + " " + answer.get(i).getOne() + "\n");
        }
        System.out.println(sb);
    }
    static His fibo(int n){
        if (n < 0) return new His(0,0);
        if (histroy[n].getOne() != 0 || histroy[n].getZero() != 0) {
            return histroy[n];
        }
        His h1 = fibo(n-1);
        His h2 = fibo(n-2);
        histroy[n] = new His(h1.getZero() + h2.getZero(),
                h1.getOne()+ h2.getOne());
        return histroy[n];
    }
}
