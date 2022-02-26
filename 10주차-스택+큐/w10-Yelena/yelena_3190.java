import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class yelena_3190 {
    static int[][] board = null; // 아무것도 없으면 0, 본인은 1, 사과는 2
    static int[] mr = {-1,0,1,0}, mc = {0,1,0,-1}; // 동서남북
    // 방향 D : 0-1-2-3 , 방향 L : 0-3-2-1
    static Map<Integer,Character> dir = new HashMap<>();
    static int n = 0;
    static class Pos{
        private int r;
        private int c;

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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        board = new int[n+1][n+1];
        // 사과 위치
        for(int i = 0; i < k; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            board[r][c] = 2;
        }

        // 방향 변환
        int l = Integer.parseInt(br.readLine());
        for(int i = 0; i < l; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            char d = st.nextToken().charAt(0);
            dir.put(t,d);
        }

        // 뱀 dfs
        System.out.println(dfs(1,1,1));
    }

    static int dfs(int r, int c, int direct){

        int time = 0;
        int curR = r;
        int curC = c;

        // 뱀의 몸을 좌표로 기록
        Deque<Pos> snakePos = new LinkedList<>();
        snakePos.add(new Pos(r,c));
        board[r][c] = 1;

        while(true){

            // 방향으로 나아가기
            curR = curR + mr[direct];
            curC = curC + mc[direct];
            time++;
            System.out.println("time"+ time +" : "+curR + " " + curC);

            // 벽 부딪히면 끝
            if(curR <= 0 || curR > n || curC <= 0 || curC > n) break;

            // 자기몸에 부딪힘
            if(board[curR][curC] == 1) break;

            // 사과가 없으면 꼬리 없애기
            if(board[curR][curC] != 2){
                Pos tail = snakePos.pollFirst();
                board[tail.getR()][tail.getC()] = 0;
            }
            board[curR][curC] = 1;
            snakePos.add(new Pos(curR,curC));

            // 시간이 방향 바꾸는 시간이면 바꾸기
            if(dir.containsKey(time)){
                if(dir.get(time) == 'D'){
                    direct = (direct+1)%4;
                } else{
                    direct = (direct+3)%4;
                }
            }
        }

        return time;
    }
}