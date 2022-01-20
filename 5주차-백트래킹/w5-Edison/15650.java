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
        int M = sc.nextInt();

        arr = new int[M];

        sol(1,0,N,M);

    }

    static void sol(int a,int idx,int N,int M){

        if(idx==M){
            for (int val:arr) {
                System.out.print(val +" ");
            }
            System.out.println();
            return;
        }

        for (int i = a; i <= N; i++) {
            arr[idx]=i;
            sol(i+1,idx+1,N,M);
        }

    }



}