import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class yelena_2667 {
    static int n = 0;
    static String[] map = null;
    static boolean[][] visited = null;
    static int mc[] = {0,0,1,-1}, mr[] = {1,-1,0,0};

    static class house{
        private int r, c;

        public house(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public int getR() {
            return r;
        }

        public int getC() {
            return c;
        }
    }
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try{
            n = Integer.parseInt(br.readLine());
            map = new String[n];
            visited = new boolean[n][n];
            for(int i = 0; i < n; i++){
                map[i] = br.readLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        // 방문
        int cnt = 0;
        ArrayList<Integer> houses = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j] && map[i].charAt(j) == '1'){
                    cnt++;
                    houses.add(bfs(i,j));
                }
            }
        }
        // 정렬
        Collections.sort(houses);

        // 출력
        StringBuilder sb = new StringBuilder();
        sb.append(cnt+"\n");
        for(int i = 0; i < houses.size(); i++){
            sb.append(houses.get(i) + "\n");
        }
        System.out.print(sb);
    }

    static int bfs(int r, int c){
        int num = 1;
        Queue<house> q = new LinkedList<>();
        q.add(new house(r,c));

        while(!q.isEmpty()){
            house h = q.poll();
            visited[h.getR()][h.getC()] = true;

            for(int i = 0; i < 4; i++){
                int nextR = h.getR()+mr[i];
                int nextC = h.getC()+mc[i];
                if(nextC < 0 || nextC >= n || nextR < 0 || nextR >= n) continue;
                if(!visited[nextR][nextC] && map[nextR].charAt(nextC) == '1'){
                    visited[nextR][nextC] = true;
                    q.add(new house(nextR,nextC));
                    num++;
                }
            }
        }

        return num;
    }
}