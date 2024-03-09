import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int ans=0;
		int arr[] = new int[N];
		for(int i=0;i<N;i++) {
			arr[i]=sc.nextInt();
		}
		int v=sc.nextInt();
		for(int x : arr) {
			if(x==v) {
				ans+=1;
			}
		}
		System.out.println(ans);
	}
}
