import java.util.*;
import java.io.*;
public class Main {
    static int N,K;
    static int[] cb;
    static int cur;
    static int cantUse;
    static boolean[] isRobot;

    private static void firstTurn(){
        int tmp1 = cb[2*N-1];
        boolean tmp2 = isRobot[2*N-1];
        isRobot[N-2] = false;

        for(int i=(2*N-1);i>=1;i--){
            cb[i] = cb[i-1];
            isRobot[i] = isRobot[i-1];
        }
        cb[0] = tmp1;
        isRobot[0] = tmp2;
    }




    private static void secondMove(){
        if(isRobot[N-2] && cb[N-1]!=0){
            cb[N-1]--;
            if(cb[N-1]==0) cantUse++;
            isRobot[N-2] = false;
        }

        for(int i=(N-2);i>=0;i--){
            if(isRobot[i] && !isRobot[i+1] && cb[i+1]>0){
                isRobot[i+1] = true;
                isRobot[i]=false;
                cb[i+1]--;
                if(cb[i+1]==0) cantUse++;
            }
        }
    }
    private static void thirdPut(){
        if(cb[0]!=0){
            isRobot[0]=true;
            cb[0]--;
            if(cb[0]==0) cantUse++;
        }
    }

    private static boolean fourthCheck(){
        if(cantUse>=K) return true;
        return false;
    }

    private static int simulation(){
        while(true){
            cur++;
            firstTurn();
            secondMove();
            thirdPut();
            if(fourthCheck()) return cur;
        }
    }

    public static void main(String[] args) throws IOException{
        //입력부
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N =Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        cb = new int[2*N];
        for(int i=0;i<2*N;i++){
            cb[i] = Integer.parseInt(st.nextToken());
        }

        isRobot = new boolean[2*N];
        cantUse=0;
        //동작부, 출력부
        System.out.println(simulation());

    }
}