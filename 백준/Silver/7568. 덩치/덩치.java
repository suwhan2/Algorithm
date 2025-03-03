import java.io.*;
import java.util.*;
class Person{
    int w,t;
    public Person(int w, int t){
        this.w=w;
        this.t=t;
    }
}
public class Main{
    static int N;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        Person[] massiveRanking = new Person[N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int w= Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            massiveRanking[i]=new Person(w,t);
        }

        StringBuilder sb =new StringBuilder();
        for(int i=0;i<N;i++){
            int cnt=0;
            for(int j=0;j<N;j++){
                if(i==j) continue;
                if(massiveRanking[i].w<massiveRanking[j].w && massiveRanking[i].t<massiveRanking[j].t) cnt++;
            }
            sb.append(cnt+1).append(" ");
        }
        System.out.println(sb);
    }
}