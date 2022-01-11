package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class dot implements Comparable<dot>{
    private int x;
    private int y;

    public dot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int compareTo(dot d){
        if(this.x < d.getX()) return -1;
        else if(this.x > d.getX()) return 1;
        else{
            if(this.y < d.getY()) return -1;
            else if(this.y > d.getY()) return 1;
            else return 0;
        }
    }
}
public class yelena_11650 {

    public static void main(String[] args) throws IOException {
        List<dot> dotList = new ArrayList<dot>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i = 0; i < n; i++){
            st =  new StringTokenizer(br.readLine());
            int xx = Integer.parseInt(st.nextToken());
            int yy = Integer.parseInt(st.nextToken());
            dotList.add(new dot(xx,yy));
        }

        Collections.sort(dotList);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            sb.append(dotList.get(i).getX() + " " + dotList.get(i).getY() + "\n");
        }
        System.out.println(sb);
    }
}
