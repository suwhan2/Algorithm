import java.io.*;

public class Main{
    static int[] APB;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        APB = new int[26];

        for(int i=0;i<word.length();i++){
            int num = word.charAt(i);
            if(num>=97){
                APB[num-97]++;
            }else{
                APB[num-65]++;
            }
        }
        
        int maxApb = -1;
        for(int a : APB){
            maxApb = Math.max(maxApb,a);
        }

        StringBuilder sb= new StringBuilder();
        int cnt=0;
        for(int i=0;i<26;i++){
            if(maxApb==APB[i]){
                sb.append((char)(i+65));
                cnt++;
            }
        }
        if(cnt!=1) System.out.println("?");
        else System.out.println(sb);
    }
}