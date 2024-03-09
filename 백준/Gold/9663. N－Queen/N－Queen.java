import java.io.*;
import java.util.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class Main {
    static int N;
    static int count=0;
    static int grid[];
    
    private static void simulation(int cnt){
        if(cnt>N){
            count++;
            return;
        }
		for (int i = 1; i <= N; i++) { 
			grid[cnt] = i;
			if (checking(cnt)) { 
				simulation(cnt + 1); 
			}
		}

    }
    
    private static boolean checking(int currRow) {
		for (int i = 1; i < currRow; i++) {

			if(grid[currRow] == grid[i]) return false;
			if((currRow-i)==Math.abs(grid[currRow]-grid[i])) return false;
		}
		return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new int[N+1];


        simulation(1);

        System.out.println(count);
    }
}