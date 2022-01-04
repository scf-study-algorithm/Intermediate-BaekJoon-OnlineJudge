package BOJ;
//https://www.acmicpc.net/problem/1644
import java.util.*;
public class BOJ_1644 {

/*    순서
    1. 2~N까지 모든 소수에 대해 for loop를 돌면서 sum에 넣음
    2. sum에 더해질 때마다 같이 count
        2.1 sum이 더해질때 더해진 숫자가 소수라고 판단되면 count는 1로 재설정(순차적으로 더해져 왔기 때문에)
    3. sum이 N과 같아지면 break, count 리턴

   */

    public static ArrayList<Integer> primes;
    public static boolean[] isPrime;
    public static int N;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        int sum = 0;
        int count = 0;
        int start = 0;
        int end = 0;
        primes = new ArrayList<Integer>();
        isPrime = new boolean[N+1];
        isPrime[0] = true; isPrime[1]= true;
        for(int i = 2; i*i <= N; i++) { //N의 약수는 2~2/N까지 존재 => 2부터 루트 N까지 존재
                if(!isPrime[i]){ //false 일때
                    for(int j = i*i; j<=N; j+=i){ //소수일때 true
                        isPrime[j] = true;
                    }
                }

        }

        for(int k=1; k<=N; k++){
            if(!isPrime[k]){
                primes.add(k);
            }
        }

        while (true){
            if(sum >= N){
                sum -= primes.get(start++);
            }else if(end == primes.size()){
                break;
            }else {
                sum += primes.get(end++);
            }
            if(N==sum){
                count++;
            }
        }

        System.out.println(count);
        }


    }

