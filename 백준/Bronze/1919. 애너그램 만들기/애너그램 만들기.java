import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String first = br.readLine();
        String second = br.readLine();

        int[] fc = new int[26];
        int[] sc = new int[26];

        for(int i=0;i<first.length();i++){
            int p =first.charAt(i)-97;
            fc[p]++;
        }
        for(int i=0;i<second.length();i++){
            int p =second.charAt(i)-97;
            sc[p]++;
        }

        int cnt=0;
        for(int i=0;i<26;i++){
            cnt+=Math.abs(fc[i]-sc[i]);
        }
        System.out.println(cnt);
    }
}