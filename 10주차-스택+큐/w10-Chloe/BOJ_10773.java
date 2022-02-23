package BOJ;
//https://www.acmicpc.net/problem/10773
import java.util.*;

public class BOJ_10773 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<N; i++){
            int num = in.nextInt();
            if(num != 0) stack.push(num);
            else stack.pop();
        }

        int sum = 0;
        while(!stack.isEmpty()){
            sum +=  stack.peek();
            stack.pop();
        }

        System.out.println(sum);
    }
}
