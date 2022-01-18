package BOJ;
//https://www.acmicpc.net/problem/15650
import java.util.*;

public class BOJ_15650 {
    public static int[] arr;
    //public static boolean[] visit;
    public static int N, M;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        N = in.nextInt();
        M = in.nextInt();

        arr = new int[M];
        //visit = new boolean[N];

        dfs(1,0);


    }

    public static void dfs(int a, int depth){
        // 재귀 깊이가 M과 같아지면 탐색과정에서 담았던 배열을 출력
        if (depth == M) {
            for(int num : arr) System.out.print(num + " ");
            System.out.println();
            return;
        }

        for (int i = a; i <= N; i++) {

            arr[depth] = i;
            dfs(i + 1, depth + 1);
        }
    }
}
