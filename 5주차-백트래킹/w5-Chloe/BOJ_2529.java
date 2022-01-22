package BOJ;
//https://www.acmicpc.net/problem/2529
import java.util.*;

public class BOJ_2529 {
    public static char[] ch = new char[10];
    public static boolean[] visited = new boolean[10]; // 0~9까지 check;
    public static int k;
    public static List<String> answer = new ArrayList<>();

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        k = in.nextInt();
        //ch = new char[k];
        for(int i=0; i<k; i++){
            ch[i] = in.next().charAt(0);
        }

        dfs("",0);
        Collections.sort(answer);

        System.out.println(answer.get(answer.size()-1));
        System.out.println(answer.get(0));

    }

    public static void dfs(String s, int idx){
        if (idx == k + 1) {
            answer.add(s);
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (visited[i]) continue;
            if (idx == 0 || check(Character.getNumericValue(s.charAt(idx - 1)), i, ch[idx - 1])) {
                visited[i] = true;
                dfs(s + i, idx + 1);
                visited[i] = false;
            }
        }
    }

    public static boolean check(int a, int b, char c) { //숫자 비교
        if (c == '<') {
            if (a > b) return false;
        } else if (c == '>') {
            if (a < b) return false;
        }
        return true;
    }
}
