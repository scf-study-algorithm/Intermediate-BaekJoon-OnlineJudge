import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.*;

public class Main {

//    static int min = Integer.MAX_VALUE;
//    static int[] arr;
//    static ArrayList<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
//        String str = sc.next();
//        System.out.println(str);
        String[][] arr = new String[N][2];

        sc.nextLine();
        for (int i = 0; i < N; i++) {
            arr[i][0]=sc.next();
            arr[i][1]=sc.next();
        }

        Arrays.sort(arr, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {

                return Integer.parseInt(o1[0])-Integer.parseInt(o2[0]);
            }
        });

        for (int i = 0; i < N; i++) {
            System.out.println(arr[i][0]+" "+arr[i][1]);
        }

    }


    static void sol(){


    }

}