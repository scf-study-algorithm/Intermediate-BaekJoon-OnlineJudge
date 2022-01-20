import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.*;

public class Main {

    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
//    static int[] arr;
//    static ArrayList<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
//        String str = sc.next();
//        System.out.println(str);
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i]=sc.nextInt();
        }

        int plus = sc.nextInt();
        int minus = sc.nextInt();
        int mul = sc.nextInt();
        int div = sc.nextInt();

        sol(0,arr[0],arr,plus,minus,mul,div);

        System.out.println(max);
        System.out.println(min);
    }


    static void sol(int idx,int sum,int[] arr,int plus,int minus,int mul,int div){

        if(plus+minus+mul+div==0){

            if(min>sum){
                min=sum;
            }

            if(max<sum){
                max=sum;
            }

            return;
        }

        if(plus > 0){
            sol(idx+1,sum+arr[idx+1],arr,plus-1,minus,mul,div);
        }

        if(minus > 0){
            sol(idx+1,sum-arr[idx+1],arr,plus,minus-1,mul,div);
        }

        if(mul > 0){
            sol(idx+1,sum*arr[idx+1],arr,plus,minus,mul-1,div);
        }

        if(div > 0){
            sol(idx+1,sum/arr[idx+1],arr,plus,minus,mul,div-1);
        }

    }

}