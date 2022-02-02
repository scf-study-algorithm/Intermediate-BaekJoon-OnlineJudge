package BOJ;
//https://www.acmicpc.net/problem/1932
import java.util.*;

public class BOJ_1932 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[][] nums = new int[N][];

        //입력
        for (int i = 0; i < N; i++) {
            nums[i] = new int[i + 1];

            for (int j = 0; j <= i; j++)
                nums[i][j] = in.nextInt();
        }

        //N - 1층부터 위로 올라가며 나와 내 오른쪽 칸 중 큰 값을 위의 칸에 더해줌
        //최종적으로 제일 상단에 있는 값은 아래칸부터 제일 큰 값들을 누적한 값이 더해줌, nums[0][0]의 값이 최종 답이 담겨짐.
        for (int i = N - 1; i > 0; i--) {
            for (int j = 0; j < i; j++)
                nums[i-1][j] += Math.max(nums[i][j], nums[i][j + 1]);
        }

        System.out.println(nums[0][0]);

    }
}
