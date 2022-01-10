package sort;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class bj2108 {
    static int[] arr;
    static int mn = 1, n , sum = 0;
    static int[] num = new int[8001];
    static ArrayList<Integer> m = new ArrayList<Integer>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
            chk(arr[i]);
        }
        br.close();

        Arrays.sort(arr);
        Collections.sort(m);
        printStat();
    }
    static void chk(int i){
        int idx = i + 4000;
        if(++num[idx] > 1 && num[idx] == mn)
            m.add(i);
        else if(num[idx] > mn){
            m.clear();
            m.add(i);
            mn = num[idx];
        }
    }
    static void printStat(){
        StringBuilder sb = new StringBuilder();

        // 1. 산술평균 (반올림)
        sb.append(Math.round((float) sum/n) + "\n");
        // 2. 중앙값
        sb.append(arr[(n/2)] + "\n");
        // 3. 최빈값
        if(n == 1)
            sb.append(arr[0] + "\n");
        else if(mn == 1)
            sb.append(arr[1] + "\n");
        else if(m.size() > 1)
            sb.append(m.get(1) + "\n");
        else
            sb.append(m.get(0) + "\n");
        // 4. 범위
        sb.append(arr[n-1]-arr[0]);

        System.out.print(sb);
    }
}