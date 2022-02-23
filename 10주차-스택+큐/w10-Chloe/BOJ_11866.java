package BOJ;
//https://www.acmicpc.net/problem/11866
import java.util.*;

public class BOJ_11866 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=1; i<=N; i++){
            queue.offer(i);
        }

        int count = 1;
        while(!queue.isEmpty()){
            if(count != K){
                queue.offer(queue.poll());
                count++;
            }else{
                list.add(queue.poll());
                count = 1;
            }

        }

        System.out.print('<');
        for(int i=0; i<list.size(); i++){
            if(i != list.size()-1){
                System.out.print(list.get(i) + ", ");
            }else{
                System.out.print(list.get(i) + ">");
            }
        }




    }
}
