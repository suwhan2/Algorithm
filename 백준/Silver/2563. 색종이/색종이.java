import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =Integer.parseInt(br.readLine());
        int ans=N*100;
        int grid[][] = new int[101][101];
        for(int i=0;i<N;i++) {
        	StringTokenizer st= new StringTokenizer(br.readLine());
        	int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        	
        	for(int j=x;j<x+10;j++) {
        		for( int k=y;k<y+10;k++) {
        			grid[j][k]++;
        		}
        	}
        }
        
        
        for(int i=0;i<101;i++) {
        	for(int j=0;j<101;j++) {
        		if(grid[i][j]>1) {
        			ans=ans - (grid[i][j]-1);
        		}
        	}
        }
        
        System.out.println(ans);

    }
}