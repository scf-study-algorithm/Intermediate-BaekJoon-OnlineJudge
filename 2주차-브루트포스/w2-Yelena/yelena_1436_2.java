package bj1436_2;

import java.util.Scanner;

public class Main {

    static String num = "666";
    static int n, curRank = 1,ans = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int idx = 1;
        n = in.nextInt();

        // 첫번째 영화는..
        if (n == 1) {
            System.out.print(666);
            return;
        }
        // 가장 단순한 방법
//        for(int i = 1666; ; i++){
//            String nn = Integer.toString(i);
//            if(nn.contains("666")) idx++;
//            if(idx == n){
//                ans = i;
//                break;
//            }
//        }

        // n번째 영화를 찾을 때까지 Go
        while (true) {

            String six = Integer.toString(idx);

            // 마지막이 6인 경우
            if(six.charAt(six.length()-1) == '6'){
                if(CountN(six) == n) break;
            }
            else{
                String tmp = Integer.toString(idx) + num;
                System.out.println(curRank+1 + ":" + tmp);
                if(++curRank == n){
                    ans = Integer.parseInt(tmp);
                    break;
                }
            }
            idx++;
        }
        System.out.print(ans);
    }
    // 그 전 count 시작
    static int CountN(String idx){
        int six = 0;
        for(int i = idx.length()-1; i >= 0; i--){
            if(idx.charAt(i) == '6') six++;
            else break;
        }

        // 고정 값과 변경 값 구하기
        String str = "1", fix = "";
        for(int i = 1; i < six; i++)
            str += "0";
        for(int i = 0; i < idx.length()-six; i++)
            fix += idx.charAt(i);

        // 끝까지 세거나 혹은 중간에 n번째 발견시
        for(int i = 0; i < Integer.parseInt(str+"0"); i++){
            String s = "";
            for(int j = Integer.toString(i).length(); j < six; j++)
                s += "0";

            s += Integer.toString(i);
            System.out.println(curRank+1 + ":" + "666"+s);
            if(++curRank == n){
                ans = Integer.parseInt(fix+"666"+s);
                return curRank;
            }
        }
        return -1;
    }
}
