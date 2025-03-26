import java.util.*;
import java.io.*;

public class Main{
    static int N;
    static int ans=Integer.MAX_VALUE;
    static int[][] CBTable;
    static boolean[] picked;
    private static int calculate(){
        int startTeam =0;
        int linkTeam =0 ;

        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                if(picked[i] && picked[j]) startTeam+=(CBTable[i][j]+CBTable[j][i]);
                else if (!picked[i] && !picked[j]) linkTeam+=(CBTable[i][j]+CBTable[j][i]);
            }
        }
        return Math.abs(startTeam - linkTeam);

    }
    private static void pickMember(int cnt,int startIndex){
        if(cnt==(N/2)){
            ans=Math.min(ans,calculate());
            return;
        }

        for(int i=startIndex;i<N;i++){
            if(!picked[i]){
                picked[i]=true;
                pickMember(cnt+1,i+1);
                picked[i]=false;
            }
        }
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        CBTable = new int[N][N];
        StringTokenizer st;
        picked = new boolean[N];

        for(int i=0;i<N;i++){
            st=  new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                CBTable[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        pickMember(0,0);
        System.out.println(ans);
    }
}