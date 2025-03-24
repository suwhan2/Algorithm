import java.util.*;
import java.io.*;
public class Main {
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int ans=0;
        for(int i=0;i<N;i++){
            HashSet<Character> word= new HashSet<>();
            String strInput = br.readLine();
            char cur = strInput.charAt(0);
            word.add(strInput.charAt(0));
            boolean check = false;
            for(int j=1;j<strInput.length();j++){
                if(cur==strInput.charAt(j)) continue;

                if(word.contains(strInput.charAt(j))){
                    check=true;
                    break;
                }
                word.add(strInput.charAt(j));
                cur = strInput.charAt(j);
            }
            if(!check) ans++;
        }

        System.out.println(ans);
    }
}