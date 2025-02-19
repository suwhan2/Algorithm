import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] memo = new int[1001];
        memo[1]=1;
        memo[2]=3;
        memo[3]=5;

        if(n<=3) System.out.println(memo[n]);
        else{
            for(int i=4;i<=n;i++){
                memo[i]=(memo[i-1]+memo[i-2]*2)%10007;
            }
            System.out.println(memo[n]);
        }
    }
}