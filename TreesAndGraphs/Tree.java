package TreesAndGraphs;

public class Tree {
    public Tree root;
    public int node;
    Tree parent,right, left;
    public Tree(){

    }
    public Tree(int data) {
        this.node = data;
        parent =null;
        right = null;
        left = null;
    }
    public Tree createATree() {
        /*root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(8);
        root.left.left.left = new TreeNode(7);
        root.right.right= new TreeNode(9);*/
        root = new Tree(5);
        root.left = new Tree(4);
        root.left.parent = root;
        root.right = new Tree(10);
        root.right.parent = root;
        root.left.left = new Tree(7);
        root.left.left.parent = root.left;
        root.left.right = new Tree(8);
        root.left.right.parent = root.left;
        root.right.left= new Tree(1);
        root.right.left.parent = root.right;
        root.right.right= new Tree(20);
        root.right.right.parent = root.right;
        return root;
    }
    public static void main(String[] args) {

    }
}
