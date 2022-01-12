package bj16472;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String str = in.next();

        System.out.println(str);
        int ans = 0;
        int len = str.length();
        for(int i = 0; i < len; i++){
            boolean[] alpha = new boolean[26];
            alpha[str.charAt(i) - 'a'] = true;
            int tmplen = 1, cnt = 1;
            for(int j = i+1; j < len; j++){
                if(!alpha[str.charAt(j)-'a']){ // false
                    if(cnt < n){
                        cnt++;
                        alpha[str.charAt(j)-'a'] = true;
                    }
                    else break;
                }
                tmplen++;
            }
            // 갱신
            if(ans == 0 || ans < tmplen) ans = tmplen;
        }

        System.out.println(ans);
    }
}
