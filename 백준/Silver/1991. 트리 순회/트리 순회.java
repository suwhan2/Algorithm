import java.io.*;
import java.util.*;

class TreeNode{
    char value;
    TreeNode left;
    TreeNode right;
    public TreeNode(char value){
        this.value=value;
    }
}

class BTree{
    public TreeNode root;
    public void addNode(char value,char left,char right){
        if(root==null){
            root = new TreeNode(value);
        }
        TreeNode t = findNode(value,root);
        if(left !='.'){
            t.left = new TreeNode(left);
        }
        if(right !='.'){
            t.right = new TreeNode(right);
        }
    }
    public TreeNode findNode(char value,TreeNode node){
        if(node==null){
            return null;
        }
        if(node.value ==value){
            return node;
        }
        TreeNode left = findNode(value,node.left);
        if(left!=null){
            return left;
        }
        TreeNode right = findNode(value,node.right);
        if(right!=null){
            return right;
        }
        return null;

    }

    public void preTravel(TreeNode node){
        if(node==null){
            return;
        }
        System.out.print(node.value);
        preTravel(node.left);
        preTravel(node.right);
    }
    public void inorderTravel(TreeNode node){
        if(node==null){
            return;
        }
        inorderTravel(node.left);
        System.out.print(node.value);
        inorderTravel(node.right);
    }

    public void postTravel(TreeNode node){
        if(node==null){
            return;
        }
        postTravel(node.left);
        postTravel(node.right);
        System.out.print(node.value);
    }
}

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        BTree tree = new BTree();
        for(int i=0;i<N;i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            tree.addNode(st.nextToken().charAt(0),st.nextToken().charAt(0),st.nextToken().charAt(0));

        }
        tree.preTravel(tree.root);
        System.out.println();
        tree.inorderTravel(tree.root);
        System.out.println();
        tree.postTravel(tree.root);
        System.out.println();

    }
}