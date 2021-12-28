import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {

    static int[] fibo;
    public static void main(String[] args) throws IOException{

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        //배열 생성
        fibo=new int[N+1];
        Fibo(N);
        System.out.println(fibo[N]);
        return;
    }

    public static int Fibo(int n){
        if(fibo[n]>0){ //fibo 값이 이미 구해져 있다면 그걸 쓴다.
            return fibo[n];
        }
        if(n==1 || n==2){
            return fibo[n]=1;
        }
        return fibo[n]= Fibo(n-2)+Fibo(n-1);
    }
}

