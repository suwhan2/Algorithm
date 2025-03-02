import java.io.*;
import java.util.*;

class Nation{
    int num,g,e,d,t;
    public Nation(int num, int g, int e, int d,int t) {
        this.num = num;
        this.g = g;
        this.e = e;
        this.d = d;
        this.t=t;
    }
}

public class Main{
    static int N,K;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Nation[] rank = new Nation[N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            rank[i]=new Nation(num,g,e,d,0);
        }

        Arrays.sort(rank,new Comparator<Nation>() {
            @Override
            public int compare(Nation o1, Nation o2) {
                if (o1.g > o2.g) return -1;
                else if (o1.g == o2.g) {
                    if (o1.e > o2.e) return -1;
                    else if (o1.e==o2.e) {
                        if(o1.d > o2.d) return-1;
                    }
                }
                return 1;
            }
        });
        rank[0].t=1;
        int endPoint=0;
        for(int i=1;i<N;i++){
            if(rank[i].num==K){
                endPoint=i;
            }

            if(rank[i].g==rank[i-1].g && rank[i].e==rank[i-1].e&&rank[i].d==rank[i-1].d){
                rank[i].t=rank[i-1].t;
            }
            else{
                rank[i].t=i+1;
            }
        }

        System.out.println(rank[endPoint].t);

    }
}