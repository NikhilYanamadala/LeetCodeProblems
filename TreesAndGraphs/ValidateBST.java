package TreesAndGraphs;

import java.util.ArrayList;

public class ValidateBST {
    private TreeNode root;
    private ArrayList<Integer> list = new ArrayList<>();
    private int index = 0;
    private Integer last_printed = null;

    class TreeNode {
        public int node;
        TreeNode right, left;

        public TreeNode(int data) {
            this.node = data;
            right = null;
            left = null;
        }
    }

    public void createATree() {
        /*root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(8);
        root.left.left.left = new TreeNode(7);
        root.right.right= new TreeNode(9);*/
        root = new TreeNode(5);
        root.left = new TreeNode(0);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
//        root.right.right= new TreeNode(9);

    }

    public void preOrder(TreeNode node1) {
        if (node1 == null) {
            return;
        }
        System.out.print(node1.node + "->");
        preOrder(node1.left);
        preOrder(node1.right);

    }

    public int getSize(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        return getSize(treeNode.left) + 1 + getSize(treeNode.right);
    }

    public void inOrder(TreeNode treeNode, int[] arr) {
        if (treeNode == null) {
            return;
        }
        inOrder(treeNode.left, arr);
        arr[index] = treeNode.node;
        index++;
        inOrder(treeNode.right, arr);
    }

    //  Approach 1
    public boolean isBST(TreeNode treeNode) {
        int size = getSize(root);
        int[] arr = new int[size];
        inOrder(root, arr);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    //  Approach 2
//    RT = O(N) ST=O(H)=O(log N)
    public boolean isBST2(TreeNode treeNode) {
        if (treeNode == null) {
            return true;
        }
        if(!isBST2(treeNode.left)){
            return false;
        }
        if(last_printed!=null && treeNode.node <= last_printed){
            return false;
        }
        last_printed = treeNode.node;
        if(!isBST2(treeNode.right)){
            return false;
        }
       return true;
    }
//    Approach 3
    public boolean isBST3(TreeNode treeNode,Integer min,Integer max){
        if (treeNode==null){
            return true;
        }
        if((min !=null && treeNode.node <=min) || (max !=null && treeNode.node > max)){
            return false;
        }
        if(!isBST3(treeNode.left,min,treeNode.node) || (!isBST3(treeNode.right,treeNode.node,max))){
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        ValidateBST validateBST = new ValidateBST();
        validateBST.createATree();
        System.out.println(validateBST.isBST3(validateBST.root,null,null));
    }
}
