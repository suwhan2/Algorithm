import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(bf.readLine());
        Stack<Integer> stackInt = new Stack<>();
        StringBuilder ans = new StringBuilder();
        List<Integer> al = new ArrayList<>();

        for(int i=0;i<K;i++) {
            al.add(Integer.parseInt(bf.readLine()));
        }

        stackInt.push(1);
        ans.append("+");
        int num=1;
        int i=0;
        while(num<=K){
            if((!stackInt.empty())&& Objects.equals(stackInt.peek(), al.get(i))) {
            	stackInt.pop();
                ans.append("-");
                i++;
                if (i == K) {
                    num++;
                }
            }
            else {
                num++;
                stackInt.push(num);
                ans.append("+");

            }
        }

        if(!stackInt.isEmpty()) {
            System.out.println("NO");
        }
        else {
            for(int j=0;j<ans.length();j++) {
                System.out.println(ans.charAt(j));
            }

        }

    }
}

