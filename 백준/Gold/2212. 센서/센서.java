import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        if(K >= N) {
            System.out.println(0);
            return;
        }
        int[] sensor = new int[N];
        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            sensor[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(sensor);
        
        Integer[] gap = new Integer[N-1];
        for(int i = 0; i <N-1; i++)
            gap[i] = sensor[i+1] - sensor[i];
        Arrays.sort(gap,Collections.reverseOrder());
        
        int sum = 0;
        for(int i = K-1; i < N-1; i++) {
            sum += gap[i];
        }
        System.out.println(sum);
    }
}