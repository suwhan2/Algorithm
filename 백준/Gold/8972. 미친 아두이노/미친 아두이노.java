import java.util.*;
import java.io.*;

class Pair{
    int x,y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main{
    static int R,C,iX,iY;
    static char[][] grid;
    static char[][] temp;
    static String command;
    static int gameOver=0;
    static List<Pair> crazyArduino = new ArrayList<>();
    static int[] dx = new int[]{2,1,1,1,0,0,0,-1,-1,-1};
    static int[] dy = new int[]{2,-1,0,1,-1,0,1,-1,0,1};
    static Queue<Pair> q = new ArrayDeque<>();
    private static int calDirToGo(int x,int y){
        if(x>iX){
            if(y>iY) return 7;
            else if(y==iY) return 8;
            else return 9;
        }
        else if(x==iX){
            if(y>iY) return 4;
            else return 6;
        }
        else{
            if(y>iY) return 1;
            else if(y==iY) return 2;
            else return 3;
        }
    }
    private static void simulation(int cmd,int cnt){
        grid[iX][iY] = '.';
        iX = iX+dx[cmd];
        iY = iY+dy[cmd];
        if(grid[iX][iY]=='R'){
            gameOver=cnt; return;
        }
        grid[iX][iY]='I';

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(grid[i][j]=='R'){
                    int dir = calDirToGo(i,j);
                    int nx=i+dx[dir];
                    int ny=j+dy[dir];
                    if(grid[nx][ny]=='I'){
                        gameOver=cnt; return;
                    }
                    if(temp[nx][ny]=='R'){
                        q.offer(new Pair(nx,ny));
                    }
                    temp[nx][ny]='R';
                }
            }
        }
        while(!q.isEmpty()){
            Pair tmp = q.poll();
            temp[tmp.x][tmp.y]='.';
        }

    }
    public static void main(String[] args) throws IOException {
        //입력부
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        grid = new char[R][C];
        for(int i=0;i<R;i++){
            String strInput = br.readLine();
            for (int j=0;j<C;j++){
                grid[i][j] = strInput.charAt(j);
                if(grid[i][j]=='R') crazyArduino.add(new Pair(i,j));
                if(grid[i][j]=='I'){
                    iX=i;
                    iY=j;
                }
            }
        }
        command = br.readLine();

        //동작부
        for(int i=0;i<command.length();i++){
            temp = new char[R][C];
            simulation(command.charAt(i)-'0',i+1);
            if(gameOver>0) break;
            for(int j=0;j<R;j++){
                for(int k=0;k<C;k++){
                    if(grid[j][k]=='R') grid[j][k]='.';
                    if(temp[j][k]=='R') grid[j][k]='R';
                }
            }
        }
        //출력부
        if(gameOver>0) System.out.println("kraj "+gameOver);
        else{
            for(int i=0;i<R;i++){
                for(int j=0;j<C;j++){
                    System.out.print(grid[i][j]);
                }
                System.out.println();
            }
        }
    }
}
