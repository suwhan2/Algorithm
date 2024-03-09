import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        //테스트 케이스 개수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {

            Stack<String> left = new Stack<String>();
            Stack<String> right = new Stack<String>();

            //입력부
            String strInput = br.readLine();
            //구현부
            for (char c : strInput.toCharArray()) {

                switch (c) {
                    case '<':
                        if (!left.isEmpty()) right.push(left.pop());
                        break;
                    case '>':
                        if (!right.isEmpty()) left.push(right.pop());
                        break;
                    case '-':
                        if (!left.isEmpty()) left.pop();
                        break;
                    default:
                        left.push(String.valueOf(c));
                        break;
                }
            }
            while (!left.isEmpty()) {
                right.push(left.pop());
            }
            StringBuilder sb = new StringBuilder();
            while (!right.isEmpty()) {
                sb.append(right.pop());
            }
            System.out.println(sb.toString());

        }
    }
}