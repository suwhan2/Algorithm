import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int N =sc.nextInt();
        int K = sc.nextInt();
        int p=K-1;
        List<Integer> ll = new LinkedList<>();
        System.out.print("<");
        for(int i=1;i<=N;i++){
            ll.add(i);
        }

        for(int i=0;i<N-1;i++){
            if(ll.size()<K){
                int t = K%ll.size()-1;
                if(t<0){
                    t=ll.size()-1;
                }
                System.out.print(ll.get(t)+", ");
                ll.remove(t);

                for(int j=0;j<t;j++){
                    ll.add(ll.get(0));
                    ll.remove(0);
                }
            }else{
                System.out.print(ll.get(p)+", ");
                ll.remove(p);

                for(int j=0;j<p;j++){
                    ll.add(ll.get(0));
                    ll.remove(0);
                }
            }
        }
        System.out.print(ll.get(0)+">");

    }
}

