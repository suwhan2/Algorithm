import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] lightPosition = new int[M];
        int height = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<M; i++) {
            int light = Integer.parseInt(st.nextToken());
            lightPosition[i] = light;
        }

        int low = 1;
        int high = N;
        while(low <= high) {
            int mid = (low+high)/2;
            boolean check = true;
            int point = 0;
            for (int i=0; i<lightPosition.length; i++) {
                if (lightPosition[i] - mid <= point) point = lightPosition[i] + mid;
                else check = false;
            }
            if (N - point > 0) check = false;
            else check = true;

            if (check) {
                height = mid;
                high = mid - 1;
            } else low = mid + 1;
        }
        System.out.println(height);
    }
}