import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);            
        }
        
        int cnt=0;
        for(Integer i : set){
            cnt++;
            if(cnt==(n/2)) break;
        }
        return cnt;
    }
}