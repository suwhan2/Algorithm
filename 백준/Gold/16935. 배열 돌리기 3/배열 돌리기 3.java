import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int R;
	static int grid[][];
	static int tmp[][];
	

	
	private static void command1() {
		tmp = new int[N][M];
		for(int j=0;j<M;j++) {
			for(int i=N-1;i>=0;i--) {
				tmp[N-1-i][j] = grid[i][j];
			}
		}
		grid=tmp;
		
	}
	
	private static void command2()
	{	
		tmp = new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=M-1;j>=0;j--) {
				tmp[i][M-1-j] = grid[i][j];
			}
		}
		grid=tmp;
	}
	private static void command3() {
		tmp= new int[M][N];
		for(int j=0;j<M;j++) {
			for(int i=N-1;i>=0;i--) {
				tmp[j][N-1-i]=grid[i][j]; 
			}
		}
		
		int a = N;
		N=M;
		M=a;
		
		grid=tmp;

		
	}
	private static void command4() {
		tmp = new int[M][N];
		for(int i=0;i<N;i++) {
			for(int j=M-1;j>=0;j--) {
				tmp[M-1-j][i]=grid[i][j]; 
			}
		}
		int a = N;
		N=M;
		M=a;
		
		grid=tmp;

	}
	private  static void command5() {
			tmp = new int[N/2][M/2];
			// 1 -> 2
			for(int i=0;i<N/2;i++) {
				for(int j=0;j<M/2;j++) {
					tmp[i][j]=grid[i][j];
					grid[i][j] = grid[i][j+M/2];
					grid[i][j+M/2]=tmp[i][j];
				}
			}
			//1->3
			for(int i=0;i<N/2;i++) {
				for(int j=0;j<M/2;j++) {
					tmp[i][j]=grid[i][j];
					grid[i][j] = grid[i+N/2][j+M/2];
					grid[i+N/2][j+M/2]=tmp[i][j];
				}
			}
			//1->4
			for(int i=0;i<N/2;i++) {
				for(int j=0;j<M/2;j++) {
					tmp[i][j]=grid[i][j];
					grid[i][j] = grid[i+N/2][j];
					grid[i+N/2][j]=tmp[i][j];
				}
			}
			
		
	}
	private  static void command6() {
		
			tmp = new int[N/2][M/2];
			//1->4
			for(int i=0;i<N/2;i++) {
				for(int j=0;j<M/2;j++) {
					tmp[i][j]=grid[i][j];
					grid[i][j] = grid[i+N/2][j];
					grid[i+N/2][j]=tmp[i][j];
				}
			}
			//1->3
			for(int i=0;i<N/2;i++) {
				for(int j=0;j<M/2;j++) {
					tmp[i][j]=grid[i][j];
					grid[i][j] = grid[i+N/2][j+M/2];
					grid[i+N/2][j+M/2]=tmp[i][j];
				}
			}
			// 1 -> 2
			for(int i=0;i<N/2;i++) {
				for(int j=0;j<M/2;j++) {
					tmp[i][j]=grid[i][j];
					grid[i][j] = grid[i][j+M/2];
					grid[i][j+M/2]=tmp[i][j];
				}
			}			
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		grid= new int[N][M];
		tmp = new int[N][M];
		for(int i=0;i<N;i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				grid[i][j]=Integer.parseInt(st2.nextToken());
			}
		}
		
		StringTokenizer st3 = new StringTokenizer(br.readLine());
		for(int i=0;i<R;i++) {
			switch(st3.nextToken()) {
			case "1":
				command1();
				break;
			case "2":
				command2();
				break;
			case "3":
				command3();
				break;
			case "4":
				command4();
				break;
			case "5":
				command5();
				break;
			case "6":
				command6();
				break;
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(grid[i][j]+" ");
					
			}
			System.out.println();
		}

    }
}
