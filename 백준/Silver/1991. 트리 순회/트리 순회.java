import java.util.*;
import java.io.*;

class Node{
    Character num;
    Node left;
    Node right;
    public Node(Character num){
        this.num=num;
        this.left=null;
        this.right=null;
    }

}
public class Main {
    static int N;
    static Node[] tree;
    public static void preorder(Node node) {
        if (node == null) return;
        System.out.print(node.num);
        preorder(node.left);
        preorder(node.right);
    }
    public static void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.num);
        inorder(node.right);
    }

    public static void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.num);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N =Integer.parseInt(br.readLine());
        tree = new Node[N];
        StringTokenizer st;
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            char num = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            if (tree[num - 'A'] == null) {
                tree[num - 'A'] = new Node(num);
            }
            if (left != '.') {
                tree[left - 'A'] = new Node(left);
                tree[num - 'A'].left = tree[left - 'A'];
            }
            if (right != '.') {
                tree[right - 'A'] = new Node(right);
                tree[num - 'A'].right = tree[right - 'A'];
            }
        }

        preorder(tree[0]);
        System.out.println();

        inorder(tree[0]);
        System.out.println();

        postorder(tree[0]);
        System.out.println();
    }
}