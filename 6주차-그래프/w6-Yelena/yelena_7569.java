import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class yelena_7569{
    static class Tomato{
        private int r, c, h, cnt;

        public Tomato(int r, int c, int h, int cnt) {
            this.r = r;
            this.c = c;
            this.h = h;
            this.cnt = cnt;
        }

        public int getR() {
            return r;
        }

        public int getC() {
            return c;
        }

        public int getH() {
            return h;
        }

        public int getCnt() {
            return cnt;
        }

    }
    static int[][][] matrix = null;
    static int[] mr = {0,0,1,-1,0,0}, mc = {1,-1,0,0,0,0}, mh = {0,0,0,0,1,-1};
    static Queue<Tomato> q = new LinkedList<>();

    public static void main(String arg[]){
        int m = 0, n = 0, h = 0, remain = 0;
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            matrix = new int[n][m][h];

            int k = 0; // 높이 관련
            for(int i = 0; i < (n*h); i++){
                st = new StringTokenizer(br.readLine());
                if(i > 0 && i % n == 0) { k++; }
                for(int j = 0; j < m; j++){
                    matrix[i-(k*n)][j][k] = Integer.parseInt(st.nextToken());
                    if(matrix[i-(k*n)][j][k] == 1){
                        q.add(new Tomato(i-(k*n),j,k,0));
                    } else if (matrix[i-(k*n)][j][k] == 0){
                        remain++;
                    }
                }
            }
            br.close();
        } catch (IOException e){
            e.printStackTrace();
        }

        if(remain == 0) {
            System.out.print(0); return;
        }
        System.out.print(bfs(n,m,h, remain));
    }
    static int bfs(int n, int m, int h, int remain){
        int cnt = 0;

        while(!q.isEmpty()){
            Tomato t = q.poll();

            // 최고 갱신
            if(cnt < t.getCnt()) cnt = t.getCnt();

            // 순환
            for(int i = 0; i < 6; i++){
                int nextR = t.getR() + mr[i];
                int nextC = t.getC() + mc[i];
                int nextH = t.getH() + mh[i];
                if(nextR < 0 || nextR >= n || nextC < 0 || nextC >= m
                        || nextH < 0 || nextH >= h) continue;
                if(matrix[nextR][nextC][nextH] == 0){
                    matrix[nextR][nextC][nextH] = 1;
                    q.add(new Tomato(nextR,nextC,nextH, t.getCnt()+1));
                    remain--;
                }
            }
        }
        if(remain != 0) return -1;
        return cnt;
    }

}