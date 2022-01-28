import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.*;

public class Main {

    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static boolean[][] arr;

    static StringBuilder sb;
//    static ArrayList<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int N = sc.nextInt();
        int M = sc.nextInt();

        arr = new boolean[N][N];
        boolean[] visited = new boolean[N];

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt()-1;
            int b = sc.nextInt()-1;
            arr[a][b]=true;
            arr[b][a]=true;
        }

        System.out.println(sol(0,visited)-1);
    }

    static int sol(int start,boolean[] visited){

        int answer = 1;

        visited[start]=true;

        for (int i = 0; i < visited.length; i++) {
            if(arr[start][i] && !visited[i]){
                answer+=sol(i,visited);
            }
        }

        return answer;
    }



}