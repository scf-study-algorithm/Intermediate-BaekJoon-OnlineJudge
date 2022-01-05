package bj1806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        int n, s;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 작으면 추가하고 크면 크면 감소시키기
        int i = 0, j = 0;
        int sum = 0, ans = -1;
        while(j <= n && i <= j){
            // 작으면
            if(sum < s){
                if(j < n) sum += arr[j];
                j++;
            }
            // 크면
            else{
                if(i < n) sum -= arr[i];
                i++;
            }

            // 같으면
            if(sum >= s){
                if(ans == -1 || ans > (j-i)){
                    ans = j-i;
                }
                if(ans == 1) break;
            }
            System.out.println("sum : " + sum + " i : " + i + " j : " + j);
        }

        // 출력
        if(ans == -1) System.out.print(0);
        else System.out.print(ans);
    }
}