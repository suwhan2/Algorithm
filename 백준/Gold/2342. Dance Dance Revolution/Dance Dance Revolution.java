import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main{

    static List<Integer> ddrArr = new ArrayList<>();
    static int memo[][][];
    private static int calStepForce(int from,int to){
        if(from==0) return 2;
        else if(from==to) return 1;
        else if(Math.abs(from-to)==2) return 4;
        else return 3;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        while(true){
            int inputDdr = Integer.parseInt(st.nextToken());
            if(inputDdr==0) break;
            ddrArr.add(inputDdr);
        }

        memo = new int[ddrArr.size()+1][5][5];
        memo[0][ddrArr.get(0)][0]=2;
        for(int i=1;i<ddrArr.size();i++){
            int command = ddrArr.get(i);
            for(int j=0;j<5;j++){
                for(int k=0;k<5;k++){
                    if(memo[i-1][j][k]!=0){
                        int tmp = calStepForce(j,command);
                        int tmp2 = calStepForce(k,command);

                        memo[i][command][k]=Math.min(memo[i][command][k],memo[i-1][j][k]+tmp);
                        memo[i][j][command]=Math.min(memo[i][j][command],memo[i-1][j][k]+tmp2);
                        if(memo[i][command][k]==0) memo[i][command][k]=memo[i-1][j][k]+tmp;
                        if(memo[i][j][command]==0) memo[i][j][command]=memo[i-1][j][k]+tmp2;
                    }
                }
            }
        }

        int ans=Integer.MAX_VALUE;
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(memo[ddrArr.size()-1][i][j]!=0){
                    ans=Math.min(memo[ddrArr.size()-1][i][j],ans);
                }
            }
        }

        System.out.println(ans);
    }
}
