import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class yelena_1966 {
    static class Doc{
        private int idx;
        private int power;

        public Doc(int idx, int power) {
            this.idx = idx;
            this.power = power;
        }

        public int getIdx() {
            return idx;
        }

        public int getPower() {
            return power;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(test-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Deque<Doc> q = new LinkedList<>();
            ArrayList<Integer> list = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                int t = Integer.parseInt(st.nextToken());
                q.add(new Doc(i,t));
                list.add(t);
            }

            Collections.sort(list);

            // 0번째가 무슨 수인지 확인하고
            // 그 수가 빠지는 번째를 알려줌
            int idx = 1;
            int max = list.size()-1;
            while(!q.isEmpty()){
                Doc doc = q.pollFirst();
                if(doc.power >= list.get(max)){
                    max--;
                    System.out.println("out "+doc.power);
                    if(doc.idx == m){
                        sb.append(idx+"\n");
                        break;
                    }
                    idx++;
                }else{
                    q.add(doc);
                    System.out.println("in "+ doc.power);
                }
            }
        }
        System.out.println(sb);
    }
}