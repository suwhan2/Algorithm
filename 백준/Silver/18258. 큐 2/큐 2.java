import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int K = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        int lastPut=0;
        for(int i=0;i<K;i++) {
            StringTokenizer command =new StringTokenizer(br.readLine());
            switch (command.nextToken()) {
                case "push":
                    int tmp =Integer.parseInt(command.nextToken());
                    lastPut=tmp;
                    q.add(tmp);

                    break;
                case "pop":
                    if (q.isEmpty()) {
                        sb.append(-1+"\n");
                    } else {
                        sb.append(q.remove()+"\n");
                    }
                    break;

                case "size":
                    sb.append(q.size()+"\n");
                    break;
                case "empty":
                    if (q.isEmpty()) {
                        sb.append(1+"\n");
                    } else {
                        sb.append(0+"\n");
                    }
                    break;
                case "front":
                    if (q.isEmpty()) {
                        sb.append(-1+"\n");

                    } else {
                        sb.append(q.peek()+"\n");

                    }
                    break;
                case "back":
                    if (q.isEmpty()) {
                        sb.append(-1+"\n");

                    } else {
                        sb.append(lastPut+"\n");

                    }
                    break;
            }
        }

        System.out.println(sb);

    }


}
