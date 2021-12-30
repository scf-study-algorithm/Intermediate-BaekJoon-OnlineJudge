package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int input = in.nextInt();

        System.out.println(fibo(input));
    }

    static int fibo(int n){
        if(n <= 1) return n;
        return fibo(n-2) + fibo(n-1);
    }
}
