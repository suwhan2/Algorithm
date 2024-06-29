import java.util.*;
import java.io.*;

public class Main {
    static int N,M,low,high;
    static int[] bookInfo;
    static int walkSum=0;
    static boolean first = true;
    private static void oneDirPick(){
        if(bookInfo[low]>0){
            walkSum+= (2*bookInfo[high]);
            if(first){
                walkSum-= bookInfo[high];
                first=false;
            }
            for(int i=0;i<M;i++){
                high--;
                if(low>high) return;
            }
        }else{
            walkSum+=(2*Math.abs(bookInfo[low]));
            if(first){
                walkSum-= Math.abs(bookInfo[low]);
                first=false;
            }
            for(int i=0;i<M;i++){
                low++;
                if(low>high) return;
            }
        }
    }
    private static void twoDirPick(){
        if(Math.abs(bookInfo[low])>bookInfo[high]){
            walkSum+=(2*Math.abs(bookInfo[low]));
            if(first){
                walkSum-= Math.abs(bookInfo[low]);
                first=false;
            }

            for(int i=0;i<M;i++){
                low++;
                if(low>high) return;
                if(bookInfo[low]>0) return;
            }
        }else{
            walkSum+=(2*bookInfo[high]);
            if(first){
                walkSum-= bookInfo[high];
                first=false;
            }
            for(int i=0;i<M;i++){
                high--;
                if(low>high)return;
                if(bookInfo[high]<0) return;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        bookInfo = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            bookInfo[i] = Integer.parseInt(st.nextToken());
        }
        low=0;
        high=N-1;
        Arrays.sort(bookInfo);

        while(low<=high){
            if(bookInfo[low]>0 || bookInfo[high]<0){
                oneDirPick();
            }
            else{
                twoDirPick();
            }
        }

        System.out.println(walkSum);
    }
}