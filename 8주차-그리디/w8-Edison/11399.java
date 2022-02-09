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
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
//        String str = sc.next();
//        System.out.println(str);
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i]=sc.nextInt();
        }

        Arrays.sort(arr);

        int answer=0;
        int temp = 0;
        for (int i = 0; i < N; i++) {
            temp+=arr[i];
            arr[i]+=temp;
            answer+=temp;
        }

//        int answer = 0;
//        for (int i = 0; i < N; i++) {
//            answer+=arr[i];
//        }

        System.out.println(answer);


    }


    static void sol(){


    }

}