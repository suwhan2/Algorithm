import java.util.*;

class Pair{
    int index;
    int cnt;
    
    public Pair(int i,int c){
        this.index =i;
        this.cnt=c;
    }
}
class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int[] visited=new int[n+1];
        
        List<Integer>[] graph = new ArrayList[n+1];
        for(int i=0;i<n+1;i++){
            graph[i] = new ArrayList<Integer>();
        }
        
    
        for(int i=0;i<edge.length;i++){
            graph[edge[i][0]].add(edge[i][1]);
            graph[edge[i][1]].add(edge[i][0]);
        }
        
        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(1,0));
        visited[1]=-1;
        

        
        while(!q.isEmpty()){
            Pair tmp = q.poll();
            
            for(int b : graph[tmp.index]){
                if(visited[b]==0){
                    visited[b]=tmp.cnt+1;
                    q.offer(new Pair(b,tmp.cnt+1));
                }
            }
            
        }
        
        Arrays.sort(visited);
        int a = visited[n];
        for(int i=n;i>=1;i--){
            if(a==visited[i]) answer++;
            else break;
        }
        
        return answer;
    }
}