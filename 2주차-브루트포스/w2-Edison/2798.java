import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.*;

public class Main {

    static int min = Integer.MAX_VALUE;
    static int[] arr;
    static int M;
    static int N;
    static int[] ch;
    static int answer=0;
    public static void main(String[] args) throws IOException{

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N];
        ch = new int[N];

        for(int i=0;i<N;i++){
            int in = sc.nextInt();
            arr[i] = in;
        }

        sol(0,0,0);

        System.out.print(answer);

    }
    //플레이어는 제한된 시간 안에 N장의 카드 중에서 3장의 카드를 골라야 한다.
    //플레이어가 고른 카드의 합은 M을 넘지 않으면서 M과 최대한 가깝게 만들어야 한다
    static void sol(int idx,int sum,int count) {

        if(count == 3 ){

            if(M == sum){
                answer = sum;
            }

            if(answer < sum && sum < M){
                answer = sum;
            }

            return;
        }
        else{
            if(idx > N-1){
                return;
            }
            //사용한다.
            sol(idx+1,sum+arr[idx],count+1);
            //사용하지 않는다.
            sol(idx+1,sum,count);

        }

    }
}
