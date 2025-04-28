import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashSet<String> set = new HashSet<>();
        for(String s : phone_book){
            set.add(s);
        }
        
        for(String s : phone_book){
            int n  = s.length();
            StringBuilder sb =new StringBuilder();
            
            for(int i=0;i<n-1;i++){
                sb.append(String.valueOf(s.charAt(i)));
                if(set.contains(sb.toString())){
                    answer=false;
                    break;
                }   
            }
            
            if(!answer) break;    
        }
        return answer;
    }
}