import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Jewelry{
    int m,v;

    public Jewelry(int m, int v) {
        this.m = m;
        this.v = v;
    }
}

public class Main {
    static Jewelry[] jewelries;
    static PriorityQueue<Integer> pq =new PriorityQueue<>(Comparator.reverseOrder());
    static int[] bags;
    static int N,K;
    static long ans=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        jewelries =new Jewelry[N];
        bags =new int[K];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jewelries[i]=new Jewelry(m,v);
        }
        Arrays.sort(jewelries, new Comparator<Jewelry>() {
            @Override
            public int compare(Jewelry o1, Jewelry o2) {
                if (o1.m == o2.m) {
                    return o2.v - o1.v;
                }
                return o1.m - o2.m;
            }
        });

        for(int i=0;i<K;i++){
            bags[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(bags);
        int j=0;
        for (int i = 0; i < K; i++) {
            while (j < N && jewelries[j].m <= bags[i]) {
                pq.offer(jewelries[j++].v);
            }
            if (!pq.isEmpty()) {
                ans += pq.poll();
            }
        }
        System.out.println(ans);

    }
}