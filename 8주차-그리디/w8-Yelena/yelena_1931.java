import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class yelena_1931 {
    static class Conference implements Comparable<Conference>{
        private int s,e;

        public Conference(int s, int e) {
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
        public int compareTo(Conference c){
            if(e == c.getE()){
                return s - c.getS();
            }
            return e - c.getE();
        }
    }
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            ArrayList<Conference> cf = new ArrayList<>();
            // input
            for(int i = 0; i < n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                cf.add(new Conference(s,e));
            }
            // sort
            Collections.sort(cf);
            // execution
            int count = 1;
            int time = cf.get(0).getE();
            for(int i = 1; i < n; i++){
                if(time > cf.get(i).getS()) continue;
                count++;
                time = cf.get(i).getE();
            }
            // output
            System.out.println(count);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
