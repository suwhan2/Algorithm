import java.util.*;

class Solution {
    
    
    public int solution(int distance, int[] rocks, int n) {
      
        int answer = 0;
        Arrays.sort(rocks);
        
        int s = 1;
        int e = distance;
        int mid;
        
        while(s<=e){
            mid = (s+e)/2;
            
            int before=0;
            int cnt=0;
            for(int i : rocks){
                if( i-before < mid ){
                    cnt++;
                }
                else{ 
                    before=i;    
                }
            }
            
            if(distance-before<mid) cnt++;
            
            if(cnt>n){
                e=mid-1;
            }else{
                answer = Math.max(answer,mid);
                s=mid+1;
            }
            
        }
        return answer;
    }
}