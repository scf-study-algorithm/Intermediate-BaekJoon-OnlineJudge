import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException{

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        //배열 생성
        if(N ==0 ){
            System.out.println(1);
            return;
        }
        System.out.println(factorial(N));
        return;
    }

    static int factorial(int n){
        if(n==1){
            return 1;
        }else {
            return n*factorial(n-1);
        }
    }
}