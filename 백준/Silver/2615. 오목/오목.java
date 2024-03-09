
import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
	
	public static boolean checkBoundary(int x,int y,int n){
		return 0<=x && x<n && 0<=y && y<n;
	}
	
	public static void main(String[] args) throws Exception {
		Scanner sc= new Scanner(System.in);
		int arr[][]= new int[19][19];
		//입력부
		for(int i=0;i<19;i++) {
			for(int j=0;j<19;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		// 검사할 4가지 방향 배열에 정의
		int xCheck[] = new int[] {0,1,-1,1};
		int yCheck[] = new int[] {1,1,1,0};
		
		for(int i=0;i<19;i++) {
			for(int j=0;j<19;j++) {
				if(arr[i][j]==0) {
					continue;
				}
				
				for(int k=0;k<4;k++) {  //체크할 4가지 방향
					for(int l=1;l<=5;l++) { //6번째까지 확인
						//6번째 확인인지 
						if(l!=5) { 
							//격자 밖으로 나가는지 검사 
							if(!checkBoundary(i+(xCheck[k]*l),j+(yCheck[k]*l), 19)) {
								break;
							}
							//숫자가 같은지 검사
							if(arr[i][j]!=arr[i+(xCheck[k]*l)][j+(yCheck[k]*l)]) {
								break;
							}	
						}
						//마지막 여섯째짜리까지 숫자가 같다면 무효
						else { 
							if(!checkBoundary(i-xCheck[k],j-yCheck[k], 19) || arr[i][j]!=arr[i-xCheck[k]][j-yCheck[k]]) {
								if(!checkBoundary(i+(xCheck[k]*5),j+(yCheck[k]*5), 19) || arr[i][j]!=arr[i+(xCheck[k]*5)][j+(yCheck[k]*5)]) {
									
									System.out.println(arr[i][j]);
									System.out.println((i+1)+" "+(j+1));
									System.exit(0);
								}
							}
							
						}
					}	
				}
			}
		}
		System.out.println(0);
	}
}

