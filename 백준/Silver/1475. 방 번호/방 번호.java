import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String roomNumber = sc.nextInt()+"";

        int countNum[] = new int[10];

        for(int i=0;i<roomNumber.length();i++){
                countNum[roomNumber.charAt(i)-'0']+=1;
        }

        int ans = countNum[6]+countNum[9];
        if(ans%2==1){
            ans =( ans+1)/2;
        }else {
            ans/=2;
        }
        countNum[6]=ans;
        countNum[9]=ans;

        int mostNum=0;
        for(int x : countNum){
            if(x>mostNum){
                mostNum=x;
            }
        }

        System.out.println(mostNum);


    }
}

