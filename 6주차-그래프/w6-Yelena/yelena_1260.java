import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class yelena_1260 {
    static int[] input = new int[3];
    static Vector<Integer>[] graph;
    static boolean[] visited = null;
    static StringBuilder sb = null;

    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            // n,m,s 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 3; i++){
                input[i] = Integer.parseInt(st.nextToken());
            }

            // 그래프 크기
            graph = new Vector[input[0]];
            for(int i = 0; i < input[0]; i++){
                graph[i] = new Vector<>();
            }
            // 간선 리스트 받기
            for(int i = 0; i < input[1]; i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                graph[s-1].add(e-1);
                graph[e-1].add(s-1);
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        // 정렬
        for(int i = 0; i < input[0]; i++){
            Collections.sort(graph[i]);
        }

        // dfs 실행
        visited = new boolean[input[0]];
        visited[input[2]-1] = true;
        sb = new StringBuilder();
        dfs(input[2]-1);
        sb.append("\n");

        // bfs 실행
        bfs();
        System.out.print(sb);
    }
    static void dfs(int idx){

       sb.append((idx+1) + " ");

        for(int i = 0; i < graph[idx].size(); i++){
            if(!visited[graph[idx].get(i)]){
                visited[graph[idx].get(i)] = true;
                dfs(graph[idx].get(i));
            }
        }
    }

    static void bfs(){

        Queue<Integer> q = new LinkedList<>();
        q.add(input[2]-1);
        visited = new boolean[input[0]];
        visited[input[2]-1] = true;

        while(!q.isEmpty()){
            int n = q.poll();
            sb.append((n+1) + " ");

            for(int i = 0; i < graph[n].size(); i++){
                if(!visited[graph[n].get(i)]){
                    visited[graph[n].get(i)] = true;
                    q.add(graph[n].get(i));
                }
            }
        }
    }
}