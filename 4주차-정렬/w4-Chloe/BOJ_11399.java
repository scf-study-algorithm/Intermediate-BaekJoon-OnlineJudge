package BOJ;
import java.util.*;
//https://www.acmicpc.net/problem/11399

public class BOJ_11399 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] nums = new int[N];

        for(int i=0; i<N; i++){
            nums[i] = in.nextInt();
        }

        Arrays.sort(nums);
        int[] answer = new int[N];

        for(int j=0 ; j<N; j++){
            if(j == 0) answer[j] = nums[j];
            else answer[j] = nums[j] + answer[j-1];
        }

        int a = 0;

        for(int b : answer){
            a += b;
        }

        System.out.println(a);

    }
}
