import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> progressesQ = new ArrayDeque<>();
        Queue<Integer> speedsQ = new ArrayDeque<>();
        int n = progresses.length;
        for(int i=0;i<n;i++){
            progressesQ.offer(progresses[i]);
            speedsQ.offer(speeds[i]);
        }
        List<Integer> answer = new ArrayList<>();
        
        while(!progressesQ.isEmpty()){
            for(int i=0;i<progressesQ.size();i++){
                int curp = progressesQ.poll();
                int curs = speedsQ.poll();
                progressesQ.offer(curp+curs);
                speedsQ.offer(curs);
            }
            
            int cnt=0;
            while(!progressesQ.isEmpty() &&progressesQ.peek()>=100){
                cnt++;
                progressesQ.poll();
                speedsQ.poll();
            }
            if(cnt!=0) answer.add(cnt);
            
        }
        
        int[] answer2 = answer.stream().mapToInt(Integer::intValue).toArray();
        return answer2;
    }
}