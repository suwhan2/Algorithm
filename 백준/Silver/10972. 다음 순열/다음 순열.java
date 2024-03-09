import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();
		int [] input = new int[N];
		
		for(int i=0;i<N;i++) {
			input[i] = sc.nextInt();
		}
		//뽑는게 아니라 계속 자리 교체라서 순열저장배열 같은건 필요없다.
		//뽑는게 아니므로 다뽑는 경우의 순열만 가능하다
		
		// step 0 : 정렬(오름차순)
		
		if(np(input)) {
			for(int x : input) {
				System.out.print(x+" ");
			}
			System.out.println();
			
		}else {
			System.out.println(-1);
		}
		
		
	}
	//순열의 뒷쪽부터 작은 변화를 준다.
	public static boolean np(int[] p) {// 현순열의 사전순 다음 순열 생성(p:현 순열)
		final int N = p.length;
		//step1 : 교환위치 찾기(꼭대기를 찾으면 꼭대기 이전이 교환위치가 됨)
		int i = N-1;
		while(i>0 && p[i-1]>=p[i]) --i;
		
		if(i==0) return false; // 현순열의 상태가 가장 큰 순열이므로 np없다.
		
		//step2 : 교환위치(i-1)에 넣을 값 뒤쪽부터 찾기( 큰 값 중 최솟값)
		int j = N-1;
		while(p[i-1]>=p[j]) --j;
		
		//step3 : 교환위치(i-1) 값과 찾은 위치(j)값을 교환
		swap(p,i-1,j);
		
		//step4 : 꼭대기(i)위치부터 맨뒤까지 오름차순 정렬
		int k = N-1;
		while(i<k) swap(p,i++,k--);
		
		return true;
	
	}
	public static void swap(int[] arr,int i , int j) {
		int temp =arr[i];
		arr[i] = arr[j];
		arr[j]= temp;
		
	}
	
}