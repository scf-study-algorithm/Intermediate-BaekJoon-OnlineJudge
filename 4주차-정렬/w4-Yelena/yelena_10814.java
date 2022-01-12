package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class member implements Comparable<member>{
    private int age;
    private String name;

    public member(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(member m){
        if(this.age < m.getAge()) return -1;
        else if(this.age > m.getAge()) return 1;
        else return 0;
    }
}
public class yelena_10814{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<member> members = new ArrayList<member>();
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            String nm = st.nextToken();
            members.add(new member(a,nm));
        }

        Collections.sort(members);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            sb.append(members.get(i).getAge() + " " + members.get(i).getName() + "\n");
        }
        System.out.print(sb);
    }
}
