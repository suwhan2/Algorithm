import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//입력부
		int numberOfSwitchs = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int switches[]=new int[numberOfSwitchs];
		for(int i=0;i<numberOfSwitchs;i++) {
			switches[i]=Integer.parseInt(st.nextToken());
		}
		
		int numberOfStudents = Integer.parseInt(br.readLine());
		for(int i=0;i<numberOfStudents;i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine()," ");
			int s = Integer.parseInt(st2.nextToken());
			int receviedNum = Integer.parseInt(st2.nextToken());
			
			//구현부
			if(s==1) {
				for(int j =0;j<numberOfSwitchs;j++) {
					if((j+1)%receviedNum==0) {
						switches[j]=Math.abs(switches[j]-1);
					}
				}
				
			}else {
				switches[receviedNum-1]=Math.abs(switches[receviedNum-1]-1);
				int f=1;
				while(true) {
					if(receviedNum-1-f<0 || receviedNum-1+f>=numberOfSwitchs) {
						break;
					}
					if(switches[receviedNum-1-f]!=switches[receviedNum-1+f]) {
						break;
					}
					if(switches[receviedNum-1-f]==switches[receviedNum-1+f]) {
						switches[receviedNum-1-f]=Math.abs(switches[receviedNum-1-f]-1);
						switches[receviedNum-1+f]=Math.abs(switches[receviedNum-1+f]-1);
						f++;
					}
					
				}
			}
			
			
		}
		
		//출력부
		int count=0;
		for(int i=0;i<numberOfSwitchs;i++) {
			if(count!=0&&count%20==0) {
				System.out.println();
				System.out.print(switches[i]+" ");
				count++;
			}else {
				System.out.print(switches[i]+" ");
				count++;
			}
			
		}
		
		
	}
}
