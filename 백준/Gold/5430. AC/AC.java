import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++) {
            Deque<Integer> dq = new LinkedList<>();
            char[] command = br.readLine().toCharArray();
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(),"[,]");

            for(int j=0;j<n;j++) {
                dq.add(Integer.parseInt(st.nextToken()));
            }
            boolean reverse=false;
            boolean errorCheck=false;

            for(char c: command) {
                if(c=='R') {
                    if(!reverse) reverse=true;
                    else reverse=false;
                }else {
                    if(dq.isEmpty()) {
                        System.out.println("error");
                        errorCheck=true;
                        break;

                    }
                    if(reverse){
                        dq.removeLast();
                    }
                    if(!reverse){
                        dq.removeFirst();
                    }
                }
            }

            if(!errorCheck ){
                if(dq.isEmpty()){
                    System.out.println("[]");
                }
                else if(reverse){
                    System.out.print("[");
                    while(dq.size()>1){
                        System.out.print(dq.removeLast()+",");
                    }
                    System.out.print(dq.remove());
                    System.out.println("]");
                }else{
                    System.out.print("[");
                    while(dq.size()>1){
                        System.out.print(dq.removeFirst()+",");
                    }
                    System.out.print(dq.remove());
                    System.out.println("]");
                }
            }
        }
    }
}