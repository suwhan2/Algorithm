import java.util.*;
import java.io.*;

public class Main{
    static int N;
    public static void main(String[] args)throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        String[] ch = new String[N];

        int kbs1P=0;
        int kbs2P=0;
        for(int i=0;i<N;i++){
            String chName = br.readLine();
            ch[i]=chName;
            if(chName.equals("KBS1")){
                kbs1P=i;
            }
            if(chName.equals("KBS2")){
                kbs2P=i;
            }

        }

        if(kbs1P>kbs2P){
            for(int i=0;i<kbs1P;i++){
                sb.append("1");
            }
            for(int i=0;i<kbs1P;i++){
                sb.append("4");
            }
            for(int i=0;i<=kbs2P;i++){
                sb.append("1");
            }
            for(int i=0;i<kbs2P;i++){
                sb.append("4");
            }
        }else {
            for(int i=0;i<kbs1P;i++){
                sb.append("1");
            }
            for(int i=0;i<kbs1P;i++){
                sb.append("4");
            }
            for(int i=0;i<kbs2P;i++){
                sb.append("1");
            }
            for(int i=0;i<kbs2P-1;i++){
                sb.append("4");
            }
        }
        System.out.println(sb);

    }
}