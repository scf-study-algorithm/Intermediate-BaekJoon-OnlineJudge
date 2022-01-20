import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.*;

public class Main {

    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static int[] arr;
    static boolean[] visited;
    static int answer=0;
    static StringBuilder sb;
//    static ArrayList<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int N = sc.nextInt();
        int M = sc.nextInt();

        arr = new int[M];
        visited= new boolean[N];
        sol(0,N,M);

        System.out.println(sb);
    }

    static void sol(int count,int N,int M){

        if(count==M){
            for (int val:arr) {
                sb.append(val +" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {

//            if(visited[i]==false){
//                visited[i]=true;
            arr[count]=i+1;
            sol(count+1,N,M);
//                visited[i]=false;
//            }

        }

    }



}