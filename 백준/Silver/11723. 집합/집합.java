import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int bit = 0;
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if(command.equals("all")) bit = (1 << 21) - 1;
            else if(command.equals("empty")) bit = 0;
            else {
                int num = Integer.parseInt(st.nextToken());
                if(command.equals("add"))
                    bit |= (1 << num);
                else if(command.equals("remove"))
                    bit &= ~(1 << num);
                else if(command.equals("check"))
                    sb.append((bit & (1 << num)) != 0 ? 1 : 0).append("\n");
                else if(command.equals("toggle"))
                    bit ^= (1 << num);
            }
        }
        System.out.println(sb);
    }
}