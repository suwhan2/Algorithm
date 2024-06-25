import java.util.*;
import java.io.*;

public class Main{
    static int N,Q,l,r;
    static int[] funInfo,accumulatedSum;
    static long[] accumulatedFun;
    private static long calFun(int l, int r){
        if(l==1) return accumulatedFun[r];
        else{
            long ans = accumulatedFun[r]-((long) (accumulatedSum[r] - accumulatedSum[l - 1]) *accumulatedSum[l-1]);
            return ans-accumulatedFun[l-1];
        }
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        funInfo = new int[N+1];
        accumulatedSum = new int[N+1];
        accumulatedFun = new long[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1;i<N+1;i++){
            funInfo[i] = Integer.parseInt(st.nextToken());
        }
        //누적합 만들기
        for(int i=1;i<N+1;i++){
            accumulatedSum[i] = accumulatedSum[i-1]+funInfo[i];
        }
        //누적재미 만들기
        for(int i=2;i<N+1;i++){
            accumulatedFun[i]=accumulatedFun[i-1]+((long) accumulatedSum[i - 1] *funInfo[i]);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<Q;i++){
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            sb.append(calFun(l,r)).append(System.lineSeparator());
        }
        System.out.println(sb);
    }
}