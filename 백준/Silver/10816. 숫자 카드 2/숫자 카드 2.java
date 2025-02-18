import java.util.*;
import java.io.*;

public class Main{
    static int N,M;
    static int target=0;
    static int[] sang;
    private static int countCardLow(){
        int b=0;
        int t = N;

        while(b<t){
            int mid = (b+t)/2;
            if(target <= sang[mid]){
                t=mid;
            }else{
                b = mid+1;
            }
        }
        return b;
    }
    private static int countCardHigh(){
        int b=0;
        int t = N;

        while(b<t){
            int mid = (b+t)/2;
            if(target < sang[mid]){
                t=mid;
            }else{
                b = mid+1;
            }
        }
        return b;
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        sang = new int[N];
        for(int i=0;i<N;i++){
            sang[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sang);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++){
            int num = Integer.parseInt(st.nextToken());
            target = num;
            int l = countCardLow();
            int h = countCardHigh();
            int c = h-l;
            sb.append(c).append(" ");
        }
        System.out.println(sb);
    }
}