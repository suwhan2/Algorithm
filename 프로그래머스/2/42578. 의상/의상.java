import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String[] s: clothes){
            map.put(s[1],map.getOrDefault(s[1],0)+1);
        
        }
        
        int answer = 1;
        
        for(String key : map.keySet()){
            answer*=(map.get(key)+1);
        }
        return answer-1;
    }
}