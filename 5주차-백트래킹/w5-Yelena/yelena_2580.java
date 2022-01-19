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
public class yelena_2580 {
    static int[][] sudoku = new int[9][9];
    static List<blank> blanks = new ArrayList<blank>();

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
        for(int j = 0; j < 9; j++){
            if(possible(r,c,j+1)){
                sudoku[r][c] = j+1;
                if(fillSudoku(idx+1)) return true;
                sudoku[r][c] = 0;
            }
        }
        return false;
    }
    static boolean possible(int r, int c, int num){
        for(int i = 0; i < 9; i++){
            if(sudoku[r][i] == num) return false;
        }
        for(int i = 0; i < 9; i++){
            if(sudoku[i][c] == num) return false;
        }
        int rr = (((r)/3))*3;
        int cc = (((c)/3))*3;
        for(int i = rr; i < rr+3; i++){
            for(int j = cc; j < cc+3; j++){
                if(sudoku[i][j] == num) return false;
            }
        }
        return true;
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