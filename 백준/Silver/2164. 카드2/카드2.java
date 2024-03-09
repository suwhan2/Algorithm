import java.io.*;
import java.util.LinkedList;
import java.util.Queue;


public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        int num=1;
        for(int i=0;i<K;i++){
            q.add(num);
            num++;
        }

        while(true){
            if(q.size()==1){
                break;
            }
            q.remove();
            q.add(q.remove());
        }

        System.out.println(q.remove());

    }
}
