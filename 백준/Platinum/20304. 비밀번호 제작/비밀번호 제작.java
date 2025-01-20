import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static int[] safeDis;
    public static Queue<Integer> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        safeDis = new int[1000001];
        Arrays.fill(safeDis, Integer.MIN_VALUE);

        q = new LinkedList<Integer>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            int p = Integer.parseInt(st.nextToken());
            q.offer(p);
            safeDis[p] = 0;
        }

        bw.write(String.valueOf(findSafeDis()));
        bw.flush();
        bw.close();
        br.close();
    }

    public static int findSafeDis() {
        int maxSafeDis = 0;

        while(!q.isEmpty()) {
            int cur = q.poll();

            for(int i = 0; i < 20; i++) {
                int nx = cur^(1<<i);

                if(nx > n || (safeDis[nx] != Integer.MIN_VALUE)) continue;

                q.offer(nx);
                safeDis[nx] = safeDis[cur] + 1;
                maxSafeDis = Math.max(maxSafeDis, safeDis[nx]);
            }
        }

        return maxSafeDis;
    }
}