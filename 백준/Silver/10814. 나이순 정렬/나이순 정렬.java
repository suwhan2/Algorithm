import java.util.*;
import java.io.*;

class Member{
	int age;
	String name;

	public Member(int age,String name){
		this.age=age;
		this.name=name;	
	}
}
public class Main{
	static int N;
	public static void main(String[] args)throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		Member[] memberList = new Member[N];
		StringTokenizer st;
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			memberList[i] = new Member(Integer.parseInt(st.nextToken()),st.nextToken());
		}

		Arrays.sort(memberList, new Comparator<Member>(){
			@Override
			public int compare(Member s1, Member s2){
				return s1.age-s2.age;
			}
		});		
		StringBuilder sb= new StringBuilder();
		for(Member m : memberList){
			sb.append(m.age).append(" ").append(m.name).append("\n");
		}
		System.out.println(sb);
	}
}