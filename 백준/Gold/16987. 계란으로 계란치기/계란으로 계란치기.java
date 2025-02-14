import java.util.*;
import java.io.*;

class Egg {
    int d, w;
    public Egg(int d, int w) {
        this.d = d;
        this.w = w;
    }
}

public class Main {
    static int N;
    static int ans = 0;
    static Egg[] eggList;
    static boolean[] breakStateList;

    private static void simulation(int cnt) {
        if (cnt == N) {  // 마지막 계란까지 진행했을 때 종료
            int breakCnt = 0;
            for (boolean s : breakStateList) {
                if (s) breakCnt++;
            }
            ans = Math.max(ans, breakCnt);
            return;
        }

        if (breakStateList[cnt]) {
            simulation(cnt + 1);
            return;  // 이 부분이 추가되어야 함!
        }

        boolean hasHit = false;  // 부딪힌 적 있는지 확인

        for (int i = 0; i < N; i++) {
            if (i == cnt || breakStateList[i]) continue;
            hasHit = true;
            hit(cnt, i);
            simulation(cnt + 1);
            back(cnt, i);
        }

        if (!hasHit) {  // 부딪힐 계란이 없을 경우 그냥 다음으로 이동
            simulation(cnt + 1);
        }
    }

    private static void hit(int a, int b) {
        eggList[a].d -= eggList[b].w;
        eggList[b].d -= eggList[a].w;

        if (eggList[a].d <= 0) breakStateList[a] = true;
        if (eggList[b].d <= 0) breakStateList[b] = true;
    }

    private static void back(int a, int b) {
        eggList[a].d += eggList[b].w;
        eggList[b].d += eggList[a].w;

        if (eggList[a].d > 0) breakStateList[a] = false;
        if (eggList[b].d > 0) breakStateList[b] = false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        eggList = new Egg[N];
        breakStateList = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            eggList[i] = new Egg(d, w);
        }

        simulation(0);
        System.out.println(ans);
    }
}
