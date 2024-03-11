import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
	static int T,n;
	static int arr[],visited[];
	static int ans=0;
	static Queue<Integer> q = new ArrayDeque<>();
	

	private static void bfs(int startIdx) {
		while(!q.isEmpty()) {
			int tmp = q.poll();
	
			if(visited[arr[tmp]]==0) {
				visited[arr[tmp]]=2;
				q.offer(arr[tmp]);
			}
			else { //막혔을때
				if(visited[arr[tmp]]==2) {
					//1로만들기
					int current=arr[tmp];
					while(true) {
						if(visited[current]==1) break;
						visited[current]=1;
						current=arr[current];
						
					}
				}
					//-1로 만들기
					int current = startIdx;
					while(true) {
						if(visited[current]==1 || visited[current]==-1) break;
						visited[current]=-1;
						current=arr[current];
					}
					
				
				
		}
	}
	}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        int selfCount=0;
        for(int t=0;t<T;t++) {
        	n = Integer.parseInt(br.readLine());
        	arr= new int[n+1];
        	visited = new int[n+1];
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int i=1;i<=n;i++) {
        		arr[i] = Integer.parseInt(st.nextToken());	
        		if(i==arr[i]) {
        			selfCount++;
        			visited[i]=-1;
        		}
        	}
        	
        	for(int i=1;i<=n;i++) {
        		if(visited[i]!=0) continue;
        		q.offer(i);
            	bfs(i);
        	}
        	
        	
        	for(int j=1;j<=n;j++) {
        		if(visited[j]!=1) ans++;
        	}
        	System.out.println(ans-selfCount);
        	ans=0;
        	selfCount=0;
        }
    }
}