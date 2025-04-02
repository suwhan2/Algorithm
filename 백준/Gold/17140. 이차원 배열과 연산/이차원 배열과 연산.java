import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Pair {
    int num, cnt;

    public Pair(int num, int cnt) {
        this.num = num;
        this.cnt = cnt;
    }
}

public class Main {
    static int r, c, k;
    static int R, C;
    static int[][] A;


    private static void rCal(int key) {
        List<Pair> cntResult = new ArrayList<>();
        HashMap<Integer, Integer> tmp = new HashMap<>();

        for (int j = 0; j < C; j++) {
            if(A[key][j]==0) continue;
            if (tmp.containsKey(A[key][j])) {
                tmp.replace(A[key][j], tmp.get(A[key][j]) + 1);
            } else {
                tmp.put(A[key][j], 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : tmp.entrySet()) {
            cntResult.add(new Pair(entry.getKey(), entry.getValue()));
        }

        Collections.sort(cntResult, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.cnt == o2.cnt) {
                    return o1.num - o2.num;
                } else {
                    return o1.cnt - o2.cnt;
                }
            }
        });

        int z = 0;
        for (Pair pair : cntResult) {
            A[key][z++] = pair.num;
            A[key][z++] = pair.cnt;
        }

        C = Math.max(C, z);
        while (z <= 99) {
            A[key][z++] = 0;
            A[key][z++] = 0;
        }
    }

    private static void cCal(int key) {
        List<Pair> cntResult = new ArrayList<>();
        HashMap<Integer, Integer> tmp = new HashMap<>();

        for (int j = 0; j < R; j++) {
            if(A[j][key]==0) continue;
            if (tmp.containsKey(A[j][key])) {
                tmp.replace(A[j][key], tmp.get(A[j][key]) + 1);
            } else {
                tmp.put(A[j][key], 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : tmp.entrySet()) {
            cntResult.add(new Pair(entry.getKey(), entry.getValue()));
        }

        Collections.sort(cntResult, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.cnt == o2.cnt) {
                    return o1.num - o2.num;
                } else {
                    return o1.cnt - o2.cnt;
                }
            }
        });

        int z = 0;
        for (Pair pair : cntResult) {
            A[z++][key] = pair.num;
            A[z++][key] = pair.cnt;
        }


        R = Math.max(R, z);

        while (z <= 99) {
            A[z++][key] = 0;
            A[z++][key] = 0;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken())-1;
        c = Integer.parseInt(st.nextToken())-1;
        k = Integer.parseInt(st.nextToken());
        A = new int[100][100];
        R = 3;
        C = 3;
        //시간 5000만
        // 최대 반복 100
        //50만 하나의 연산당
        //최대 행열 길이 100
        // 한 행,열 당 최대 5000
        // 카운트(100) + 객체 정렬(nlon = 700) + 배열수정(100) => 충분
        // 배열은 100x100으로하고 rc를 늘리면 어떨까...

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = -1;
        if (A[r][c] == k) {
            System.out.println(0);
            System.exit(0);
        }

        for (int t = 0; t < 100; t++) {
            if (R >= C) {
                for (int i = 0; i < R; i++) {
                    rCal(i);
                }
            } else {
                for (int i = 0; i < C; i++) {
                    cCal(i);
                }
            }
            if (A[r][c] == k) {
                ans = t+1;
                break;
            }
            
        }
        System.out.println(ans);
    }
}
