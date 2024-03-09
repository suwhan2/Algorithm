import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int N;
    static int arr[],memo[];
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        memo = new int[N];
        int ans=1;
        memo[0]=1;
        for(int i=1;i<N;i++){
            int maxL=0;
            for(int j=0;j<i;j++){
                int tmp=1;
                if(arr[j]<arr[i]){
                    tmp=memo[j]+1;
                }
                if(maxL<tmp){
                    maxL=tmp;
                }

            }
            memo[i]=maxL;
            ans = Math.max(ans,maxL);
        }
        System.out.println(ans);
    }
}