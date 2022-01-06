import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.*;

public class Main {

    static int min = Integer.MAX_VALUE;
    static int[] arr;
    static ArrayList<Integer> prime = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = sc.nextInt();

        sosus(N);

        int answer = sol(N,prime.size());
        System.out.println(answer);
    }

    static void sosus(int N){

        int cnt=0;
        int[] ch = new int[N+1];
        for(int i=2; i<=N; i++){
            if(ch[i]==0){
                cnt++;
                prime.add(i);
                for(int j=i; j<=N; j=j+i) {
                    ch[j] = 1;
                }
            }
        }
    }

    static int sol(int N,int M){
        int answer=0;
        int sum=0;
        int lt=0;

        for (int rt = 0; rt <M; rt++) {
            sum+=prime.get(rt);
            if(sum==N){
                answer++;
            }
            while(sum>=N){
                sum-=prime.get(lt++);
                if(sum==N){
                    answer++;
                }
            }
        }

        return answer;
    }
}

