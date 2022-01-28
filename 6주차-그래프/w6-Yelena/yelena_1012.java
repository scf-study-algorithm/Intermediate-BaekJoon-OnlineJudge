import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class yelena_1012{
    static int[][] earth = null;
    static boolean[][] visited = null;
    static int[] mr = {0,0,1,-1}, mc = {1,-1,0,0};

    static class Plant{
        private int r, c;

        public Plant(int r, int c) {
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
        int testCaseNum = 0;
        ArrayList<Integer> answer = new ArrayList<>();

        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            testCaseNum = Integer.parseInt(br.readLine());

            while(--testCaseNum >= 0){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int m = Integer.parseInt(st.nextToken());
                int n = Integer.parseInt(st.nextToken());
                int k = Integer.parseInt(st.nextToken());

                earth = new int[m][n];
                visited = new boolean[m][n];

                for(int i = 0; i < k; i++){
                    st = new StringTokenizer(br.readLine());
                    int r = Integer.parseInt(st.nextToken());
                    int c = Integer.parseInt(st.nextToken());
                    earth[r][c] = 1;
                }

                int cnt = 0;
                for(int i = 0; i < m; i++){
                    for(int j = 0; j < n; j++){
                        if(!visited[i][j] && earth[i][j] == 1){
                            bfs(m,n,i,j);
                            cnt++;
                        }
                    }
                }
                answer.add(cnt);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < answer.size(); i++){
            sb.append(answer.get(i) + "\n");
        }
        System.out.print(sb);
    }

    static void bfs(int m, int n, int r, int c){
        Queue<Plant> q = new LinkedList<>();
        q.add(new Plant(r,c));
        visited[r][c] = true;

        while(!q.isEmpty()){
            Plant p = q.poll();

            for(int i = 0; i < 4; i++){
                int nextR = p.getR() + mr[i];
                int nextC = p.getC() + mc[i];
                if(nextR < 0 || nextR >= m || nextC < 0 || nextC >= n) continue;
                if(!visited[nextR][nextC] && earth[nextR][nextC] == 1){
                    visited[nextR][nextC] = true;
                    q.add(new Plant(nextR,nextC));
                }

            }
        }
    }
}