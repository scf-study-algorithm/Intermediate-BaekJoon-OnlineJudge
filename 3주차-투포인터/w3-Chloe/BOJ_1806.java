package BOJ;
//https://www.acmicpc.net/problem/1806
import java.util.*;

public class BOJ_1806 {

    public static void main(String[] args) {
        //입력
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int S = scanner.nextInt();
        int[] num = new int[N];
        int sum = 0;

        for(int i=0; i<N; i++){
            num[i] = scanner.nextInt();
        }

        int ans = 100001; //최소값을 구하기 위해 최댓값으로 초기화
        int start = 0, end = 0;

        while(true){
            if(sum >= S){ //합이 S보다 크면 start포인트를 증가(인덱스 증가)
                sum -= num[start++];
                ans = Math.min(ans, (end - start) + 1); //start와 end의 거리 측정 후 최소값을 ans로 재설정
            }else if(end == N) break; //끝까지 탐색했다면 루프 종료
            else sum += num[end++]; //end 인덱스 증가 후 sum에 더함
        }

        if(ans == 100001) System.out.println(0); //합이 존재하지 않았다면 0 출력
        else System.out.println(ans);


    }
}
