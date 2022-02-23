import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class yelena_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(n-- > 0){
            Deque<String> deque = new LinkedList<>();

            String s = br.readLine();
            boolean flag = true;
            for(int i = 0; i < s.length(); i++){
                if (s.charAt(i) == ')'){
                    if(deque.isEmpty()){
                        flag = false;
                        break;
                    }
                    deque.pollLast();
                } else{
                    deque.add(Character.toString(s.charAt(i)));
                }
            }
            // print
            if(deque.size() != 0 || !flag){
                sb.append("NO\n");
            }else{
                sb.append("YES\n");
            }
        }
        System.out.println(sb);
    }
}