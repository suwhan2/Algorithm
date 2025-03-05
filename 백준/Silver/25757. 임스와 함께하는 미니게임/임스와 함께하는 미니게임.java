import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        char game = st.nextToken().charAt(0);

        HashSet<String> friend = new HashSet<>();
        for(int i=0;i<n;i++){
            String name = br.readLine();
            friend.add(name);
        }

        int kind =0;
        if(game == 'Y') kind = 1;
        if(game == 'F') kind=2;
        if(game == 'O') kind = 3;

        int ans = friend.size() / kind;
        System.out.println(ans);
    }
}