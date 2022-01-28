import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.Vector;

public class yelena_2606 {
    static Vector<Integer>[] graph = null;
    static int n = 0, m = 0;
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            n = Integer.parseInt(br.readLine());
            m = Integer.parseInt(br.readLine());

            graph = new Vector[n];
            for(int i = 0; i < graph.length; i++){
                graph[i] = new Vector<>();
            }

            for(int i = 0; i < m; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                graph[s-1].add(e-1);
                graph[e-1].add(s-1);
            }

        } catch (IOException e){
            e.printStackTrace();
        }

        // bfs 실행
        System.out.print(bfs());

    }
    static int bfs(){
        int cnt = 0;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;

        while(!q.isEmpty()){
            int v = q.poll();

            for(int i = 0; i < graph[v].size(); i++){
                if(!visited[graph[v].get(i)]){
                    visited[graph[v].get(i)] = true;
                    q.add(graph[v].get(i));
                    cnt++;
                }
            }
        }

        return cnt;
    }
}