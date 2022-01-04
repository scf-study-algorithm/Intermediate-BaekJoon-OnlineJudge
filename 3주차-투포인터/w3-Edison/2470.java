import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.*;

public class Main {

    static int min = Integer.MAX_VALUE;
    static int[] arr;

    public static void main(String[] args) throws IOException {

//        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
//        int N = sc.nextInt();
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[N];

        for (int i = 0; i < N; i++) {
//            arr[i]=sc.nextInt();
            arr[i] = Integer.parseInt(st.nextToken());
        }

//        int X = sc.nextInt();

        Arrays.sort(arr);

        int start =0;
        int end=N-1;
        int answer_1=0;
        int answer_2=0;

        // 두 원소의 합이 x와 같거나 x보다 더 크다 -> 시작점 한 칸 오른쪽으로 이동(시작점++)
        //  두 원소의 합이 x보다 작다 -> 끝 점 한 칸 왼쪽으로 이동(끝점--)
        while(start<end){
            int temp = arr[start]+arr[end];

            //가장 가까운값 추출
            if(min > Math.abs(temp)){ //abs 라서 음수는 못나온다.
                answer_1=arr[start];
                answer_2=arr[end];
                min=Math.abs(temp);

                if(temp == 0){
                    break;
                }
            }

            //0에 맞는게 나오면 그이상은 없으니 찾으면 바로 종료
            //더 가까운 값이였음. 위로 이동
//            if(temp == 0){
//                break;
//            }

            if(temp < 0){
                start++;
            }else{
                end--;
            }
        }

        System.out.println(answer_1+" "+answer_2);

    }

    static void sol(){
        return;
    }
}