import java.util.*;
class Solution {
    public String solution(String my_string) {
        char[] ans =my_string.toLowerCase().toCharArray();
        Arrays.sort(ans);
        String as = new String(ans);
        return as;
    }
}