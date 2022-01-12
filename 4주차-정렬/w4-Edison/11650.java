import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.*;

class Point implements Comparable<Point>{
    public int x, y;
    Point(int x, int y){
        this.x=x;
        this.y=y;
    }

    //정렬 기준 설정
    @Override
    public int compareTo(Point o){
        if(this.x==o.x) return this.y-o.y;
        else return this.x-o.x;
    }
}

public class Main {

//    static int min = Integer.MAX_VALUE;
//    static int[] arr;
//    static ArrayList<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = sc.nextInt();

        ArrayList<Point> arr=new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int x=sc.nextInt();
            int y=sc.nextInt();
            arr.add(new Point(x,y));
        }

        Collections.sort(arr);
        //Point compable을 통해 정렬된다.

        for (Point o : arr) {
            System.out.println(o.x+" "+o.y);
        }

    }


    static void sol(){

        return;
    }

}