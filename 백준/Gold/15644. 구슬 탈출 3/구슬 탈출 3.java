import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    static int N,M,holeX,holeY,RX,RY,BX,BY;
    static char grid[][];
    static int currentArr[];
    static int resultArr[];
    static int ans =Integer.MAX_VALUE;

    private static boolean canPutHole() {
        if(RX==holeX) {
            int result=0;
            for(int i=1;i<=3;i+=2) {
                int x= RX;
                int y= RY;
                while(grid[x][y]!='#') {
                    if(i==1)y++;
                    if(i==3)y--;
                    if(grid[x][y]=='O') {result++; break;}
                    if(grid[x][y]=='B') {result--; break;}
                }
            }
            if(result==1) return true;
        }
        else if(RY==holeY) {
            int result=0;
            for(int i=0;i<=2;i+=2) {
                int x= RX;
                int y= RY;
                while(grid[x][y]!='#') {
                    if(i==0)x++;
                    if(i==2)x--;
                    if(grid[x][y]=='O') {result++; break;}
                    if(grid[x][y]=='B') {result--; break;}
                }
            }
            if(result==1) return true;
        }

        return false;
    }

    private static boolean gravity(int dir) {
        char tmp[][] = new char[N][M];
        switch(dir) {
            case 0:
                for(int i=1;i<M-1;i++) {
                    int index=1;
                    char[] tmpArr = new char[N];
                    for(int j=1;j<=N-2;j++) {
                        if(grid[j][i]!='.' && grid[j][i]!='#'&& grid[j][i]!='O') {
                            tmpArr[index]=grid[j][i];
                            index++;
                        }
                        if(grid[j][i]=='#') {
                            index=j;
                            tmpArr[index]='#';
                            index++;
                        }
                        if(grid[j][i]=='O') {
                            index=j;
                            tmpArr[index]='O';
                            index++;
                        }
                    }
                    for(int j=2;j<N-1;j++) {
                        if(tmpArr[j]=='B') {
                            if(tmpArr[j-1]=='O') {
                                return false;
                            }
                            if(tmpArr[j-1]=='R' && tmpArr[j-2]=='O') {
                                return false;
                            }
                        }
                    }
                    for(int j=1;j<=N-2;j++) {
                        if(tmpArr[j]==0) {
                            tmp[j][i] ='.';
                        }
                        else {
                            tmp[j][i] = tmpArr[j];
                        }

                    }
                }
                for(int i=1;i<N-1;i++) {
                    for(int j=1;j<M-1;j++) {
                        grid[i][j] = tmp[i][j];
                        if(grid[i][j]=='R') {
                            RX=i;
                            RY=j;
                        }
                        if(grid[i][j]=='B') {
                            BX=i;
                            BY=j;
                        }
                    }
                }
                break;
            case 1:
                for(int i=1;i<N-1;i++) {
                    int index=1;
                    char[] tmpArr = new char[M];
                    for(int j=1;j<=M-2;j++) {
                        if(grid[i][j]!='.' && grid[i][j]!='#'&& grid[i][j]!='O') {
                            tmpArr[index]=grid[i][j];
                            index++;
                        }
                        if(grid[i][j]=='#') {
                            index=j;
                            tmpArr[index]='#';
                            index++;
                        }
                        if(grid[i][j]=='O') {
                            index=j;
                            tmpArr[index]='O';
                            index++;
                        }
                    }
                    for(int j=2;j<M-1;j++) {
                        if(tmpArr[j]=='B') {
                            if(tmpArr[j-1]=='O') {
                                return false;
                            }
                            if(tmpArr[j-1]=='R' && tmpArr[j-2]=='O') {
                                return false;
                            }
                        }
                    }
                    for(int j=1;j<=M-2;j++) {
                        if(tmpArr[j]==0) {
                            tmp[i][j] ='.';
                        }
                        else {
                            tmp[i][j] = tmpArr[j];
                        }

                    }
                }
                for(int i=1;i<N-1;i++) {
                    for(int j=1;j<M-1;j++) {
                        grid[i][j] = tmp[i][j];
                        if(grid[i][j]=='R') {
                            RX=i;
                            RY=j;
                        }
                        if(grid[i][j]=='B') {
                            BX=i;
                            BY=j;
                        }
                    }
                }
                break;
            case 2:
                for(int i=1;i<M-1;i++) {
                    int index=1;
                    char[] tmpArr = new char[N];
                    for(int j=N-2;j>=1;j--) {
                        if(grid[j][i]!='.' && grid[j][i]!='#'&& grid[j][i]!='O') {
                            tmpArr[index]=grid[j][i];
                            index++;
                        }
                        if(grid[j][i]=='#') {
                            index=(N-1)-j;
                            tmpArr[index]='#';
                            index++;
                        }if(grid[j][i]=='O') {
                            index=(N-1)-j;
                            tmpArr[index]='O';
                            index++;
                        }
                    }
                    for(int j=2;j<N-1;j++) {
                        if(tmpArr[j]=='B') {
                            if(tmpArr[j-1]=='O') {
                                return false;
                            }
                            if(tmpArr[j-1]=='R' && tmpArr[j-2]=='O') {
                                return false;
                            }
                        }
                    }
                    for(int j=N-2;j>=1;j--) {
                        if(tmpArr[(N-1)-j]==0) {
                            tmp[j][i] ='.';
                        }
                        else {
                            tmp[j][i] = tmpArr[(N-1)-j];
                        }

                    }
                }
                for(int i=1;i<N-1;i++) {
                    for(int j=1;j<M-1;j++) {
                        grid[i][j] = tmp[i][j];
                        if(grid[i][j]=='R') {
                            RX=i;
                            RY=j;
                        }
                        if(grid[i][j]=='B') {
                            BX=i;
                            BY=j;
                        }
                    }
                }
                break;
            case 3:
                for(int i=1;i<N-1;i++) {
                    int index=1;
                    char[] tmpArr = new char[M];
                    for(int j=M-2;j>=1;j--) {
                        if(grid[i][j]!='.' && grid[i][j]!='#'&& grid[i][j]!='O') {
                            tmpArr[index]=grid[i][j];
                            index++;
                        }
                        if(grid[i][j]=='#') {
                            index=(M-1)-j;
                            tmpArr[index]='#';
                            index++;
                        }
                        if(grid[i][j]=='O') {
                            index=(M-1)-j;
                            tmpArr[index]='O';
                            index++;
                        }
                    }
                    for(int j=2;j<M-1;j++) {
                        if(tmpArr[j]=='B') {
                            if(tmpArr[j-1]=='O') {
                                return false;
                            }
                            if(tmpArr[j-1]=='R' && tmpArr[j-2]=='O') {
                                return false;
                            }
                        }
                    }

                    for(int j=M-2;j>=1;j--) {
                        if(tmpArr[(M-1)-j]==0) {
                            tmp[i][j] ='.';
                        }
                        else {
                            tmp[i][j] = tmpArr[(M-1)-j];
                        }

                    }
                }
                for(int i=1;i<N-1;i++) {
                    for(int j=1;j<M-1;j++) {
                        grid[i][j] = tmp[i][j];
                        if(grid[i][j]=='R') {
                            RX=i;
                            RY=j;
                        }
                        if(grid[i][j]=='B') {
                            BX=i;
                            BY=j;
                        }
                    }
                }
                break;
        }

        return true;
    }
    private static void backTracking(int cnt,int dir) {
        if(cnt==10) {
            return;
        }
        if(canPutHole()) {

            if(ans>cnt+1){
                ans=cnt+1;

                for(int i=1;i<ans;i++){
                    resultArr[i]=currentArr[i];
                }
                if(RX==holeX){
                    if(RY>holeY){
                        resultArr[ans]=1;
                    }else{
                        resultArr[ans]=3;
                    }
                }
                if(RY==holeY){
                    if(RX>holeX){
                        resultArr[ans]=0;
                    }else{
                        resultArr[ans]=2;
                    }
                }

            }
            return;
        }

        int tmpRX =RX;
        int tmpRY=RY;
        int tmpBX=BX;
        int tmpBY=BY;
        for(int i=0;i<4;i++) {
            if(dir!=-1) {
                if(i==dir || (i+2)%4==dir) continue;
            }

            if(gravity(i)){
                currentArr[cnt+1]=i;
                backTracking(cnt+1,i);
                for(int q=1;q<N-1;q++){
                    for(int w=1;w<M-1;w++){
                        if(grid[q][w]=='R'||grid[q][w]=='B'){
                            grid[q][w]='.';
                        }
                        if(q==tmpRX && w==tmpRY){
                            grid[q][w]='R';
                        }
                        if(q==tmpBX && w==tmpBY){
                            grid[q][w]='B';
                        }
                    }
                }

            }
        }

    }
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid = new char[N][M];
        currentArr = new int[11];
        resultArr = new int[11];

        for(int i=0;i<N;i++) {
            String strInput = br.readLine();
            for(int j=0;j<M;j++) {
                grid[i][j] = strInput.charAt(j);
                if(grid[i][j]=='O') {
                    holeX=i;
                    holeY=j;
                }
                if(grid[i][j]=='R') {
                    RX=i;
                    RY=j;
                }
                if(grid[i][j]=='B') {
                    BX=i;
                    BY=j;
                }
            }
        }
        backTracking(0,-1);
        if(ans==Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(ans);
        }

        if(ans!=Integer.MAX_VALUE){
            for(int i=1;i<=ans;i++){
                if(resultArr[i]==0){
                    System.out.print("U");
                }else if(resultArr[i]==1){
                    System.out.print("L");
                }else if(resultArr[i]==2){
                    System.out.print("D");
                }else if(resultArr[i]==3){
                    System.out.print("R");
                }else{
                    break;
                }
            }
        }


    }
}