package bj1450;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] arr;
    static int n, c;
    static ArrayList<Integer> l = new ArrayList<>();
    static ArrayList<Integer> r = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        // 반을 쪼개
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        br.close();

        // 왼쪽 오른쪽 배열의 경우의 수 (무게) 구함
        dfs((n/2),0,0, false);
        dfs(n,(n/2),0, true);

        // 정렬
        Collections.sort(r);

        // 왼쪽을 기준으로 오른쪽 가능한 경우의 수를 합함(upperbound)
        int sum = 0;
        for(int i = 0; i < l.size(); i++){
            sum += upperbound(i);
        }

        System.out.println(sum);
    }
    static int upperbound(int t){
        int s = 0, e = r.size();
        while(s < e){
            int m = (s + e) / 2;
            if(r.get(m)+l.get(t) <= c) s = m+1;
            else e = m;
        }
        return s;
    }

    static void dfs(int e, int idx, int sum, boolean right){
        if(sum > c) return;
        if(idx >= e){
            if(right == true) r.add(sum);
            else l.add(sum);
            return;
        }

        dfs(e,idx+1,sum, right);
        dfs(e,idx+1,sum+arr[idx], right);
    }
}