import java.util.*;
import java.io.*;
class Pair{
    int x,y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int h,w;
    static char[][] map;
    static boolean[] key;
    static boolean[][] visited;
    static Queue<Pair> q =new ArrayDeque<>();
    static int[] dx =new int[]{1,0,-1,0};
    static int[] dy =new int[]{0,1,0,-1};
    static ArrayList<Pair>[] wait;
    static int ans=0;
    private static boolean inRange(int x,int y){
        return 0<=x && x<h && 0<=y && y<w;
    }

    private static void bfs(){
        while(!q.isEmpty()){
            Pair cur = q.poll();
            if(map[cur.x][cur.y]=='$') ans++;


            for(int i=0;i<4;i++) {
                int nx = cur.x+dx[i];
                int ny = cur.y+dy[i];
                if(inRange(nx,ny) && map[nx][ny]!='*' && !visited[nx][ny]){
                    if('a'<=map[nx][ny] && map[nx][ny]<='z'){
                        key[(map[nx][ny]-'a')]=true;
                        for(Pair p : wait[map[nx][ny]-'a']){
                            q.offer(p);
                            visited[p.x][p.y]=true;
                        }
                        wait[map[nx][ny]-'a'].clear();
                    }
                    if('A'<=map[nx][ny] && map[nx][ny]<='Z'){
                        if(!key[(map[nx][ny]-'A')]){
                            wait[map[nx][ny]-'A'].add(new Pair(nx,ny));
                            continue;
                        }
                    }
                    visited[nx][ny]=true;
                    q.offer(new Pair(nx,ny));
                }
            }
        }
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb= new StringBuilder();
        for(int t=0;t<T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            map =new char[h][w];
            visited = new boolean[h][w];
            key = new boolean[26];
            wait = new ArrayList[26];

            for(int i=0;i<26;i++){
                wait[i] = new ArrayList<>();
            }

            for(int i=0;i<h;i++){
                String strInput = br.readLine();
                for(int j=0;j<w;j++){
                    map[i][j] = strInput.charAt(j);
                }
            }

            String keyInput = br.readLine();
            for(int i=0;i<keyInput.length();i++){
                if(keyInput.charAt(i)=='0') break;
                key[(keyInput.charAt(i)-'a')]=true;
            }

            for(int i=0;i<h;i++){
                for(int j=0;j<w;j++){
                    if(i==0 || j==0 || i==(h-1) || j==(w-1)) {
                        if (map[i][j] != '*') {
                            if ('a' <= map[i][j] && map[i][j] <= 'z') {
                                key[(map[i][j] - 'a')] = true;
                                for (Pair p : wait[map[i][j] - 'a']) {
                                    q.offer(p);
                                    visited[p.x][p.y] = true;
                                }
                                wait[map[i][j] - 'a'].clear();
                            }
                            if ('A' <= map[i][j] && map[i][j] <= 'Z') {
                                if (!key[(map[i][j] - 'A')]) {
                                    wait[map[i][j] - 'A'].add(new Pair(i, j));
                                    continue;
                                }
                            }
                            q.offer(new Pair(i, j));
                            visited[i][j] = true;
                        }
                    }
                }
            }

            bfs();
            sb.append(ans).append("\n");
            ans=0;
            q.clear();
        }

        System.out.println(sb);
    }
}