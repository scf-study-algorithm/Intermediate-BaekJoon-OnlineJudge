import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
//    public static StringBuilder sb = new StringBuilder();
    static char[] arr;
    public static void main(String[] args) throws IOException{

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        String str="";

        while((str = br.readLine()) != null) {

//            Scanner sc = new Scanner(System.in);
//            int N = sc.nextInt();

            int N = Integer.parseInt(str);
//            System.out.println(N);
            int length = (int) Math.pow(3, N);
            arr = new char[length];

//            if (N == 0) {
//                System.out.println("-");
//            }

            for (int i = 0; i < length; i++) {
                arr[i] = ' ';
            }
            sol(length, 0, length - 1);
            for (int i = 0; i < length; i++) {
//                System.out.print(arr[i]);
                bw.write(arr[i]);
            }
            bw.write("\n");
            bw.flush();
        }
    }

    static void sol(int N,int start,int end){

        if(N==1){
            //모든 선의 길이가 1
            arr[start] = '-';
            return;
        }

        int next = N/3;
        //맨앞 나눠
        sol(next,start,start+next-1);
        //맨뒤 나뒤
        sol(next,end-next+1,end);

    }
}

