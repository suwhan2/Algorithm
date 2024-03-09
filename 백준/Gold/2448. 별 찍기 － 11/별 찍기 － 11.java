import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static String grid[][];
	
	private static void simulation(int x,int y, int n) {
				
		if(n==3) {
			grid[x][y]="*";
			grid[x+1][y-1]="*";
			grid[x+1][y+1]="*";
			grid[x+2][y]="*";
			grid[x+2][y-1]="*";
			grid[x+2][y-2]="*";
			grid[x+2][y+1]="*";
			grid[x+2][y+2]="*";
			return;
		}
		
		simulation(x,y,n/2);
		simulation(x+n/2,y-n/2,n/2);
		simulation(x+n/2,y+n/2,n/2);
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N= Integer.parseInt(br.readLine());
		grid= new String[2*N][2*N];
		
		simulation(0,N-1,N);
		
		for(int i=0;i<2*N;i++) {
			for(int j=0;j<2*N;j++) {
				if(grid[i][j]==null) {
					sb.append(" ");
				}else {
					sb.append("*");
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
}