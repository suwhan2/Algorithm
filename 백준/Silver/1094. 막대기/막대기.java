import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr =new int[]{1,2,4,8,16,32,64};
        int[] memo = new int[n+1];

        if(n==1) System.out.println(1);
        else if(n==2) System.out.println(1);
        else{
            memo[1]=1;
            memo[2]=1;

            for(int i=3;i<=n;i++){
                int tmp = i;
                for(int j : arr){
                    if(j>i)break;
                    int tmp2 = memo[i-j]+1;
                    tmp = Math.min(tmp2,tmp);
                }
                memo[i]=tmp;
            }
            System.out.println(memo[n]);
        }
    }
}