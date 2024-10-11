import java.util.*;
class Solution {
    public int[] solution(String my_string) {
        String a = my_string.replaceAll("[a-z]","");
        System.out.println(a);
        String[] b = a.split("");
        
        int[] c = new int[b.length];
        for(int i=0;i<b.length;i++){
            c[i] = Integer.parseInt(b[i]);
        }
        
        Arrays.sort(c);
        return c;
        
        
    }
}