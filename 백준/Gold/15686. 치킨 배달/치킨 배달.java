import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//r과c는 1부터 시작
// 집의개수 <= 2N, 적어도 1개
// M<= 치킨집 개수 <=13
// M개를 뽑았을때 최소 치킨거리의 합
class Pair{
	int x,y;

	public Pair(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}
public class Main {
	static int MAX_VALUE = Integer.MAX_VALUE;
	static int N,M;
	static int grid[][],tmpGrid[][];
	static boolean visited[][];
	static int distance[][];
	static int minAns;
	static List<Pair> chicken = new ArrayList<>();
	static List<Pair> house = new ArrayList<>();
	static Pair selected[];
	static int cityChickenDistance=0;
	static boolean check=false;
	static List<Integer> tmpDis = new ArrayList<>();
	
	private static void bfs(int x,int y) {
		for(Pair p : selected) {
			tmpDis.add(Math.abs(p.x-x)+Math.abs(p.y-y));
		}

	}
	private static void simulation() {
		//tmpGrid초기화
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				tmpGrid[i][j]=0;
			}
		}
		for(Pair x : house) {
			tmpGrid[x.x][x.y]=1;
		}
		for(Pair x : selected) {
			tmpGrid[x.x][x.y]=2;
		}
		for(Pair x : house) {

			bfs(x.x,x.y);
			int tmpDisValue=MAX_VALUE;
			for(Integer x1 : tmpDis) {
				tmpDisValue=Math.min(x1,tmpDisValue);
			}
			cityChickenDistance += tmpDisValue;
			//초기화
			tmpDisValue=MAX_VALUE;
			tmpDis.clear();
		}
		minAns = Math.min(minAns,cityChickenDistance);
		cityChickenDistance=0;
	}
	private static void pick(int cnt, int startIdx) {
		if(cnt==M) {
			simulation();
			return;
		}
		
		for(int i=startIdx;i<chicken.size();i++) {
			selected[cnt]=chicken.get(i);
			pick(cnt+1,i+1);
		}
		
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		//입력부
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		grid = new int[N][N];
		tmpGrid = new int[N][N];
		selected = new Pair[M];
		minAns = MAX_VALUE;
		
		for(int i=0;i<N;i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				grid[i][j]=Integer.parseInt(st2.nextToken());
				if(grid[i][j]==2) {
					chicken.add(new Pair(i,j));
				}
				if(grid[i][j]==1) {
					house.add(new Pair(i,j));
				}
			}
		}
		
		//기능부
		//조합으로 치킨 집 뽑기
		//각 집에서 최단거리 구하기
		pick(0,0);

		//출력부
		System.out.println(minAns);
		
	}
}
