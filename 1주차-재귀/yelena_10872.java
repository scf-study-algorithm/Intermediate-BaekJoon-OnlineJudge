package bj10872;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        System.out.println(fact(input));
    }
    static int fact(int n){
        if(n <= 1) return 1;
        return n * fact(n-1);
    }
}
