import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int maxAns=Integer.MIN_VALUE;
    static int minAns=Integer.MAX_VALUE;
    static int[] num;
    static int[] operator;
    static int[] picked;

    private static int calculate(){
        int target = num[0];

        for(int i=1;i<N;i++) {
            switch (picked[i-1]) {
                case 1: {
                    target += num[i];
                    break;
                }
                case 2: {
                    target -= num[i];
                    break;
                }
                case 3: {
                    target *= num[i];
                    break;
                }
                default: {
                    target /= num[i];
                    break;
                }
            }
        }
        return target;
    }
    private static void simulation(int cnt){
        if(cnt==(N-1)){

            int result = calculate();
            maxAns = Math.max(maxAns,result);
            minAns = Math.min(minAns,result);
            return;
        }

        for(int i=1;i<=4;i++){
            if(operator[i]==0) continue;
            operator[i]--;
            picked[cnt]=i;
            simulation(cnt+1);
            operator[i]++;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        num = new int[N];
        picked = new int[N-1];
        operator = new int[5];


        for(int i=0;i<N;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=4;i++){
            operator[i] = Integer.parseInt(st.nextToken());
        }

        simulation(0);
        System.out.println(maxAns);
        System.out.println(minAns);
    }
}