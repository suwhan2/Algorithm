import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    static int ans;
    static int N,W,H;
    static int grid[][],tmp[][];
    static int selected[];
    static int dx[] = new int[]{1,0,-1,0};
    static int dy[] = new int[]{0,1,0,-1};
 
 
    private static boolean inRange(int x,int y){
        return 0<=x && x<H&&0<=y &&y<W;
    }
 
    private static void boom(int x,int y) {
        if(tmp[x][y]==0){
            return;
        }
        int range = tmp[x][y];
        tmp[x][y]=0;
        for(int i=0;i<4;i++){
            for(int j=1;j<range;j++){
                int newX = x +(dx[i]*j);
                int newY = y +(dy[i]*j);
                if(inRange(newX,newY)){
                    boom(newX,newY);
                }
            }
        }
 
    }
    private static void simulation(){
 
        for(int i=0;i<N;i++){
            for(int j=0;j<H;j++){
                if(tmp[j][selected[i]]!=0){
                    boom(j,selected[i]);
                    for(int q=0;q<W;q++){
                        int cleanUpArr[] = new int[H];
                        int n=0;
                        for(int w=H-1;w>=0;w--){
                            if(tmp[w][q]!=0){
                                cleanUpArr[n]=tmp[w][q];
                                n++;
                            }
                        }
                        for(int w=H-1;w>=0;w--){
                            tmp[w][q]=cleanUpArr[H-1-w];
                        }
                    }
                    break;
                }
            }
        }
 
        int count=0;
        for(int i=0;i<H;i++){
            for(int j=0;j<W;j++){
                if(tmp[i][j]>0)
                    count++;
            }
        }
        ans=Math.min(ans,count);
    }
 
    private static void pick(int cnt){
        if(cnt==N){
            tmp= new int[H][W];
            for(int i=0;i<H;i++){
                for(int j=0;j<W;j++){
                    tmp[i][j]=grid[i][j];
                }
            }
            //계산
            simulation();
            return;
        }
        for(int i=0;i<W;i++){
            selected[cnt]=i;
            pick(cnt+1);
 
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++) {
            StringTokenizer st =new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            grid = new int[H][W];
            ans=W*H;
            for(int i=0;i<H;i++){
                st= new StringTokenizer(br.readLine());
                for(int j=0;j<W;j++){
                    grid[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            //구현부
            selected = new int[N];
            pick(0);
 
            System.out.println("#" + (t + 1) + " " + ans);
        }
    }
}