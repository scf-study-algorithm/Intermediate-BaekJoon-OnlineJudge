import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.*;


public class Main {

//    static int min = Integer.MAX_VALUE;
//    static int[] arr;
//    static ArrayList<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i]=sc.nextInt();
        }

        for (int x:sol(N,arr)) {
            System.out.println(x);
        }

    }


    static int[] sol(int N,int[] arr){

        for (int i = 0; i < N-1; i++) {
            int idx = i;
            for (int j = i+1; j < N; j++) {
                if(arr[j]<arr[idx]){
                    idx=j;
                }
            }
            int tmp=arr[i];
            arr[i]=arr[idx];
            arr[idx]=tmp;
        }

        return arr;
    }

}