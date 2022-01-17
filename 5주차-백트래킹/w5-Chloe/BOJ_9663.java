package BOJ;
//https://www.acmicpc.net/problem/9663
import java.util.*;



public class BOJ_9663 {
    public static int[] arr;
    public static int N;	// 체스판의 크기
    public static int count = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        arr = new int[N];

        nQueen(0);
        System.out.println(count);


    }

    //재귀 호출
    public static void nQueen(int depth){
        //행을 다 채우면 카운트를 1 증가시키고 리턴
        if(depth == N){
            count++; return;
        }
        for (int i = 0; i < N; i++) {
            arr[depth] = i;
            // 놓을 수 있는 위치일 경우 재귀호출
            if (check(depth)) nQueen(depth + 1);

        }
    }

    public static boolean check(int col){
        for(int i=0; i<col; i++){
            //해당 열의 행과 i열의 행이 일치할 경우( 같은 행에 존재할 때)
            if(arr[i] == arr[col]) return false;
            //대각선에 놓여있는 경우(열의 차와 행의 차가 같을 경우 = 대각선에 놓여있는 경우)
            else if(Math.abs(col-i) == Math.abs(arr[col] - arr[i])) return false;
        }
        return true;
    }

}
