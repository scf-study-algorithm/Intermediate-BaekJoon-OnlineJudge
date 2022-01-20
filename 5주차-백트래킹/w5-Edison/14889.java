import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {

    static int min = Integer.MAX_VALUE;
    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        visited = new boolean[N];

        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        //재귀 시작
        solution(0,0,N);

        System.out.println(min);
        return;
    }

    static void solution(int idx,int count,int N){
        if(count == N/2){
            //차이 출력
            int start = 0;
            int link =0;

//            for (int i = 0; i < N; i++) {
//                System.out.print(visited[i]);
//            }
//            System.out.println("");
            //팀에서도 다시 조합해서 계산 해야한다.
            for (int i = 0; i < N -1; i++) {
                for (int j = i+1; j < N ; j++) {
                    if(visited[i] && visited[j]){
                        start+=arr[i][j]+arr[j][i];
                    }
                    else if(!visited[i] && !visited[j]){
                        link+=arr[i][j]+arr[j][i];
                    }
                }
            }

            int temp = Math.abs(start-link);
            if(temp ==0){
                System.out.println(0);
                System.exit(0);
            }

            min = Math.min(temp,min);
            return;
        }
        for (int i = idx; i < N; i++) {
            if(!visited[i]){
                visited[i]=true;
                solution(i+1,count+1,N);
                visited[i]=false;
            }
        }

    }
}