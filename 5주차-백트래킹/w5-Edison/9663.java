import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.*;

public class Main {

    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static int[] arr;
    static int answer=0;
//    static ArrayList<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        arr= new int[N];

        sol(0,N);
        System.out.println(answer);


    }

    /*
    먼저, 배열을 받을 때 2차원 배열로 해도 되지만, 1차원 배열로 받아도 된다. 무슨말이냐면 각 원소의 index를 '열'이라 생각하고, 원소 값을 '행'이라 생각하는 것이다.

    위 그림을 1차원 행렬로 표현하자면 다음과 같이 표현할 수 있다.

    [2, 0, 3, 1]  (배열은 0 부터 시작하므로 첫 번째 위치는 0 이다.)
     */
    static void sol(int idx,int N){

        if(idx==N){ // 정답 찾음
            answer++; //경우의수 증가
            return;
        }

        for (int i = 0; i < N; i++) {
            //행을 탐색한다.
            arr[idx] = i; //일단 놓는다 가정한다.
            //놓는게 가능한가?
            if(qeens(idx)){
                //가능하면 다음 열로 넘어가서 체크한다.
                sol(idx+1,N);
            }
        }
    }

    static boolean qeens(int col){

        //검증단계
        //상하좌우
        for (int i = 0; i < col; i++) {
            //col이 1이면 1열에 해당하는 값과 0번째 열의 퀸 위치...해서 행을 전부 확인
            if(arr[col]==arr[i]){
                return false;
            }
            //대각선
            else if(Math.abs(col - i) == Math.abs(arr[col] - arr[i])){
                return false;
            }
        }

        return true;
    }

}