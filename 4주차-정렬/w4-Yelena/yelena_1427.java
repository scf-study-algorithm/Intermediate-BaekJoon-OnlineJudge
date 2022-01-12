package sort;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int[] arr;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String n = in.nextLine();
        arr = new int[n.length()];

        for(int i = 0; i < n.length(); i++){
            arr[i] = n.charAt(i)-'0';
        }
        Arrays.sort(arr);
        int sum = 0, idx = 1;
        for(int i = 0; i < arr.length; i++){
            sum += (arr[i] * idx);
            idx *= 10;
        }
        System.out.println(sum);
    }
}
