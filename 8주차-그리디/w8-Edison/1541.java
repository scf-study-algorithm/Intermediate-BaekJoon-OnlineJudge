import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
//        System.out.println(str);

        StringTokenizer st= new StringTokenizer(str,"-");

        int answer=0;
        while(st.hasMoreTokens()){
            int temp=0;
            StringTokenizer st2 = new StringTokenizer(st.nextToken(), "+");
            while(st2.hasMoreTokens()){
//                System.out.println(st2.nextToken());
                temp+=Integer.parseInt( st2.nextToken());
            }

            if(answer==0) {
                answer = temp;
            }else{
                answer-=temp;
            }
        }

        System.out.print(answer);

    }

}