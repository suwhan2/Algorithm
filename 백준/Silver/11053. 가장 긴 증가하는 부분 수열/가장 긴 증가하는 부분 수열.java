import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] memo = new int[n];
        int[] arr = new int[n];
        StringTokenizer st  = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
//        memo[0]=1;

//        if(n>1){
            for(int i=0;i<n;i++){
                int tmp=1;
                for(int j=0;j<i;j++){
                    if(arr[j]<arr[i]){
                        tmp =Math.max(tmp,memo[j]+1);
                    }
                }
                memo[i]=tmp;
            }
//        }
        int ans =0;
        for(int i=0;i<n;i++){
            ans = Math.max(ans,memo[i]);
        }
        System.out.println(ans);

    }
}