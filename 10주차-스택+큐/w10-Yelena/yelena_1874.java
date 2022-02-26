import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class yelena_1874 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(Integer.parseInt(br.readLine()));
        }


        int idx = 0;
        int num = 1;
        char[] answer = new char[n*2];
        Deque<Integer> deque = new LinkedList<>();
        while(true){
            // 추가
            deque.add(num++);
            sb.append("+\n");

            // 빼기
            while(!deque.isEmpty() && deque.peekLast().compareTo(list.get(idx)) == 0){
                deque.pollLast();
                idx++;
                sb.append("-\n");
            }

            if(num > n) break;
        }

        if(deque.isEmpty()){
            System.out.println(sb);
        } else{
            System.out.println("NO");
        }
    }
}