import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
class Pair{
    int x,y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int N,M,arrLen,minCantSee;
    static int dx[] = new int[] {1,0,-1,0};
    static int dy[] = new int[] {0,-1,0,1};
    static char grid[][];
    static List<Pair> arr;
    static int selected[];
    static char tmp[][];
    private static boolean inRange(int x,int y) {
        return 0<=x && x<N && 0<=y && y<M;
    }
    private static boolean canGo(int x,int y) {
        if(!inRange(x,y)) return false;
        if(grid[x][y]=='6') return false;
        return true;
    }
    private static void simulation() {
        int i=0;
        int cantSee=0;
        for(Pair p: arr) {
            int x = p.x;
            int y = p.y;
            int dir = selected[i];
            if(grid[x][y]=='1') {
                while(true) {
                    int newX = x+dx[dir];
                    int newY = y+dy[dir];
                    if(canGo(newX,newY)) {
                        if(tmp[newX][newY]=='0') {
                            tmp[newX][newY]='#';
                            x=newX;
                            y=newY;
                        }
                        else {
                            x=newX;
                            y=newY;
                        }
                    }else {
                        break;
                    }
                }
            }

            else if(grid[x][y]=='2') {
                for(int d=0;d<=2;d+=2){
                    while(true) {
                        int newX = x+dx[(dir+d)%4];
                        int newY = y+dy[(dir+d)%4];
                        if(canGo(newX,newY)) {
                            if(tmp[newX][newY]=='0') {
                                tmp[newX][newY]='#';
                                x=newX;
                                y=newY;
                            }else{
                                x=newX;
                                y=newY;
                            }
                        }else {
                            break;
                        }
                    }
                    x = p.x;
                    y = p.y;
                }
            }
            else if(grid[x][y]=='3') {
                for(int d=0;d<2;d++){
                    while(true) {
                        int newX = x+dx[(dir+d)%4];
                        int newY = y+dy[(dir+d)%4];
                        if(canGo(newX,newY)) {
                            if(tmp[newX][newY]=='0') {
                                tmp[newX][newY]='#';
                                x=newX;
                                y=newY;
                            }
                            else {
                                x=newX;
                                y=newY;
                            }
                        }else {
                            break;
                        }
                    }
                    x = p.x;
                    y = p.y;
                }
            }
            else if(grid[x][y]=='4') {
                for(int d=0;d<3;d++){
                    while(true) {
                        int newX = x+dx[(dir+d)%4];
                        int newY = y+dy[(dir+d)%4];
                        if(canGo(newX,newY)) {
                            if(tmp[newX][newY]=='0') {
                                tmp[newX][newY]='#';
                                x=newX;
                                y=newY;
                            }
                            else {
                                x=newX;
                                y=newY;
                            }
                        }else {
                            break;
                        }
                    }
                    x = p.x;
                    y = p.y;
                }
            }
            i++;
        }

        for(int k=0;k<N;k++) {
            for(int l=0;l<M;l++) {
                if(tmp[k][l]=='0') {
                    cantSee++;
                }
            }
        }
        if(minCantSee>cantSee) {
            minCantSee=cantSee;
        }
    }
    private static void pick(int cnt) {
        if(cnt==arrLen) {
            for(int q=0;q<N;q++) {
                for(int w =0;w<M;w++) {
                    tmp[q][w]=grid[q][w];
                }
            }
            simulation();
            return;
        }
        for(int i=0;i<4;i++) {
            selected[cnt]=i;
            pick(cnt+1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        arr = new ArrayList<>();
        minCantSee = N*M;
        grid = new char[N][M];
        tmp= new char[N][M];
        for(int i=0;i<N;i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                grid[i][j]= st2.nextToken().charAt(0);

                if(grid[i][j]!='0' && grid[i][j]!='5'&&grid[i][j]!='6') {
                    //cctv 위치 저장
                    arr.add(new Pair(i,j));
                }
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(grid[i][j]=='5') {
                    for(int k=0;k<4;k++){
                        int g=1;
                        while(true){
                            int newX = i+dx[k]*g;
                            int newY = j+dy[k]*g;
                            if(canGo(newX,newY)){
                                if(grid[newX][newY]=='0'){
                                    grid[newX][newY]='#';
                                }
                            }else {
                                break;
                            }
                            g++;
                        }
                    }
                }
            }
        }
        arrLen = arr.size();
        selected= new int[arrLen];
        pick(0);
        System.out.println(minCantSee);
    }
}