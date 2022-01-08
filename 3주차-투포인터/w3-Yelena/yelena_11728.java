package bj11728;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr1,arr2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, m;

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr1 = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            arr1[i] = Integer.parseInt(st.nextToken());

        arr2 = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++)
            arr2[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int i = 0, j = 0;
        StringBuilder sb = new StringBuilder();
        while (i < n || j < m) {
            if(i >= n|| j >= m){
                if(i >= n){
                    sb.append(arr2[j] + " ");
                    j++;
                }
                else if(j >= m){
                    sb.append(arr1[i] + " ");
                    i++;
                }
                continue;
            }

            if(arr1[i] <= arr2[j]) {
                sb.append(arr1[i] + " ");
                i++;
            }
            else {
                sb.append(arr2[j] + " ");
                j++;
            }
        }
        System.out.println(sb);
    }
}
