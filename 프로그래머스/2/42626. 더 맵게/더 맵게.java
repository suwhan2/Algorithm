import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i : scoville){
            pq.offer(i);
        }
        
        int answer = 0;
        while(pq.size()>=2 && pq.peek()<K){
            answer++;
            int sum=0;
            sum+= pq.poll();
            sum+=(2*pq.poll());
            pq.offer(sum);
        }
        
        if(pq.peek()<K) answer=-1;
        return answer;
    }
}