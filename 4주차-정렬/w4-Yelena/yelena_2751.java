package sort;

import java.io.*;

public class bj2751 {
    static int[] arr, tmp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n];
        tmp = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());
        br.close();

        //Arrays.sort(arr);
        mergeSort(0,n-1);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            sb.append(arr[i] + "\n");
        }
        bw.write(String.valueOf(sb));
        bw.flush();
    }
    static void mergeSort(int left, int right){
        if(left < right){
            int mid = (left+right) / 2;
            mergeSort(left, mid);
            mergeSort(mid+1, right);

            int p = left, idx = left;
            int q = mid + 1;

            while(p <= mid || q <= right){
                if(q > right || (p <= mid && arr[p] < arr[q]))
                    tmp[idx++] = arr[p++];
                else
                    tmp[idx++] = arr[q++];
            }

            for(int i = left; i <= right; i++)
                arr[i] = tmp[i];
        }
    }
}
