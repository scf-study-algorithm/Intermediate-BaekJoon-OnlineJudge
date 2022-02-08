import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.stream.Collector;

public class yelena_2565 {
    static class Connect implements Comparable<Connect> {
        private int s, e;

        public Connect(int s, int e) {
            this.s = s;
            this.e = e;
        }

        public int getS() {
            return s;
        }

        public int getE() {
            return e;
        }

        @Override
        public int compareTo(Connect c){
            return s - c.getS();
        }
    }
    public static void main(String[] args){
        int n = 0;
        ArrayList<Connect> connects = new ArrayList<>();
        int[] maxList = null;
        try {
            // input
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            maxList = new int[n];
            for(int i = 0; i < n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                connects.add(new Connect(s,e));
            }

            // sort
            Collections.sort(connects);

            // check
            int allMax = 1;
            for(int i = 0; i < n; i++){
                int m = 1;
                for(int j = 0; j < i; j++){
                    if(connects.get(i).getE() > connects.get(j).getE()){
                        if(maxList[j]+1 > m){
                            m = maxList[j] + 1;
                        }
                    }
                }
                maxList[i] = m;
                if(allMax < m) {
                    allMax = m;
                }
            }

            // output
            System.out.println(n-allMax);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
