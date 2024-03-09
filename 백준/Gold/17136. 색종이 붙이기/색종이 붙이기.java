import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    static int grid[][] = new int[10][10];
    static int ans=26;
    static int endIndexX=0;
    static int endIndexY=0;
    static int colorPaperCount=0;
    static int colorPaper[] =new int[]{0,5,5,5,5,5};

    private static boolean inRange(int x,int y){
        return 0<=x&&x<10&&0<=y&&y<10;
    }
    private static boolean canPutColorPaper(int x,int y,int paperNum){
        int tmpx = x+paperNum-1;
        int tmpy = y+paperNum-1;
        if(!inRange(tmpx,tmpy)) return false;

        for(int i=x;i<x+paperNum;i++){
            for(int j=y;j<y+paperNum;j++){
                if(grid[i][j]==0) return false;
            }
        }
        return true;
    }
    private static void eraseOneByColorPaper(int x,int y,int paperNum){
        for(int i=x;i<x+paperNum;i++){
            for(int j=y;j<y+paperNum;j++){
                grid[i][j]=0;
            }
        }
    }
    private static void makeOneByColorPaper(int x,int y,int paperNum){
        for(int i=x;i<x+paperNum;i++){
            for(int j=y;j<y+paperNum;j++){
                grid[i][j]=1;
            }
        }
    }

    private static void backTracking(int x,int y) {

        //기저조건
        if(x==endIndexX && y==endIndexY) {
            ans=Math.min(ans, colorPaperCount);

            return;
        }

        //for색종이 고르기
        for(int i=5;i>=1;i--){
            if(colorPaper[i]==0)continue;
            if(canPutColorPaper(x,y,i)){
                colorPaper[i]--;
                eraseOneByColorPaper(x,y,i);
                colorPaperCount++;

                int tmpx=x;
                int tmpy=y;
                do{
                    if(tmpy==9){
                        tmpx++;tmpy=0;
                    }else{
                        tmpy++;
                    }

                    if(tmpx==endIndexX && tmpy==endIndexY) break;
                }while(grid[tmpx][tmpy]==0);
                //재귀
                backTracking(tmpx,tmpy);
                //0 -> 1 채우기
                colorPaper[i]++;
                makeOneByColorPaper(x,y,i);
                colorPaperCount--;
            }
            //1->0 지우기
            //if( 색종이 채우다가 오류날경우 ) continue;

        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        //빽트래킹으로 큰것부터 가능하면 -1 재귀 리턴시 +1
        //주의 0과 -1이 다름

        //입력부
        boolean check =false;
        int startx = 0;
        int starty = 0;
        for(int i=0;i<10;i++) {
            st= new StringTokenizer(br.readLine());
            for(int j=0;j<10;j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if(grid[i][j]==1 && !check) {
                    check = true;
                    startx=i;
                    starty=j;
                }
                if(grid[i][j]==1) {
                    endIndexX=i;
                    endIndexY=j;
                }

            }
        }

        //출력
        if(!check) {
            System.out.println(0);
        }else {
            if(endIndexY==9) {
                endIndexY=0;
                endIndexX+=1;
            }else {
                endIndexY+=1;
            }

            //백트래킹
            backTracking(startx,starty);
            if(ans==26) {
                System.out.println(-1);
            }else {
                System.out.println(ans);
            }

        }

    }

}
