package SortInside_1427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class ByStream {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();
        String[] st2 = Stream.of(st.split("")).mapToInt(Integer::parseInt).sorted().mapToObj(String::valueOf).toArray(String[]::new);
        System.out.println(String.join("", st2));
    }
}


