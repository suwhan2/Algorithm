import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] snowBall;
    static int ans=Integer.MAX_VALUE;
    private static void findMinGap(int sum,int start,int end){
        int tmp1=0;
        int tmp2=N-1;

        while(tmp1<tmp2){
            if(tmp1==start || tmp1==end){
                tmp1++;
                continue;
            }
            if(tmp2==start || tmp2==end){
                tmp2--;
                continue;
            }

            int tmpSum = snowBall[tmp1]+snowBall[tmp2];
            ans=Math.min(ans,Math.abs(sum-tmpSum));

            if(tmpSum<sum){
                tmp1++;
            }
            if (tmpSum>sum){
                tmp2--;
            }
            if(tmpSum==sum){
                ans=0;
                return;
            }
        }

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N =Integer.parseInt(br.readLine());
        StringTokenizer st= new StringTokenizer(br.readLine());
        snowBall = new int[N];
        for(int i=0;i<N;i++){
            snowBall[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(snowBall);
        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                findMinGap(snowBall[i]+snowBall[j],i,j);
            }
        }
        System.out.println(ans);
    }
}