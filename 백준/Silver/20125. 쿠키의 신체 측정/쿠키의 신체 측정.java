import java.io.*;

public class Main {
    static int n;
    private static boolean inRange(int x,int y){
        return 0<=x && x<n && 0<=y && y<n;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        char[][] grid = new char[n][n];

        for(int i=0;i<n;i++){
            grid[i]=br.readLine().toCharArray();
        }
        StringBuilder sb = new StringBuilder();


        int heartX = 0;
        int heartY=0;
        boolean check = false;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='*'){
                    sb.append(i+2).append(" ").append(j+1).append("\n");
                    heartX=i+1;
                    heartY=j;
                    check =true;
                    break;
                }
            }
            if(check) break;
        }


        int cnt=1;
        while(true){
            if(inRange(heartX,heartY-cnt)&& grid[heartX][heartY-cnt]=='*') cnt++;
            else break;
        }
        sb.append(cnt-1).append(" ");

        cnt=1;
        while(true){
            if(inRange(heartX,heartY+cnt)&&grid[heartX][heartY+cnt]=='*') cnt++;
            else break;
        }
        sb.append(cnt-1).append(" ");

        int hx=0;
        int hy=0;

        cnt=1;
        while(true){
            if(inRange(heartX+cnt,heartY) && grid[heartX+cnt][heartY]=='*') cnt++;
            else{
                hx=heartX+cnt;
                hy=heartY;
                break;
            }
        }
        sb.append(cnt-1).append(" ");

        cnt=0;
        while(true){
            if(inRange(hx+cnt,hy-1) && grid[hx+cnt][hy-1]=='*') cnt++;
            else break;
        }
        sb.append(cnt).append(" ");

        cnt=0;
        while(true){
            if(inRange(hx+cnt,hy+1) && grid[hx+cnt][hy+1]=='*') cnt++;
            else break;
        }
        sb.append(cnt).append(" ");

        System.out.print(sb.toString().trim());
    }
}