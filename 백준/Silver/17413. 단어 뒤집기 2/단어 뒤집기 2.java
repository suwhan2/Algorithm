import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;


public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String cmd = br.readLine();

        Queue<Character> q = new ArrayDeque<>();
        Stack<Character> s = new Stack<>();
        StringBuilder sb =new StringBuilder();
        boolean check= false;
        for(int i=0;i<cmd.length();i++){
            char c = cmd.charAt(i);
            if(c==' '){
                while(!s.isEmpty()){
                    sb.append(s.pop());
                }
                sb.append(c);
            }
            else if(c=='<'){
                while(!s.isEmpty()){
                    sb.append(s.pop());
                }
                sb.append(c);
                check=true;
            }
            else if(c=='>'){
                sb.append(c);
                check=false;
            }
            else if(check){
                sb.append(c);
            }
            else {
                s.push(c);
            }

        }

        while(!s.isEmpty()){
            sb.append(s.pop());
        }
        System.out.println(sb);
    }
}