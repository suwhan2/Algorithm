import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int ans=input.length();
        int cnt=0;
        for(int i=0;i<input.length();i++){
            char tmp = input.charAt(i);
            if(tmp=='-'){
                cnt++;
            }
            else if(tmp=='='){
                if(i>=2 && input.charAt(i-1)=='z' && input.charAt(i-2)=='d'){
                    cnt+=2;
                }else{
                    cnt++;
                }
            }
            else if(tmp=='l'){
                if(i<input.length()-1&&input.charAt(i+1)=='j'){
                    cnt++;
                }
            }
            else if (tmp=='n') {
                if(i<input.length()-1&&input.charAt(i+1)=='j'){
                    cnt++;
                }
            }
//            System.out.println(cnt);
        }
        System.out.println(ans-cnt);
    }
}