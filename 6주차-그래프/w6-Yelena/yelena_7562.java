import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class yelena_7562 {
    static int[] mr = {-2,-2,-1,-1,1,1,2,2,}, mc = {-1,1,-2,2,-2,2,-1,1};
    static class Night{
        private int r, c, cnt;

        public Night(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
        public int getR() { return r; }
        public int getC() { return c; }
        public int getCnt() { return cnt; }
    }

    public static void main(String[] args){
        int testCase = 0;
        ArrayList<Integer> answer = new ArrayList<>();

        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            testCase = Integer.parseInt(br.readLine());
            while(--testCase >= 0){
                int n = Integer.parseInt(br.readLine());

                // 시작, 도착 좌표
                StringTokenizer st = new StringTokenizer(br.readLine());
                int sr = Integer.parseInt(st.nextToken());
                int sc = Integer.parseInt(st.nextToken());

                st = new StringTokenizer(br.readLine());
                int er = Integer.parseInt(st.nextToken());
                int ec = Integer.parseInt(st.nextToken());

                answer.add(bfs(n,sr,sc,er,ec));
            }
            br.close();
        }catch (IOException e){
            e.printStackTrace();
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < answer.size(); i++){
            sb.append(answer.get(i)+"\n");
        }
        System.out.print(sb);
    }
    static int bfs(int n, int sr, int sc, int er, int ec){
        if(sr == er && sc == ec) return 0;

        int cnt = 0;
        boolean[][] visited = new boolean[n][n];
        Queue<Night> q = new LinkedList<>();
        q.add(new Night(sr,sc,0));
        visited[sr][sc] = true;

        while(!q.isEmpty()){
            Night night = q.poll();

            if(night.getR() == er && night.getC() == ec) return night.getCnt();

            for(int i = 0; i < 8; i++){
                int nextR = night.getR() + mr[i];
                int nextC = night.getC() + mc[i];
                if(nextR < 0 || nextR >= n || nextC <0 || nextC >= n) continue;
                if(!visited[nextR][nextC]){
                    visited[nextR][nextC] = true;
                    q.add(new Night(nextR,nextC,night.getCnt()+1));
                }
            }
        }
        return cnt;
    }
}
