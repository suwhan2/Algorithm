import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numOfPictureFrame = Integer.parseInt(br.readLine());
		int numOfRecommand = Integer.parseInt(br.readLine());
		StringTokenizer recommand = new StringTokenizer(br.readLine());
		List<Integer> ll = new LinkedList<>();
		int arr[] = new int[101];
	
		for(int i=0;i<numOfRecommand;i++) {
			int tmp = Integer.parseInt(recommand.nextToken());
			
			if(ll.size()==numOfPictureFrame) {
				if(arr[tmp]>0) {
					arr[tmp]++;
				}
				else {
					int minNum=numOfRecommand+1;
					for(Integer x : ll) {
						if(arr[x]<minNum) {
							minNum=arr[x];
						}
					}
					for(int j=0;j<ll.size();j++) {
						if(arr[ll.get(j)]==minNum) {
							arr[ll.get(j)]=0;
							ll.remove(j);
							break;
						}
					}
					ll.add(tmp);
					arr[tmp]++;
				}
				
			}else {
				if(arr[tmp]>0) {
					arr[tmp]++;
				}else {
					ll.add(tmp);
					arr[tmp]++;
				}
			}

		}
		
		Collections.sort(ll);
		for(Integer x : ll) {
			System.out.print(x+" ");
		}
				
		
		
	}
    
}
