import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int x = sc.nextInt();

        int checkSumArr[] = new int[x+1];
        int count=0;
        for(int t : arr){
            if(t>x){
                continue;
            }
            if(checkSumArr[x-t]==1){
                count+=1;
            }
            checkSumArr[t]+=1;
        }
        System.out.println(count);
    }
}
