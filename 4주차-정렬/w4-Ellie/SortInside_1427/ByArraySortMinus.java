package SortInside_1427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ByArraySortMinus {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String st = br.readLine();
//        String[] st2  = Stream.of(st.split("")).mapToInt(Integer::parseInt).sorted().mapToObj(String::valueOf).toArray(String[]:: new);
//        System.out.println(String.join("", st2));

        char[] ch = br.readLine().toCharArray();
        Arrays.sort(ch);

//        for (int i = 0; i <ch.length ; i++) {
//            System.out.print(ch[i]);
//        }
        for (int i = ch.length - 1; i >= 0; i--) {
            System.out.print(ch[i]);
        }

    }

}


