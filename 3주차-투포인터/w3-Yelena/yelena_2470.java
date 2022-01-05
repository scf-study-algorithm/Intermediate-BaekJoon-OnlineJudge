package w3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.abs;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int mn = -1;
        int ans1 = 0, ans2 = 0;

        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        Arrays.sort(arr);
        int l = 0, r = arr.length-1;
        while(l < r){
            int tmp = abs(arr[l] + arr[r]);
            if(mn == -1 || mn > tmp) {
                mn = tmp;
                ans1 = arr[l];
                ans2 = arr[r];
            }
            if(tmp == 0) break;

            // 더한 값이 양수면 오른쪽 이동
            if(arr[l] + arr[r] > 0) r--;
            // 더한 값이 음수면 왼쪽 이동
            else l++;
        }
        System.out.println(ans1 + " " + ans2);
    }
}
