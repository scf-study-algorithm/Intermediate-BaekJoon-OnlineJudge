import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class yelena_10773 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> q = new LinkedList<>();

        // input
        for(int i = 0; i < n; i++){
            int tmp = Integer.parseInt(br.readLine());
            if(tmp == 0){
                q.pollLast();
            } else {
                q.add(tmp);
            }
        }
        // sum
        int sum = 0;
        while(!q.isEmpty()){
            sum += q.poll();
        }
        // print
        System.out.println(sum);
    }
}