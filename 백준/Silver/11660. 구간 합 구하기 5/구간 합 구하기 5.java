import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static int N;
    static int M;
    static int arr[][];
    static int reviseArr[][];
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr= new int[N][N];
        reviseArr = new int[N+1][N+1];

        for(int i=0;i<N;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        int tmp=0;
        for(int i=0;i<N;i++){
            tmp+=arr[0][i];
            reviseArr[1][i+1]= tmp;
        }
        int tmp2=0;
        for(int i=0;i<N;i++){
            tmp2+=arr[i][0];
            reviseArr[i+1][1]=tmp2;
        }

        for(int i=1;i<N;i++){
            for(int j=1;j<N;j++){
                int cal = reviseArr[i+1][j]+reviseArr[i][j+1]+arr[i][j]-reviseArr[i][j];
                reviseArr[i+1][j+1]=cal;
            }
        }

        for(int i=0;i<M;i++){
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            int x1 =Integer.parseInt(st3.nextToken());
            int y1 =Integer.parseInt(st3.nextToken());
            int x2 =Integer.parseInt(st3.nextToken());
            int y2 =Integer.parseInt(st3.nextToken());

            int ans=reviseArr[x2][y2]+reviseArr[x1-1][y1-1]-reviseArr[x1-1][y2]-reviseArr[x2][y1-1];
            System.out.println(ans);
        }



    }
}