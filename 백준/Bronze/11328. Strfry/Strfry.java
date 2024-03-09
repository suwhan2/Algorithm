import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            String a = sc.next();
            String b = sc.next();
            int arr1[] = new int[26];
            int arr2[]=new int[26];

            for(char x : a.toCharArray()){
                arr1[(int)x-'a']+=1;
            }
            String a2 = Arrays.toString(arr1);

            for(char x : b.toCharArray()){
                arr2[(int)x-'a']+=1;
            }
            String b2 = Arrays.toString(arr2);

            if(a2.equals(b2)){
                System.out.println("Possible");
            }else{
                System.out.println("Impossible");
            }
        }

    }
}
