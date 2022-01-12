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
        String[] arr = new String[N];

        sc.nextLine();
        for (int i = 0; i < N; i++) {
            arr[i]=sc.nextLine();
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()==o2.length()){
                    //단어 사전순 정렬은 대부분 알고있겠지만 compareTo() 메소드를 쓰면 된다.
                    return o1.compareTo(o2);
                }else{
                    //단어길이를 비교후 같을 경우 사전순으로 정렬
                    return o1.length()-o2.length();
                }
            }
        });

        System.out.println(arr[0]);
        for (int i = 1; i <N ; i++) {
            if(!arr[i].equals(arr[i-1])){
                System.out.println(arr[i]);
            }
//            System.out.println(arr[i]);
        }

//        System.out.println(sb);

    }


    static void sol(){


    }

}