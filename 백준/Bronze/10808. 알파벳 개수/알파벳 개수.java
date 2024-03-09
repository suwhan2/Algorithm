import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strInput = sc.next();
        int alphabet[] = new int[26];

        for(int i=0;i<strInput.length();i++){
            alphabet[(int)(strInput.charAt(i)-'a')]+=1;
        }

        for(int x : alphabet){
            System.out.print(x+" ");
        }
    }
}
