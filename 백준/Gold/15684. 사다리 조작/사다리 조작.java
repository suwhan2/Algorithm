import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
 
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int width, height, M, ans;
    private static int[][] map;
    private static boolean isFinish = false;
 
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        width = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); 
        height = Integer.parseInt(st.nextToken());
 
        map = new int[height + 1][width + 1];
        for (int y = 0; y < M; y++) {
            st = new StringTokenizer(br.readLine());
 

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;     
            map[a][b + 1] = 2; 
        }
 

        for (int i = 0; i <= 3; i++) {
            ans = i;
            dfs(1, 1, 0);
            if (isFinish) break;
        }
 
        System.out.println((isFinish ? ans : -1));
        br.close();
    }
 

    private static void dfs(int x, int y, int addHorizontalLineNumber) {
        if (isFinish) return;
        if (ans == addHorizontalLineNumber) {
            if (check()) isFinish = true;
            return;
        }
 
        for (int i = y; i <= height; i++) {
            for (int j = x; j < width; j++) {
                              if (map[i][j] == 0 && map[i][j + 1] == 0) {
                    
                    map[i][j] = 1;
                    map[i][j + 1] = 2;
 
                    dfs(1, 1, addHorizontalLineNumber + 1);
 
                  
                    map[i][j] = 0;
                    map[i][j + 1] = 0;
                }
            }
        }
    }
 
    private static boolean check() {
        for (int i = 1; i <= width; i++) {
            int nx = i;
            int ny = 1;
 
            while (ny <= height) {
                if (map[ny][nx] == 1) nx++; 
                else if (map[ny][nx] == 2) nx--; 
                ny++; 
            }
 
            if (nx != i) return false;         }
 
        return true;
    }
}