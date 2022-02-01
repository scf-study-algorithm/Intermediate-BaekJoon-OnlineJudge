import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class yelena_4963{
    static int[][] island = null;
    static int[] mr = {0,0,1,-1,1,1,-1,-1}, mc = {1,-1,0,0,1,-1,1,-1};
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
        ArrayList<Integer> answer = new ArrayList<>();

        try{
            int cnt = 0;
            while(true){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int m = Integer.parseInt(st.nextToken());
                int n = Integer.parseInt(st.nextToken());
                // exit
                if(n == 0 && m == 0) break;
                // input
                island = new int[n][m];
                for(int i = 0; i < n; i++){
                    st = new StringTokenizer(br.readLine());
                    for(int j = 0; j < m; j++){
                        island[i][j] = Integer.parseInt(st.nextToken());
                    }
                }

                // bfs
                cnt = 0;
                for(int i = 0; i < n; i++){
                    for(int j = 0; j < m; j++){
                        if(island[i][j] == 1){
                            bfs(n,m,i,j);
                            cnt++;
                        }
                    }
                }
                answer.add(cnt);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        // output
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < answer.size(); i++){
            sb.append(answer.get(i) + "\n");
        }
        System.out.println(sb);
    }
    static void bfs(int n, int m, int r, int c){
        island[r][c] = 0;
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(r,c));

        while(!q.isEmpty()){
            Pos pos = q.poll();

            for(int i = 0; i < 8; i++){
                int nextR = pos.getR() + mr[i];
                int nextC = pos.getC() + mc[i];
                if(nextR < 0 || nextR >= n || nextC < 0 || nextC >= m) continue;
                if(island[nextR][nextC] == 1){
                    island[nextR][nextC] = 0;
                    q.add(new Pos(nextR,nextC));
                }
            }
        }
    }
}