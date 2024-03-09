import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(bf.readLine());
        Queue<Integer> q = new LinkedList<>();
        int lastInput=0;
        for(int i=0;i<K;i++) {
            String[] strInput = bf.readLine().split(" ");
            if(strInput[0].equals("push")) {
                lastInput = Integer.parseInt(strInput[1]);
                q.add(lastInput);
            }
            else if(strInput[0].equals("pop")){
                if(q.isEmpty()) {
                    System.out.println(-1);
                }else {
                    System.out.println(q.poll());
                }
            }
            else if(strInput[0].equals("size")){
                System.out.println(q.size());
            }
            else if(strInput[0].equals("empty")){
                if(q.isEmpty()) {
                    System.out.println(1);
                }else {
                    System.out.println(0);
                }
            }
            else if(strInput[0].equals("front")){
                if(q.isEmpty()) {
                    System.out.println(-1);
                }else {
                    System.out.println(q.peek());
                }
            }
            else {
                if(q.isEmpty()) {
                    System.out.println(-1);
                }else {
                    //back: 큐의 가장 뒤에 있는 정수를 출력한다.
                    // 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                    System.out.println(lastInput);
                }
            }
        }

    }
}