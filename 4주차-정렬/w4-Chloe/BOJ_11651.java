package BOJ;
//https://www.acmicpc.net/problem/11651
import java.util.*;

public class BOJ_11651 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[][] map = new int[N][2];

        for(int i=0; i<N; i++){
            //for(int j=0; j<2; j++){
                map[i][0] = scanner.nextInt();
            map[i][1] = scanner.nextInt();
            //}
        }

        Arrays.sort(map, (e1, e2) -> {
            if(e1[1] == e2[1]) {

                return e1[0] - e2[0];
            } else {
                return e1[1] - e2[1];
            }
        });

        for(int i=0; i<N; i++){
            for(int j=0; j<2; j++){
                System.out.print(map[i][j]+ " ");
            }
            System.out.println();
        }


    }
}
