package BOJ;
//https://www.acmicpc.net/problem/11050
import java.util.*;

public class BOJ_11050 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();

        System.out.println(binomial(N,K));

    }

    public static int binomial(int n, int r) {
        if(r == 0 || n == r)
            return 1;
        return binomial(n - 1, r - 1) + binomial(n - 1, r);
    }
}
