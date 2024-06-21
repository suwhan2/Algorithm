import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Pair{
    int x,y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main{
    static int N,K;
    static int ANS=Integer.MAX_VALUE;
    static Pair[] houses;
    static int[] picked;


    private static void calcMinDis(){
        int maxDis = 0;
        for(int i=0;i<N;i++){
            int nearDis = Integer.MAX_VALUE;
            boolean check=true;
            for(int p : picked){
                if(i==p) check=false;
            }
            if(check){
                for(int p : picked){
                    int res =Math.abs(houses[p].x-houses[i].x)+Math.abs(houses[p].y-houses[i].y);
                    nearDis = Math.min(nearDis,res);
                }
                maxDis = Math.max(maxDis,nearDis);
            }

        }
        ANS=Math.min(ANS,maxDis);
    }
    private static void pick(int cnt, int startIndex){
        if(cnt==K){
            calcMinDis();
            return;
        }
        for(int i=startIndex;i<N;i++){
            picked[cnt]=i;
            pick(cnt+1,i+1);
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N =Integer.parseInt(st.nextToken());
        K =Integer.parseInt(st.nextToken());
        picked = new int[K];
        houses = new Pair[N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int x= Integer.parseInt(st.nextToken());
            int y= Integer.parseInt(st.nextToken());
            houses[i] = new Pair(x,y);
        }

        pick(0,0);
        System.out.println(ANS);
    }
}