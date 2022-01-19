import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
class blank{
    private int r;
    private int c;

    public blank(int r, int c) {
        this.r = r;
        this.c = c;
    }

    public int getR() {
        return r;
    }

    public int getC() {
        return c;
    }
}
public class yelena_2580_2 {
    static int[][] sudoku = new int[9][9];
    static List<blank> blanks = new ArrayList<blank>();
    static boolean[][] ver = new boolean[9][10];
    static boolean[][] hor = new boolean[9][10];
    static boolean[][][] mini = new boolean[3][3][10];

    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        try{
            for(int i = 0; i < 9; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 9; j++){
                    sudoku[i][j] = Integer.parseInt(st.nextToken());
                    if(sudoku[i][j] == 0){
                        blanks.add(new blank(i,j));
                    } else{
                        int r = i/3;
                        int c = j/3;
                        hor[i][sudoku[i][j]] = true;
                        ver[j][sudoku[i][j]] = true;
                        mini[r][c][sudoku[i][j]] = true;
                    }

                }
            }
            br.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        fillSudoku(0);
    }
    static boolean fillSudoku(int idx){
        if(idx >= blanks.size()){
            AllPrint();// 전체 인쇄
            return true;
        }

        int r = blanks.get(idx).getR();
        int c = blanks.get(idx).getC();
        int rr = r/3;
        int cc = c/3;
        for(int j = 1; j <= 9; j++){
            if(!hor[r][j] && !ver[c][j] && !mini[rr][cc][j]){
                sudoku[r][c] = j;
                hor[r][j] = true;
                ver[c][j] = true;
                mini[rr][cc][j] = true;
                if(fillSudoku(idx+1)) return true;
                hor[r][j] = false;
                ver[c][j] = false;
                mini[rr][cc][j] = false;
            }
        }
        return false;
    }
    static void AllPrint(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                sb.append(sudoku[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}