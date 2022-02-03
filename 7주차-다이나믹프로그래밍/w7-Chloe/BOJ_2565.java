package BOJ;
//https://www.acmicpc.net/problem/2565

import java.util.*;

public class BOJ_2565 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[][] line = new int[N][2];
        int[] dp = new int[N];
        //입력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                line[i][j] = in.nextInt();
            }
        }

        Arrays.sort(line, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });


        for(int i = 0; i < N; i++) {

            dp[i] = 1;	// 최소 개수인 1로 초기화

            //즉, i번째 전봇대에 연결된 B전봇대는 탐색할 j번째 전봇대에 연결된 B전봇대보다 값이 커야함
            for(int j = 0; j < i; j++) {
                if(line[i][1] > line[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;
        for(int i = 0; i < N; i++) {
            max = Math.max(max, dp[i]);
        }

        // 전체 개수 - 설치 가능한 전깃줄 = 최소 철거 개수
        System.out.println(N - max);

    }
}
