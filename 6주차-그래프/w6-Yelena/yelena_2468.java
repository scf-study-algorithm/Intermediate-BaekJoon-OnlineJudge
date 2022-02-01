import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class yelena_2468{
    static int[][] island = null;
    static boolean[][] visited = null;
    static int[] mr = {0,0,1,-1}, mc = {1,-1,0,0};

    static class Pos{
        private int r, c;

        public Pos(int r, int c) {
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

    public static void main(String args[]){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int hMax = -1, hMin = -1;
        int cnt = 1;
        try{
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            // input
            island = new int[n][n];

            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++){
                    island[i][j] = Integer.parseInt(st.nextToken());
                    if(hMax == -1 || hMax < island[i][j]){
                        hMax = island[i][j];
                    }
                    if(hMin == -1 || hMin > island[i][j]){
                        hMin = island[i][j];
                    }
                }
            }

            // bfs
            for(int k = hMin; k <= hMax; k++){
                visited = new boolean[n][n];
                int tmp = 0;
                for(int i = 0; i < n; i++){
                    for(int j = 0; j < n; j++){
                        if(!visited[i][j] && island[i][j] > k){
                            bfs(n,k,i,j);
                            tmp++;
                        }
                    }
                }
                if(tmp >= cnt) cnt = tmp;
            }

        }catch (IOException e){
            e.printStackTrace();
        }

        // output
        System.out.println(cnt);
    }
    static void bfs(int n, int k, int r, int c){
        visited[r][c] = true;
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(r,c));

        while(!q.isEmpty()){
            Pos pos = q.poll();

            for(int i = 0; i < 4; i++){
                int nextR = pos.getR() + mr[i];
                int nextC = pos.getC() + mc[i];
                if(nextR < 0 || nextR >= n || nextC < 0 || nextC >= n) continue;
                if(!visited[nextR][nextC] && island[nextR][nextC] > k){
                    visited[nextR][nextC] = true;
                    q.add(new Pos(nextR,nextC));
                }
            }
        }
    }
}