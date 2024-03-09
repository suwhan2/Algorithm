import java.io.*;
import java.util.*;


public class Main {
    static int N,r,c;
    private static int simulation(int x,int y ,int n,int tmp){
        if(n==0){
            return 0;
        }

        int half = tmp/2;

        if(x<half && y<half) return simulation(x,y,n-1,half);
        if(x<half && y>= half)return half*half + simulation(x,y-half,n-1,half);
        if(x>=half && y<half) return 2*half*half + simulation(x-half,y,n-1,half);
        return 3*half*half + simulation(x-half,y-half,n-1,half);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int tmp=1;
        for(int i=0;i<N;i++){
            tmp*=2;
        }
        System.out.println(simulation(r,c,N,tmp));
    }
}

