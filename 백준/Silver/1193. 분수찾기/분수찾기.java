import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int mol,den;

        int target = Integer.parseInt(br.readLine());
        int sum = 1;
        int n =2;

        if(target==1){
            System.out.println("1/1");
            System.exit(0);
        }
        while(sum+n<target){
            sum+=n;
            n++;
        }


        if(n%2==1){
            den = target-sum;
            mol = (n+1)-den;
        }else {
           mol = target-sum;
           den = (n+1)-mol;
        }

        System.out.println(mol+"/"+den);

    }
}