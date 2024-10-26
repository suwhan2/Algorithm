import java.io.*;
import java.util.*;

public class Main{
    static int X;
    static int[] memo;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        X = Integer.parseInt(br.readLine());
        memo = new int[X+1];

        if(X==1) System.out.println(0);
        if(X==2) System.out.println(1);
        if(X>=3){
            memo[1]=1;
            memo[2]=1;
            memo[3]=1;
            for(int i=4;i<=X;i++){
                int tmp=memo[i-1]+1;
                if(i%3==0){
                    int tmp2 = memo[i/3]+1;
                    tmp = Math.min(tmp2,tmp);
                }
                if(i%2==0){
                    int tmp3 = memo[i/2]+1;
                    tmp = Math.min(tmp3,tmp);
                }
                memo[i]=tmp;
            }
            System.out.println(memo[X]);
        }
    }
}