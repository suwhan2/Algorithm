//5개 4x4x4x4x4 (회전) =1024 x120 (순서) x bfs(125) =15,360,000
//시간은 여유롭다 구현문제

import java.util.*;
import java.io.*;

class Index{
    int x,y,z,cnt;
    public Index(int x,int y ,int z,int cnt){
        this.x=x;
        this.y=y;
        this.z=z;
        this.cnt=cnt;
    }
}

public class Main{
    static int[][][] maze;
    static int[][][] tmpMaze;
    static boolean[] picked;
    static int[] howToMake;
    static int ans=Integer.MAX_VALUE;

    static int dx[] = new int[]{1,0,-1,0,0,0};
    static int dy[] = new int[]{0,1,0,-1,0,0};
    static int dz[] = new int[]{0,0,0,0,1,-1};

    private static boolean inRange(int z, int x,int y){
        return 0<=x && x<5 && 0<=y && y<5 && 0<=z && z<5;
    }
    private static void bfs(){
        Queue<Index> q = new ArrayDeque<>();
        boolean[][][] visited = new boolean[5][5][5];
        q.offer(new Index(0,0,0,0));
        visited[0][0][0]=true;

        while(!q.isEmpty()){
            Index tmp = q.poll();
            if(tmp.x==4 && tmp.y==4 && tmp.z==4){
                ans= Math.min(ans,tmp.cnt);
                break;
            }

            for(int i=0;i<6;i++){
                int nx = tmp.x+dx[i];
                int ny = tmp.y+dy[i];
                int nz = tmp.z+dz[i];
                if(inRange(nz,nx,ny) && !visited[nz][nx][ny] && tmpMaze[nz][nx][ny]==1){
                    visited[nz][nx][ny]=true;
                    q.offer(new Index(nx,ny,nz,tmp.cnt+1));

                }
            }
        }

    }
    private static void turn(int num){
        int[][] tmp = new int[5][5];

        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                tmp[i][j] = maze[num][j][4-i];
            }
        }

        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                maze[num][i][j]=tmp[i][j];
            }
        }

    }

    private static void simulation(int cnt){
        if(cnt==5){
            //maze를 가지고 순서대로 조립 tmpMaze만들기
            tmpMaze =new int[5][5][5];

            for(int i=0;i<5;i++){
                for(int j=0;j<5;j++){
                    for(int k=0;k<5;k++){
                        tmpMaze[i][j][k]=maze[howToMake[i]][j][k];
                    }
                }
            }

            if(tmpMaze[0][0][0]==1 && tmpMaze[4][4][4]==1) bfs();
            return;
        }

        for(int i=0;i<5;i++){
            if(picked[i]) continue;
            howToMake[cnt] = i;
            picked[i]=true;
            simulation(cnt+1);
            picked[i]=false;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        maze = new int[5][5][5];
        howToMake = new int[5];
        StringTokenizer st;

        for(int k=0;k<5;k++){
            for(int i=0;i<5;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<5;j++){
                    maze[k][i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }


        //돌리기

        for(int i=0;i<4;i++){
            turn(0);
            for(int j=0;j<4;j++){
                turn(1);
                for(int k=0;k<4;k++){
                    turn(2);
                    for(int l=0;l<4;l++){
                        turn(3);
                        for(int o=0;o<4;o++){
                            turn(4);
                            picked=new boolean[5];
                            simulation(0);
                        }
                    }
                }
            }
        }
        //순서

        if(ans==Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(ans);

    }
}