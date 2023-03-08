package Binary_Tree;

public class Subtree_of_Another_Tree {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static boolean isIndentical(Node root, Node subroot){
        if(root == null && subroot==null){
            return true;
        }else if(root == null || subroot==null || root.data != subroot.data){
            return false;
        }
        if(!isIndentical(root.left,subroot.left)){
            return false;
        }
        if(!isIndentical(root.right, subroot.right)){
            return false;
        }
        return true;
    }
    public static boolean subtree(Node root, Node subroot){
        if(root == null){
            return false;
        }
        if(root.data == subroot.data){
            if(isIndentical(root,subroot)){
                return true;
            }
        }
        boolean leftans = subtree(root.left, subroot);
        boolean rightans = subtree(root.right,subroot);
        return leftans || rightans;
    }
    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        Node subroot = new Node(2);
        subroot.left = new Node(4);
        subroot.right = new Node(5);

        System.out.println(subtree(root,subroot));
    }
}
