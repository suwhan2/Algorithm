import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> inputList= new ArrayList<>();
        int[] cnt = new int[4000*2+1];
        int sum=0;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int maxCnt = 0 ;
        for(int i=0;i<n;i++){
            int input= Integer.parseInt(br.readLine());
            sum+=input;

            min = Math.min(min,input);
            max = Math.max(max,input);

            inputList.add(input);
            cnt[input+4000]++;
            maxCnt = Math.max(maxCnt,cnt[input+4000]);
        }
        Collections.sort(inputList);

        List<Integer> cntList = new ArrayList<>();

        for(int i=0;i<cnt.length;i++){
            if(cnt[i]==maxCnt){
                cntList.add(i-4000);
            }
        }

        Collections.sort(cntList);

        System.out.println(Math.round((float)sum/n));
        System.out.println(inputList.get(n/2));
        if(cntList.size()==1){
            System.out.println(cntList.get(0));
        }else System.out.println(cntList.get(1));
        System.out.println(max-min);

    }
}