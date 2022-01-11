package BOJ;
//https://www.acmicpc.net/problem/1427
import java.util.*;

public class BOJ_1427 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Character> list = new ArrayList<>();
        String s = Integer.toString(n);
        for(int i=0; i<s.length(); i++){
            list.add(s.charAt(i));
            //System.out.println(s.charAt(i));
        }

        Collections.sort(list, Comparator.reverseOrder());

        String answer ="";
        for(int j=0; j<list.size(); j++){
            answer+=list.get(j);
        }

        System.out.print(answer);

    }
}
