package BOJ;
//https://www.acmicpc.net/problem/16922
import java.util.*;

public class BOJ_16922 {
    public static int[] nums;
    public static int[] sum;
    public static int count;
    public static int N;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        nums = new int[]{1, 5, 10, 50};
        sum = new int[10000];
        count = 0;
        romanNumber(0,0,0);
        System.out.println(count);
    }

    public static void romanNumber(int a, int b, int c){
        if(a == N ){
            if(sum[c] == 0) {
                sum[c] = 1;
                count++;
            }
            return;
        }
        for(int i=b; i<4; i++ ){
            romanNumber(a+1,i,c+nums[i]);
        }
    }
}
