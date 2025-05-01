import java.util.*;

class Task implements Comparable<Task>{
    int num,requestTime,takeTime;
    
    public Task(int num,int requestTime,int takeTime){
        this.num=num;
        this.requestTime=requestTime;
        this.takeTime=takeTime;
    }
    
    @Override
    public int compareTo(Task target) {
        if(this.takeTime>target.takeTime) return 1;
                else if(this.takeTime==target.takeTime){
                    if(this.requestTime>target.requestTime) return 1;
                    else if(this.requestTime==target.requestTime){
                        if(this.num>target.num) return 1;
                    }
                }
                return -1;

    }
}

class Solution {
    public int solution(int[][] jobs) {
        
        PriorityQueue<Task> pq = new PriorityQueue<>();
        
        int answer=0;
        int t=0;
        int n = jobs.length;
        int finishCnt =0;
        
        while(finishCnt<n){
            for(int i=0;i<n;i++){
                if(jobs[i][0]<=t){
                    pq.offer(new Task(i,jobs[i][0],jobs[i][1]));
                    jobs[i][0]=Integer.MAX_VALUE;
                }
            }   
            
            if(pq.isEmpty()){
                t++;
            }
            else{
                Task cur = pq.poll();
                t+=cur.takeTime;
                finishCnt++;
                answer += (t-cur.requestTime);        
            }
        
        }
        
        return answer/n;
    }
}