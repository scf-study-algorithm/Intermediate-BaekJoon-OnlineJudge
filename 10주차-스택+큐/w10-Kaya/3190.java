import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    // up, right, down, left
    public static int[] dr = {-1, 0, 1, 0};
    public static int[] dc = {0, 1, 0, -1};
    public static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int appleCnt = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<appleCnt; i++){
            st = new StringTokenizer(br.readLine());
            int appleRow = Integer.parseInt(st.nextToken())-1;
            int appleCol = Integer.parseInt(st.nextToken())-1;
            map[appleRow][appleCol] = 1;
        }

        int K = Integer.parseInt(br.readLine());
        LinkedList<String[]> cmd = new LinkedList<>();
        for(int i=0; i<K; i++){
            String[] temp = br.readLine().split(" ");
            cmd.add(temp);
        }

        Deque<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0});
        int sec = 0;
        String[] dir = {"up","right","down","left"};
        String d = dir[1];
        int idx = 1;
        while(true){
            sec++;
            int[] now = Arrays.copyOf(q.getLast(), q.getLast().length);
            if(!cmd.isEmpty() && Integer.parseInt(cmd.peek()[0]) == sec-1){
                String c = cmd.poll()[1];
                if(c.equals("L")){
                    idx -= 1;
                    if (idx < 0){
                        idx = 3;
                    }
                }
                else {
                    idx += 1;
                    if(idx == 4){
                        idx = 0;
                    }
                }
                d = dir[idx];
            }
            switch (d){
                case "up":
                    now[0] += dr[0];
                    now[1] += dc[0];
                    break;
                case "right":
                    now[0] += dr[1];
                    now[1] += dc[1];
                    break;
                case "down":
                    now[0] += dr[2];
                    now[1] += dc[2];
                    break;
                case "left":
                    now[0] += dr[3];
                    now[1] += dc[3];
                    break;
                default:
                    break;
            }
            if(now[0] < 0 || now[0] >= N || now[1] < 0 || now[1] >= N || visited[now[0]][now[1]]) {
                break;
            }

            q.addLast(now);
            visited[now[0]][now[1]] = true;
            if(map[now[0]][now[1]] != 1){
                int[] temp = q.getFirst();
                visited[temp[0]][temp[1]] = false;
                q.removeFirst();
            }
            else {
                map[now[0]][now[1]] = 0;
            }
        }
        System.out.println(sec);
    }
}

