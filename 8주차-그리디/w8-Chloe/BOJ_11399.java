package BOJ;
//https://www.acmicpc.net/problem/11399
import java.util.*;

public class BOJ_11399 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int[] time = new int[N];
        int[] totalTime = new int[N];

        for(int i=0; i<N; i++){
            time[i] = in.nextInt();
        }

        Arrays.sort(time);

        int answer = 0;
        totalTime[0] = time[0];
        for(int j = 1; j < N; j++){
            totalTime[j] = totalTime[j-1] + time[j];
        }

        for(int t : totalTime){
            answer += t;
        }

        System.out.println(answer);
    }
}
