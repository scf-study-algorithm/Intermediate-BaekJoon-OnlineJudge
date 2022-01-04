import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int temp = i;
            int sum=0;

            //분해합 생성
            while(temp !=0){
                sum+=temp%10;
                temp /= 10;
            }

            if(sum+i == N){
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
}