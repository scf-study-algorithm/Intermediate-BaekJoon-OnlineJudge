package bj1644;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static boolean[] arr1;
    static List<Integer> arr2 = new ArrayList<>();
    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        arr1 = new boolean[n+1];

        if(n == 1) { System.out.print(0); return;}
        for(int i = 2; i * i <= n; i++){
            if (!arr1[i]) {
                for (int j = i * i; j <= n; j += i) {
                    arr1[j] = true;
                }
            }
        }
        for(int i = 2; i <= n; i++){
            if(!arr1[i]) arr2.add(i);
        }

        int ans = 0, cnt = arr2.size();
        int sum = 0, s = 0, e = 0;
        while(s <= e && e <= cnt){

            if(sum == n) ans++;
            if(sum <= n){
                if(e < cnt) sum += arr2.get(e);
                e++;
            }
            else{
                if(s < cnt) sum -= arr2.get(s);
                s++;
            }
        }
        System.out.println(ans);
    }
}