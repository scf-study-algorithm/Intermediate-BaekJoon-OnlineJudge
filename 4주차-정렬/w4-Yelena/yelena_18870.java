package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class pos implements Comparable<pos>{
    private int num;
    private int idx;

    public pos(int num, int idx) {
        this.num = num;
        this.idx = idx;
    }

    public int getIdx() {
        return idx;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public int compareTo(pos p){
        if(this.num < p.getNum()) return -1;
        else if(this.num > p.getNum()) return 1;
        else return 0;
    }
}
public class yelena_18870{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<pos> posList = new ArrayList<pos>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            posList.add(new pos(Integer.parseInt(st.nextToken()),i));
        }
        Collections.sort(posList);

        int prev = 0, order = -1;
        for(int i = 0; i < n; i++){
            if(i != 0 && prev == posList.get(i).getNum()){
                posList.get(i).setNum(order);
                continue;
            }
            prev = posList.get(i).getNum();
            posList.get(i).setNum(++order);
        }

        Comparator<pos> idxComparator = new Comparator<pos>() {
            @Override
            public int compare(pos o1, pos o2) {
                if(o1.getIdx() < o2.getIdx()) return -1;
                else return 1;
            }
        };
        Collections.sort(posList, idxComparator);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            sb.append(posList.get(i).getNum()+" ");
        }
        System.out.println(sb);
    }
}
