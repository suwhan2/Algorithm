import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] liq;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        liq = new int[N];
        StringTokenizer st=  new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            liq[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(liq);
        int[] res = new int[2];
        int min = Integer.MAX_VALUE;
        int start=0;
        int end=N-1;

        while(start<end){
            int sum = liq[start]+liq[end];

            if(min>Math.abs(sum)){
                min = Math.abs(sum);
                res[0] = liq[start];
                res[1] = liq[end];
                if(sum==0) break;
            }

            if(sum<0) start++;
            else end--;
        }
        System.out.println(res[0]+" "+res[1]);
    }
}