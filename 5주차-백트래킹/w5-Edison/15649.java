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
//    static ArrayList<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        int M = sc.nextInt();

        arr = new int[M];
        visited= new boolean[N];
        sol(0,N,M);

    }

    static void sol(int count,int N,int M){

        if(count==M){
            for (int val:arr) {
                System.out.print(val +" ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {

            if(visited[i]==false){
                visited[i]=true;
                arr[count]=i+1;
                sol(count+1,N,M);
                visited[i]=false;
            }

        }

    }



}