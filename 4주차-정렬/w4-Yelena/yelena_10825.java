package bj10825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class student implements Comparable<student>{
    private String name;
    private int ko;
    private int eng;
    private int mt;

    public student(String name, int ko, int eng, int mt) {
        this.name = name;
        this.ko = ko;
        this.eng = eng;
        this.mt = mt;
    }

    public String getName() {
        return name;
    }

    public int getKo() {
        return ko;
    }

    public int getEng() {
        return eng;
    }

    public int getMt() {
        return mt;
    }

    public int compareTo(student st){
        if(this.ko == st.getKo()){
            if(this.eng == st.getEng()){
                if(this.mt == st.getMt()){
                    return this.name.compareTo(st.getName());
                }
                return st.getMt()- this.mt;
            }
            return this.eng - st.getEng();
        }
        return st.getKo() - this.ko;

    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<student> students = new ArrayList<student>();

        StringTokenizer st;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int k = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            students.add(new student(s,k,e,m));
        }

        Collections.sort(students);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            sb.append(students.get(i).getName() + "\n");
        }
        System.out.print(sb);
    }
}
