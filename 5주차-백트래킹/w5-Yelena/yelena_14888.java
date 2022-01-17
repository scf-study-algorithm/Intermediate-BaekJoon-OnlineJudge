import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class yelena_14888 {
    static int n = 0, minN = 1000000000, maxN = -1000000000;
    static int[] arr, operator = new int[4], used = new int[4];

    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            n = Integer.parseInt(br.readLine());

            arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 4; i++){
                operator[i] = Integer.parseInt(st.nextToken());
            }

        } catch (IOException e){
            e.printStackTrace();
        }

        dfs(0,arr[0]);

        System.out.print(maxN+"\n"+minN);
    }
    static void dfs(int idx, int result){

        if(idx >= (n-1)){
            if(minN > result) minN = result;
            if(maxN < result) maxN = result;
        }

        for(int i = 0; i < 4; i++){
            if(operator[i] - used[i] <= 0) continue;
            used[i] += 1;
            dfs(idx+1,calcNum(result,arr[idx+1],i));
            used[i] -= 1;
        }
    }

    static int calcNum(int a, int b, int idx){
        if(idx == 0){
            return a + b;
        }else if(idx == 1){
            return a - b;
        }else if(idx == 2){
            return a * b;
        }else{
            return a / b;
        }
    }
}