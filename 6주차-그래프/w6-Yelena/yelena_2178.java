import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class yelena_2178 {
    static String[] map = null;
    static boolean[][] visited = null;
    static int[] mr = {0,0,1,-1}, mc = {1,-1,0,0};
    static class Maze{
        private int r, c, cnt;

        public Maze(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }

        public int getR() {
            return r;
        }

        public int getC() {
            return c;
        }

        public int getCnt() {
            return cnt;
        }
    }
    public static void main(String[] args){
        int n = 0, m = 0;
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            map = new String[n];
            visited = new boolean[n][m];

            for(int i = 0; i < n; i++){
                map[i] = br.readLine();
            }
            br.close();
        }catch (IOException e){
            e.printStackTrace();
        }

        System.out.print(bfs(n,m,0,0));
    }

    static int bfs(int n, int m, int r, int c){
        Queue<Maze> q = new LinkedList<>();
        q.add(new Maze(r,c,1));
        visited[r][c] = true;

        while(!q.isEmpty()){
            Maze cur = q.poll();

            if(cur.getR() == (n-1) && cur.getC() == (m-1)) return cur.getCnt();

            for(int i = 0; i < 4; i++){
                int nextR = cur.getR() + mr[i];
                int nextC = cur.getC() + mc[i];
                if(nextR < 0 || nextR >= n || nextC < 0 || nextC >= m) continue;
                if(!visited[nextR][nextC] && map[nextR].charAt(nextC) == '1'){
                    visited[nextR][nextC] = true;
                    q.add(new Maze(nextR,nextC,cur.getCnt()+1));
                }
            }
        }

        return 1;
    }
}