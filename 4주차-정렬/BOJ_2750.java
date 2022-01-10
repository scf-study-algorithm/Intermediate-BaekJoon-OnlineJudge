package BOJ;
//https://www.acmicpc.net/problem/2750
import java.util.*;

public class BOJ_2750 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] nums = new int[N];

        for(int i=0; i<N; i++){
            nums[i] = scanner.nextInt();
        }

        Arrays.sort(nums);

        for(int j=0; j<N; j++){
            System.out.println(nums[j]);
        }
    }
}
