import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] seq = new int[N];
        for(int i=0; i<N; i++){
            seq[i] = Integer.parseInt(br.readLine());
        }

        int now = 1;
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<N; i++){
            while(now <= seq[i]){
                s.push(now);
                sb.append("+").append("\n");
                now++;
            }
            if(!s.empty() && s.peek() == seq[i]){
                s.pop();
                sb.append("-").append("\n");
            }
            else if(!s.empty() && s.peek() > seq[i]){
                System.out.println("NO");
                return;
            }
        }
        System.out.println(sb);
    }
}

