import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] cnt = new int[8001];
        int sum=0;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int input= Integer.parseInt(br.readLine());
            sum+=input;

            min = Math.min(min,input);
            max = Math.max(max,input);
            
            cnt[input+4000]++;
        }

        int maxf = 0, maxv = -4001, mid = 0, midf = 0;
        boolean isSecond = false, findMid = false;
        for(int i=min+4000; i<= max+4000;i++){
            if (maxf < cnt[i]) {
                maxf = cnt[i];
                maxv = i;
                isSecond = false;
            } else if (maxf == cnt[i] && !isSecond) {
                maxv = i;
                isSecond = true;
            }

            midf += cnt[i];
            if (!findMid && midf >= n / 2 + 1) {
                mid = i - 4000;
                findMid = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(Math.round((double) sum / n)).append('\n');
        sb.append(mid).append('\n');
        sb.append(maxv - 4000).append('\n');
        sb.append(max - min).append('\n');
        System.out.println(sb);
    }
}