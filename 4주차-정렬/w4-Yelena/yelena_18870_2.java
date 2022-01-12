package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] arr1 = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int tmp = Integer.parseInt(st.nextToken());
            arr[i] = tmp;
            arr1[i] = tmp;
        }

        Arrays.sort(arr1);
        Map<Integer, Integer> m = new HashMap<>();
        int prev = 0, order = -1;
        for(int i = 0; i < n; i++){
            if(i != 0 && prev == arr1[i]) continue;
            prev = arr1[i];
            m.put(arr1[i], ++order);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            sb.append(m.get(arr[i]) +" ");
        }
        System.out.println(sb);
    }
}