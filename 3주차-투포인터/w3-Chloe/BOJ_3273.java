package BOJ;
import java.io.*;
import java.util.*;

public class BOJ_3273 {

    public static void main(String[] args) throws IOException {


        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] num = new int[n];
        for(int i = 0; i< n; i++){
            num[i] = scanner.nextInt();
        }
        int x = scanner.nextInt();

        Arrays.sort(num);

        int start = 0;
        int end = n - 1;
        long result = 0;
        while (start < end) {
            if(num[start] + num[end] == x){
                result ++;
            }
//else if로 하면 시간초과
            if(num[start] + num[end] > x){
                end--;
            }else{
                start++;
            }
        }
        System.out.println(result);

    }
}
