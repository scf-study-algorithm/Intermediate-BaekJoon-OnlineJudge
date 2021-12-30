import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.*;

public class Main {

    static int min = Integer.MAX_VALUE;
    static int[][] arr;

    public static void main(String[] args) throws IOException{

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        //rank를 배열에 저장할 필요는 없을듯
        for (int i = 0; i < N; i++) {
            int answer=1;

            //맨위 1개 랭크 정한다 전부 탐색해서
            for (int j = 0; j < N; j++) {
                //같은 거랑 비교하면 continue;
                if(i == j){
                    continue;
                }
                //조건 1 적용 몸무게가 더 크고
                //조건 2 적용 키가 더 크고
                //둘다 적용되어야 랭크가 올라간다.

//                if(arr[i][0] < arr[j][0]){
//                    if(arr[i][1] < arr[j][1]){
//                        answer++;
//                    }
//                }

                if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]){
                    answer++;
                }

            }
            //다 비교해보고 랭크 출력
            System.out.print(answer+ " ");
        }

    }

    static void sol() {

        return;
    }
}

