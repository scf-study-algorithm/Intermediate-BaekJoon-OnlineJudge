import java.util.*;

import java.io.*;

 

public class Main{

​    public static void main(String[] args) throws IOException {

​        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

​        int n = Integer.parseInt(br.readLine());

​        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

​        int target = Integer.parseInt(br.readLine()), cnt = 0;

​        int start = 0, end = n-1;

​        

​        while(start < end){

​            int sum = input[start] + input[end];

​            if(sum == target){

​                end--; start++;

​                cnt++;

​            }else if(sum>target)

​                end--;

​            else

​                start++;

​        }

​        System.out.println(cnt);

​    }

}