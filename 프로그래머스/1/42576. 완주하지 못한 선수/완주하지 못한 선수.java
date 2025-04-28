import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String s : participant){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        
        for(String s : completion){
            if(map.get(s)==1){
                map.remove(s);
            }else{
                map.put(s,map.get(s)-1);
            }
            
        }
        
        StringBuilder sb = new StringBuilder();
        String answer="";
        for(String s : map.keySet()){
            answer=s;
            // sb.append(s).append(map.get(s)).append("|");
        }
        return answer;
    }
}