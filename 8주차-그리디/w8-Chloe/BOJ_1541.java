package BOJ;
//https://www.acmicpc.net/problem/1541

import java.util.*;

public class BOJ_1541 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int sum = Integer.MAX_VALUE;	// 초기 상태 여부 확인을 위한 값으로 설정
        String[] sub= in.nextLine().split("-");

//덧셈 부분을 먼저 계산 하는 것!!!!
        for(int i = 0; i < sub.length; i++) {
            int temp = 0;

            // 뺄셈으로 나뉜 토큰을 덧셈으로 분리하여 해당 토큰들을 더함.
            String[] add = sub[i].split("\\+");

            // 덧셈으로 나뉜 토큰들을 모두 더한다.
            for(int j = 0; j < add.length; j++) {
                temp += Integer.parseInt(add[j]);
            }

            // 첫 번째토큰인 경우 temp값이 첫 번째 수가 됨
            if (sum == Integer.MAX_VALUE) {
                sum = temp;
            } else {
                sum -= temp;
            }
        }
        System.out.println(sum);
    }
}
