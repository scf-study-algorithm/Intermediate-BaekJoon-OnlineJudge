import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.*;

public class Main {

    static int min = Integer.MAX_VALUE;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = sc.nextInt();
        int M = sc.nextInt();

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

//        Arrays.sort(arr);

        int answer=0;
        int sum=0;
        int lt=0;

        for (int rt = 0; rt < N; rt++) {
            sum+=arr[rt];

            if(sum >= M){
//                System.out.println("바깥"+sum + " "+lt+" "+rt+" ");
//                System.out.println(rt-lt+1);
                min = Math.min(rt-lt+1,min);
//                answer++;
            }

            while(sum >= M){
//                System.out.print(arr[lt]);
                sum-=arr[lt++];
//                System.out.print("안쪽"+sum+" "+lt+" "+rt+" ");
                if(sum>=M){
//                    answer++;
//                    System.out.println(rt-lt+1);
                    min = Math.min(rt-lt+1,min);
                }
            }
        }
//        System.out.println();
        answer=min;
        if(answer == Integer.MAX_VALUE){
            System.out.println(0);
        }else{
            System.out.println(answer);
        }

    }

    static void sol(){
        return;
    }
}