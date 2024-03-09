import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int members[][];
    static boolean visited[];
    static int memberSequence[];
    static int maxScore=0;
    private static void simulation(){
        int outCount=0;
        int currentIndex=0;
        int score=0;
        int base1=0;
        int base2=0;
        int base3=0;

        for(int i=0;i<N;i++){
            while(outCount<3){
                int current = members[i][memberSequence[currentIndex]];
                switch (current){
                    case 0:
                        outCount++;
                        break;
                    case 1:
                        score+=base3;
                        base3=base2;
                        base2=base1;
                        base1=1;
                        break;
                    case 2:
                       score+=(base3+base2);
                       base3=base1;
                       base2=1;
                       base1=0;
                        break;
                    case 3:
                        score+=(base3+base2+base1);
                        base1=base2=0;
                        base3=1;
                        break;
                    default:
                       score+=(base3+base2+base1+1);
                       base1=base2=base3=0;
                        break;
                }
                currentIndex= (currentIndex+1)%9;
            }
            outCount=0;
            base1=base2=base3=0;
        }
        maxScore = Math.max(score,maxScore);

    }
    private static void makeSequence(int cnt){

        if(cnt==9){
            simulation();
            return;
        }

        if(cnt==3){
            memberSequence[cnt]=1;
            makeSequence(cnt+1);
            return;
        }

        for(int i=2;i<=9;i++){
            if(visited[i]) continue;
            visited[i]=true;
            memberSequence[cnt]=i;
            makeSequence(cnt+1);
            visited[i]=false;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        members = new int[N][10];
        visited = new boolean[10];
        memberSequence = new int[9];
        for(int i=0;i<N;i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            for(int j=1;j<=9;j++){
                members[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited[1] = true;
        makeSequence(0);
        System.out.println(maxScore);
    }
}