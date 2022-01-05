package bj2w_1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static char ch[];
    static int l,c;
    static char[] dic;
    //static String dic = "";
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        l = in.nextInt();
        c = in.nextInt();

        ch = new char[c];
        dic = new char[l];
        for(int i = 0; i < c; i++){
            ch[i] = (char)in.next().charAt(0);
        }

        Arrays.sort(ch);
        dfs(0,0);
    }

    static void dfs(int idx, int cnt){
        int cnt0 = cnt;

        if(c-idx+1 < l-cnt || cnt > l) return;

        if(cnt == l){
            // 자음, 모음 개수 확인 후 출력
            int a = 0,b = 0;
            boolean chk = false;
            for(int i = 0; i < cnt; i++){
                if(dic[i] == 'a' || dic[i] == 'e' || dic[i] == 'i' || dic[i] == 'o' || dic[i] == 'u')
                    a++;
                else b++;
                if(a >= 1 && b >= 2) {chk = true; break;}
            }
            if(chk) System.out.println(dic);
            return;
        }

        for(int i = idx; i < c; i++){
            dic[cnt0] = ch[i];
            dfs(i+1, cnt0+1);
        }
    }
}
