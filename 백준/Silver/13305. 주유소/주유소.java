import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st= new StringTokenizer(br.readLine());
        int[] distance = new int[N-1];
        int[] price = new int[N];
        for(int i=0;i<N-1;i++){
            distance[i]= Integer.parseInt(st.nextToken());
        }
        st= new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            price[i] = Integer.parseInt(st.nextToken());
        }

        int ans =0;
        int currentPick = price[0];
        ans+= (currentPick*distance[0]);


        for(int i=1;i<N-1;i++){
            if((currentPick*distance[i])>(price[i]*distance[i])){
                currentPick=price[i];
                ans+=(currentPick*distance[i]);
            }else{
                ans+=(currentPick*distance[i]);
            }
        }
        System.out.println(ans);

    }
}
