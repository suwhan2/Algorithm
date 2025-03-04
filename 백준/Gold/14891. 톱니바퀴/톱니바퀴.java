import java.util.*;
import java.io.*;

public class Main{
    static int[][]  cog;

    private static int calc(){
        return (cog[0][0]+cog[1][0]*2+cog[2][0]*4+cog[3][0]*8);
    }

    private static void turnLeft(int num){
        int tmp = cog[num][0];
        for(int i=0;i<7;i++){
            cog[num][i]= cog[num][i+1];
        }
        cog[num][7] = tmp;
    }
    private static void turnRight(int num){
        int tmp = cog[num][7];
        for(int i=7;i>=1;i--){
            cog[num][i]=cog[num][i-1];
        }
        cog[num][0]=tmp;
    }
    private static boolean checkR(int s){
        if(cog[s][2]!=cog[s+1][6]) return true;
        return false;
    }
    private static boolean checkL(int s){
        if(cog[s][6]!=cog[s-1][2]) return true;
        return false;
    }


    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        cog = new int[4][8];

		for(int i=0;i<4;i++){
            String strInput = br.readLine();
            for(int j=0;j<8;j++){
                cog[i][j]=strInput.charAt(j)-'0';
            }
        }


        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int cogNum = Integer.parseInt(st.nextToken())-1;
            int dir = Integer.parseInt(st.nextToken());

            int idx1 = cogNum;
            int idx2 = cogNum;

            int dir1= dir;
            int dir2 = dir;

            int[] cmd =new int[4];
            cmd[cogNum]=dir;


            while(idx1<3){
                if(checkR(idx1)){
                    dir1*=-1;
                    idx1+=1;

                    cmd[idx1]=dir1;

                }else	break;
            }

            while(idx2>0){
                if(checkL(idx2)){
                    idx2--;
                    dir2*=-1;

                    cmd[idx2]=dir2;

                }
                else break;
            }

            for(int j=0;j<4;j++){
                if(cmd[j]==1) turnRight(j);
                if (cmd[j]==-1) turnLeft(j);
            }
        }

        int score = calc();
        System.out.println(score);
    }
}