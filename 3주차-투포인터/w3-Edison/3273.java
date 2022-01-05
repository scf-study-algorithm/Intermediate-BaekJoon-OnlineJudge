import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.*;

public class Main {

    static int min = Integer.MAX_VALUE;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i]=sc.nextInt();
        }

        int X = sc.nextInt();

        Arrays.sort(arr);

        int start =0;
        int end=N-1;

        int answer=0;

        // 두 원소의 합이 x와 같거나 x보다 더 크다 -> 시작점 한 칸 오른쪽으로 이동(시작점++)
        //  두 원소의 합이 x보다 작다 -> 끝 점 한 칸 왼쪽으로 이동(끝점--)
        while(start<end){
            int temp = arr[start]+arr[end];

            if(temp == X){
                answer++;
            }

            if(temp <= X){
                start++;
            }else{
                end--;
            }
        }

        System.out.println(answer);

    }

    static void sol(){
        return;
    }
}