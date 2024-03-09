import java.io.*;
import java.util.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.spi.FileSystemProvider;
import java.util.StringTokenizer;


public class Main {
	
	static int N;
	static int S;
	static int arr[];
	static boolean visited[];
	static int count=0;
	
	private static void simulation(int cnt,int sum) {
		if(cnt==N) {
			boolean check =false;
			for(int i=0;i<N;i++) {
				if(visited[i]) {
					check=true;
					break;
				}
			}
			if(sum==S && check) {

				count++;
			}
			return;
		}
		
		visited[cnt]=true;
		simulation(cnt+1,sum+arr[cnt]);
		visited[cnt]=false;
		simulation(cnt+1,sum);

	}
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	S = Integer.parseInt(st.nextToken());
    	arr = new int[N];
    	visited = new boolean[N];
    	
    	StringTokenizer st2 = new StringTokenizer(br.readLine());
    	for(int i=0;i<N;i++) {
    		arr[i] = Integer.parseInt(st2.nextToken());
    	}
    	
    	
    	simulation(0,0);
    	System.out.println(count);

    }

}