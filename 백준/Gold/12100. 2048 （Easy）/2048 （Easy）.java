import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
public class Main {
	static int N,ans;
	static int grid[][],tmp[][];
	static int selected[];
	static List<Integer> arrResult;
	static List<Integer>arr;
	
	
	private static int checkMax() {
		int maxValue =2;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(tmp[i][j]>maxValue) {
					maxValue = tmp[i][j];
				}
			}
		}
		return maxValue;
	}
	private static void cal0(int index){
		arrResult.clear();
		arr.clear();
		for(int i=0;i<N;i++) {
			if(tmp[i][index]!=0) {
				arr.add(tmp[i][index]);
			}
		}
		//4244
	
		for(int i=0;i<arr.size();i++) {
			
			if(i==arr.size()-1) {
				arrResult.add(arr.get(i));
			}
			else if(arr.get(i).equals(arr.get(i+1))) {
				arrResult.add(arr.get(i)*2);
				i++;
			}else {
				arrResult.add(arr.get(i));
			}
		}
	}
	
	private static void cal1(int index){
		arrResult.clear();
		arr.clear();
		for(int i=0;i<N;i++) {
			if(tmp[index][i]!=0) {
				arr.add(tmp[index][i]);
			}
		}

		for(int i=0;i<arr.size();i++) {
			if(i==arr.size()-1) {
				arrResult.add(arr.get(i));
			}
			else if(arr.get(i).equals(arr.get(i+1))) {
				arrResult.add(arr.get(i)*2);
				i++;
			}else {
				arrResult.add(arr.get(i));
			}
		}
			
	}
	private static void cal2(int index){
		arrResult.clear();
		arr.clear();
		for(int i=N-1;i>=0;i--) {
			if(tmp[index][i]!=0) {
				arr.add(tmp[index][i]);
			}
		}

		for(int i=0;i<arr.size();i++) {
			if(i==arr.size()-1) {
				arrResult.add(arr.get(i));
			}
			else if(arr.get(i).equals(arr.get(i+1))) {
				arrResult.add(arr.get(i)*2);
				i++;
			}else {
				arrResult.add(arr.get(i));
			}
		}
	}
	private static void cal3(int index){
		arrResult.clear();
		arr.clear();
		for(int i=N-1;i>=0;i--) {
			if(tmp[i][index]!=0) {
				arr.add(tmp[i][index]);
			}
		}

		
		for(int i=0;i<arr.size();i++) {
			if(i==arr.size()-1) {
				arrResult.add(arr.get(i));
			}
			else if(arr.get(i).equals(arr.get(i+1))) {
				arrResult.add(arr.get(i)*2);
				i++;
			}else {
				arrResult.add(arr.get(i));
			}
		}
	}
	private static void simulation() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				tmp[i][j]=grid[i][j];
			}
		}

		for(int i=0;i<5;i++) {
			
			int dir = selected[i];
			//dir에 따른 동작
			
	
			switch (dir) {
			case 0: {
				for(int j=0;j<N;j++) {
					cal0(j);
					int q=0;
					for(Integer x : arrResult) {
						tmp[q][j]=x;
						q++;
					}
					if(q<N) {
						for(int k=q;k<N;k++) {
							tmp[k][j]=0;
						}
					}
				}
				break;
			}
			case 1: {
				for(int j=0;j<N;j++) {
					cal1(j);
					int q=0;
					for(Integer x : arrResult) {
						tmp[j][q]=x;
						q++;
					}
					if(q<N) {
						for(int k=q;k<N;k++) {
							tmp[j][k]=0;
						}
					}
				}
				break;
			}
			case 2: {
				for(int j=0;j<N;j++) {
					cal2(j);
					int q=N-1;
					for(Integer x : arrResult) {
						
						tmp[j][q]=x;
						q--;
					}
					if(q>=0) {
						for(int k=q;k>=0;k--) {
							tmp[j][k]=0;
						}
					}
				}
	
				break;
			}
			case 3: {
				for(int j=0;j<N;j++) {
					cal3(j);
					int q=N-1;
					for(Integer x : arrResult) {
						tmp[q][j]=x;
						q--;
					}
					if(q>=0) {
						for(int k=q;k>=0;k--) {
							tmp[k][j]=0;
						}
					}
				}
				break;
			}
			}

		}
		
		int cm =checkMax();
		if(cm>ans) {
			ans=cm;
		}

	}
	private static void pick(int cnt) {
		if(cnt==5) {
			simulation();
			return;
		}
		for(int i=0;i<4;i++) {
			selected[cnt]=i;
			pick(cnt+1);
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		grid = new int[N][N];
		tmp = new int[N][N];
		selected = new int[5];
		arrResult = new ArrayList<>();
		arr = new ArrayList<>();
		ans=2;
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				grid[i][j]=Integer.parseInt(st.nextToken());
			}
		}

				pick(0);
		System.out.println(ans);
	}
}
