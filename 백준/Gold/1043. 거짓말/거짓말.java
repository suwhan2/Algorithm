import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static List<Integer> result;
    static int[] parents;
    private static int find(int n){
        if(parents[n]==n) return n;

        return find(parents[n]);
    }
    private static boolean union(int a,int b){
        int pa = find(a);
        int pb = find(b);

        //부모가 같으면 이미 같은 그룹 합칠 이유가 없다
        if(pa==pb) return false;

        if(pa<pb) parents[pb]=pa;
        else parents[pa]=pb;
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result=new ArrayList<>();
        parents=new int[N+1];
        for(int i=1;i<=N;i++){
            parents[i]=i;
        }

        st= new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        for(int i=0;i<n;i++){
            int tmp = Integer.parseInt(st.nextToken());
            parents[tmp]=0;
        }



        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());

            for(int j=0;j<c-1;j++){
                int end = Integer.parseInt(st.nextToken());
                union(start,end);
            }

            result.add(find(start));
        }

        

        int cnt=0;
        for(Integer i : result){
            if(find(i)!=0) cnt++;
        }
        System.out.println(cnt);

    }
}