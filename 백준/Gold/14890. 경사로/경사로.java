import java.io.*;
import java.util.*;

public class Main {
    static int N,L;
    static int[][] map;
    private static boolean inRange(int x){
        return 0<= x && x<N;
    }

    private static boolean rowChecking(int rowIndex){
        boolean[] hasSlide = new boolean[N];

        for(int i=0;i<N-1;i++){
            if(map[rowIndex][i] == map[rowIndex][i+1]) continue;
            else{
                if(Math.abs(map[rowIndex][i]-map[rowIndex][i+1])>1) return false;
                if(map[rowIndex][i]>map[rowIndex][i+1]){
                    for(int j=i+1;j<=i+L;j++){
                        if(!inRange(j)) return false;
                        if(map[rowIndex][j]!=map[rowIndex][i]-1) return false;
                        if(hasSlide[j]) return false;
                        hasSlide[j]=true;
                    }
                }
                if(map[rowIndex][i]<map[rowIndex][i+1]){
                    for(int j=i;j>=i-L+1;j--){
                        if(!inRange(j)) return false;
                        if(map[rowIndex][j]!=map[rowIndex][i]) return false;
                        if(hasSlide[j]) return false;
                        hasSlide[j]=true;
                    }
                }
            }
        }

        return true;
    }

    private static boolean colChecking(int colIndex){
        boolean[] hasSlide = new boolean[N];
        for(int i=0;i<N-1;i++){
            if(map[i][colIndex] == map[i+1][colIndex]) continue;
            else{
                if(Math.abs(map[i][colIndex]-map[i+1][colIndex])>1) return false;
                if(map[i][colIndex]>map[i+1][colIndex]){
                    for(int j=i+1;j<=i+L;j++){
                        if(!inRange(j)) return false;
                        if(map[j][colIndex]!=map[i][colIndex]-1) return false;
                        if(hasSlide[j]) return false;
                        hasSlide[j]=true;
                    }
                }
                if(map[i][colIndex]<map[i+1][colIndex]){
                    for(int j=i;j>=i-L+1;j--){
                        if(!inRange(j)) return false;
                        if(map[j][colIndex]!=map[i][colIndex]) return false;
                        if(hasSlide[j]) return false;
                        hasSlide[j]=true;
                    }
                }
            }
        }

        return true;
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N  = Integer.parseInt(st.nextToken());
        L  = Integer.parseInt(st.nextToken());
        map =  new int[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans=0;
        for(int i=0;i<N;i++){
            if(rowChecking(i)){
//                System.out.println("success"+i+"row");
                ans++;
            }
            if(colChecking(i)){
//                System.out.println("success"+i+"col");
                ans++;
            }
        }
        System.out.println(ans);
    }
}