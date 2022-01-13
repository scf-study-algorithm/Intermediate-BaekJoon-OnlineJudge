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

//        int N = sc.nextInt();
        String str = sc.next();
//        System.out.println(str);

        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i)-'0');
        }

        Collections.sort(list,Comparator.reverseOrder());

        for(int value : list) {
            sb.append(value);
        }

        System.out.println(sb);

    }


    static void sol(){


    }

}