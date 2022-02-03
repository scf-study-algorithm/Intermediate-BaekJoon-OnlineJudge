package BOJ;
//https://www.acmicpc.net/problem/9184
import java.util.*;

public class BOJ_9184 {

    //public int a,b,c;
    public static int[][][] numbers = new int[21][21][21];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while(true) {

            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();

            // -1 -1 -1 이 나오면 종료
            if (a == -1 && b == -1 && c == -1) {
                break;
            }

            System.out.printf("w(%d, %d, %d) = %d\n", a, b, c, w(a, b, c));
        }

    }

    public static int w(int a, int b, int c) {

        // a, b, c가 범위를 벗어나지 않으면서 메모이제이션이 되어있는 경우
        if(check(a, b, c) && numbers[a][b][c] != 0) {
            return numbers[a][b][c];
        }

        if(a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }

        if(a > 20 || b > 20 || c > 20) {
            return numbers[20][20][20] = w(20, 20, 20);
        }

        if(a < b && b < c) {
            return numbers[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        }

        return numbers[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
    }

    /*
     *  a, b, c 범위 체크(21부터 불가)
     */
    static boolean check(int a, int b, int c) {
        return 0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20;
    }
}



