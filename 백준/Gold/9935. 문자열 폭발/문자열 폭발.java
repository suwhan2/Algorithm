import java.util.*;
import java.io.*;

public class Main{
    static Stack<Character> s,tmp;
    static char[] bombString;
    static int cp=0;
    static StringBuilder sb;
    private static void checkBoom(){
        if(cp==bombString.length){
            for(int i=0;i<bombString.length;i++){
                s.pop();
            }

            if(s.isEmpty()) cp=0;
            if(!s.isEmpty()){
                int find = s.peek();
                for(int j=0;j<bombString.length;j++){
                    if(find==bombString[j]){
                        cp=(j+1);
                        break;
                    }
                }
            }
        }
    }

    private static void clearStack(){
        if(!s.isEmpty()){
            while(!s.isEmpty()){
                tmp.push(s.pop());
            }
            while(!tmp.isEmpty()){
                sb.append(tmp.pop());
            }
        }
        cp=0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String strInput = br.readLine();
        bombString = br.readLine().toCharArray();
        sb = new StringBuilder();
        s = new Stack<>();
        tmp =new Stack<>();

        for(int i=0;i<strInput.length();i++){
            char current = strInput.charAt(i);

            if(current==bombString[0]){
                s.push(current);
                cp=1;
                checkBoom();
            }
            else if(bombString[cp]==current){
                s.push(current);
                cp++;
                checkBoom();
            }
            else{
                clearStack();
                sb.append(current);
            }
        }

        clearStack();
        if(sb.length()==0) System.out.println("FRULA");
        else System.out.println(sb);
    }
}
