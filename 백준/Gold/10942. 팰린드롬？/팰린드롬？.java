import java.io.*;
import java.util.*;
public class Main{
    static int N,M,S,E;
    static int[] numbers;
    static int[][] memo;
    static StringBuilder sb;
    private static void printIsPalindrome(){
        if(memo[S][E]!=-1){
            sb.append(memo[S][E]).append(System.lineSeparator());
            return;
        }
        if(S==E){
            memo[S][E]=1;
            sb.append(1).append(System.lineSeparator());;
            return;
        }

        int tmp = S+E;
        int start=0;
        int end=0;
        if(tmp%2==0){
            start=tmp/2-1;
            end=tmp/2+1;
        }
        if(tmp%2==1){
            start=tmp/2;
            end=tmp/2+1;
        }
        while(S<=start){
            if(numbers[start]!=numbers[end]){
                memo[S][E]=0;
                sb.append(0).append(System.lineSeparator());;
                return;
            }
            memo[start][end]=1;
            start--;
            end++;
        }
        sb.append(1).append(System.lineSeparator());;
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sb=new StringBuilder();
        numbers = new int[N+1];
        memo = new int[N+1][N+1];
        for(int i=1;i<N+1;i++){
            for(int j=1;j<N+1;j++){
                memo[i][j]=-1;
            }
        }
        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i=1;i<N+1;i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            printIsPalindrome();
        }
        System.out.println(sb);
    }
}