import java.util.*;
import java.io.*;

public class Main{
    static int M;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        List<Character> text = new LinkedList<>();
        String startText = br.readLine();
        for (char c : startText.toCharArray()) {
            text.add(c);
        }

        ListIterator<Character> iter = text.listIterator();
        while(iter.hasNext()) {
            iter.next();
        }
        M =Integer.parseInt(br.readLine());
        
        for(int i = 0; i < M; i++) {
            String command = br.readLine();
            char c = command.charAt(0);
            switch(c) {
                case 'L':
                    if(iter.hasPrevious())
                        iter.previous();

                    break;
                case 'D':
                    if(iter.hasNext())
                        iter.next();

                    break;
                case 'B':
                    if(iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                    break;
                case 'P':
                    char t = command.charAt(2);
                    iter.add(t);

                    break;
                default:
                    break;
            }
        }
        for(Character data : text){
            sb.append(data);
        }
        System.out.println(sb);
    }

}