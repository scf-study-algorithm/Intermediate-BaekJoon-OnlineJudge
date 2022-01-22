import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class yelena_2529 {
    static int n = 0;
    static long min = -1, max = -1;
    static String minStr = "", maxStr = "";
    static boolean[] visited = new boolean[10];
    static int[] numberList;
    static char[] inequal;

    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            n = Integer.parseInt(br.readLine());
            numberList = new int[n+1];
            inequal = new char[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                String s = st.nextToken();
                inequal[i] = s.charAt(0);;
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        for(int i = 0; i <= 9; i++){
            visited[i] = true;
            numberList[0] = i;
            backTracking(1);
            visited[i] = false;
        }

        System.out.print(maxStr + "\n" + minStr);
    }
    static void backTracking(int cnt){
        if(cnt >= (n+1)){
            checkMinMax();
            return;
        }

        for(int i = 0; i <= 9; i++){
            if(!visited[i] && isTrue(cnt-1, i)){
                visited[i] = true;
                numberList[cnt] = i;
                backTracking(cnt+1);
                visited[i] = false;
            }
        }
    }
    static boolean isTrue(int idx, int cur){
        int prev = numberList[idx];
        if(inequal[idx] == '<'){
            return (prev < cur);
        } else{
            return (prev > cur);
        }
    }
    static void checkMinMax(){
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < n+1; i++){
            s.append(numberList[i]);
        }

        long num = Long.parseLong(s.toString());
        if(min == -1 || min > num){
            min = num;
            minStr = s.toString();
        }

        if(max == -1 || max < num){
            max = num;
            maxStr = s.toString();
        }
        return ;
    }
}
