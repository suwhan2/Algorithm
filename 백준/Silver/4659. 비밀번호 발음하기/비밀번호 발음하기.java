import java.util.*;
import java.io.*;

public class Main{
    private static boolean check(String s){
        int[] mo = new int[s.length()];
        boolean check1 = false;
        int recent=s.charAt(0);

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u'){
                check1=true;
                mo[i] = 1;
            }
            if(i!=0 && c!='e' && c!='o') if(c==recent) return false;
            recent = c;
        }

        for(int i=0;i<mo.length-2;i++){
            if(mo[i]==mo[i+1] && mo[i+1] == mo[i+2]) return false;
        }

        if(!check1) return false;
        return true;
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            String strInput = br.readLine();
            if(strInput.equals("end")) break;

            sb.append("<").append(strInput).append("> is ");
            boolean result = check(strInput);

            if(result) sb.append("acceptable.").append("\n");
            else sb.append("not acceptable.").append("\n");

        }
        System.out.println(sb);
    }
}