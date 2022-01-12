package sort;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class alphabet implements Comparable<alphabet>{
    private String word;

    public alphabet(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public int compareTo(alphabet w){
        if(this.word.length() < w.getWord().length()) return -1;
        else if(this.word.length() > w.getWord().length()) return 1;
        else{
            // this.word가 사전적으로 우선할때 음수 반환
            if(this.word.compareTo(w.getWord()) > 0) return 1;
            else if(this.word.compareTo(w.getWord()) < 0) return -1;
            else return 0;
        }
    }
}
public class yelena_1181{

    public static void main(String[] args) throws IOException {
        List<alphabet> alphaList = new ArrayList<alphabet>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            String s = br.readLine();
            alphaList.add(new alphabet(s));
        }
        br.close();

        Collections.sort(alphaList);

        StringBuilder sb = new StringBuilder();
        String prev = "";
        for(int i = 0; i < n; i++){
            String cur = alphaList.get(i).getWord();
            if(cur.compareTo(prev) == 0) continue;
            sb.append(cur + "\n");
            prev = cur;
        }
        System.out.println(sb);
    }
}