import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] memo = new int[n+1];
        int[] arr = new int[n+1];
        for(int i=1;i<=n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        if(n==1) System.out.println(arr[1]);
        else if(n==2) System.out.println(arr[1]+arr[2]);
        else{
            memo[1]=arr[1];
            memo[2]=arr[1]+arr[2];

            for(int i=3;i<=n;i++){
                    int tmp = memo[i-1];
                    tmp = Math.max(tmp, memo[i-2]+arr[i]);
                    tmp=Math.max(tmp,memo[i-3]+arr[i-1]+arr[i]);
                    memo[i]=tmp;
            }
            System.out.println(memo[n]);
        }

    }
}