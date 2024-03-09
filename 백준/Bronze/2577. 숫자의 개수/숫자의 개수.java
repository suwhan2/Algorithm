import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        int countNum[] = new int[10];

        String mulNum=A*B*C+"";
        for(int i=0;i<mulNum.length();i++){
            countNum[mulNum.charAt(i)-'0']+=1;
        }

        for(int x : countNum){
            System.out.println(x);
        }
    }
}
