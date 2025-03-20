import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static int[] tree;
    private static int findH(int high){
        int curL = 0;
        int curH = high;
        int ans=0;
        while (curL<=curH){
            int mid = (curH+curL)/2;
            long sum=0;
            for(int t : tree){
                int result = t-mid;
                if(result>0) sum+=result;
            }
            if(sum>=M){
                ans=mid;
                curL = mid+1;
            }
            else{
                curH = mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        tree = new int[N];
        st = new StringTokenizer(br.readLine());
        int high = 0;
        for(int i=0;i<N;i++){
            tree[i] = Integer.parseInt(st.nextToken());
            high = Math.max(high,tree[i]);
        }
        System.out.println(findH(high));
    }
}