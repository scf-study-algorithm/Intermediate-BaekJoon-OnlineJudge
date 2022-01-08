import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.*;

public class Main {

    static int min = Integer.MAX_VALUE;
    static int[] arr;
    //    static ArrayList<Integer> prime = new ArrayList<>();
    static ArrayList<Long> front = new ArrayList<>();
    static ArrayList<Long> end = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = sc.nextInt();
        int C = sc.nextInt();

        arr=new int[N];

        for (int i = 0; i < N; i++) {
            arr[i]=sc.nextInt();
        }

        //meet in the middle

        //1. 배열 분리
        //2. 각 배열 조합 구하기
        sol(0,N/2-1, 0L,front);
//        System.out.println("----");
        sol(N/2,N-1, 0L,end);

//        System.out.println("----");
//        for (int i = 0; i < front.size(); i++) {
//            System.out.print(front.get(i));
//        }
//        System.out.println();
//        for (int i = 0; i < end.size(); i++) {
//            System.out.print(end.get(i));
//        }

        //정렬
        Collections.sort(front);
        Collections.sort(end);

//        System.out.println();
//        System.out.println("----");
//
//        for (int i = 0; i < front.size(); i++) {
//            System.out.print(front.get(i));
//        }
//        System.out.println();
//        for (int i = 0; i < end.size(); i++) {
//            System.out.print(end.get(i));
//        }

        //3. 투포인터 시작
        //C=6이고 front[i]=k라면 이 이상 담을 수 있는 최대 무게는 C-k이다.
        //back 배열에서 key값 C-k를 가지고 upper_bound를 찾으면 그게 조건에 맞는 back 배열 원소의 수다.
        //lower_bound -> 특정 범위안에서 target보다 크거나 같은 첫번째 원소의 인덱스 리턴
        //upper_bound -> 특정 범위안에서 target보다 큰 첫번째 원소의 인덱스 리턴 이때 리스트는 모두 정렬된 상태여야 한다.

        int answer=0;
        for (int i = 0; i < front.size(); i++) {
            answer+=upperBound(end,C-front.get(i));
        }
//        System.out.println();
        System.out.println(answer-end.get(0));
    }


    static void sol(int start,int end,Long sum,ArrayList<Long> array){
        //분리 시작 분리하면서 조합 생성
        if(start > end){
//            System.out.println(start +" "+end+" "+sum);
            array.add(sum);
            //끝까지 가면 저장
            return;
        }

        //넣지않는다
        sol(start+1,end,sum,array);
        //넣는다.
        sol(start+1,end,sum+arr[start],array);
        return;
    }

    private static int upperBound(List<Long> data, Long target) {
        //이분탐색
        int begin = 0;
        int end = data.size();

        while(begin < end) {
            int mid = (begin + end) / 2;

            if(data.get(mid) <= target) {
                begin = mid + 1;
            }
            else {
                end = mid;
            }
        }
        return end;
    }
}

