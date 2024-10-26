import java.io.*;
import java.util.StringTokenizer;

class Pair{
    int top,left,back;
    public Pair(int t,int l,int b){
        this.top=t;
        this.left=l;
        this.back=b;
    }
}
public class Main{
    static int N,M,x,y,K;
    static int[][] map;
    static int[] dice;
    static Pair status=new Pair(0,1,2);;
    static int[] dx = new int[]{0,0,-1,1};
    static int[] dy = new int[]{1,-1,0,0};
    private static boolean inRange(int x,int y){
        return 0<=x && x<N && 0<=y && y<M;
    }
    private static void turn(int cmd){
        int tmp=0;
        switch(cmd){
            case 0:
                tmp =status.top;
                status.top = status.left;
                status.left = (tmp+3)%6;
                break;
            case 1:
                tmp = status.left;
                status.left=status.top;
                status.top = (tmp+3)%6;
                break;
            case 2:
                tmp = status.back;
                status.back=status.top;
                status.top = (tmp+3)%6;
                break;
            default:
                tmp = status.top;
                status.top = status.back;
                status.back = (tmp+3)%6;
                break;
        }
    }
    private static void move(int cmd){

        int nx = x+dx[cmd];
        int ny = y+dy[cmd];
        if(inRange(nx,ny)){
            turn(cmd);
            if(map[nx][ny]==0) map[nx][ny]=dice[(status.top+3)%6];
            else{
                dice[(status.top+3)%6]=map[nx][ny];
                map[nx][ny]=0;
            }
            x=nx;
            y=ny;
            System.out.println(dice[status.top]);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dice = new int[6];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<K;i++){
            move(Integer.parseInt(st.nextToken())-1);
        }
    }
}