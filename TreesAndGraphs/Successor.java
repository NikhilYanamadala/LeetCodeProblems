package TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;

public class Successor {
    private TreeNode root;


    class TreeNode {
        public int node;
        TreeNode right, left,parent;

        public TreeNode(int data) {
            this.node = data;
            right = null;
            left = null;
            parent=null;
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
        root.left = new TreeNode(3);
        root.left.parent=root;
        root.right = new TreeNode(7);
        root.right.parent=root;
        root.left.left = new TreeNode(1);
        root.left.left.parent = root.left;
//        root.left.right = new TreeNode(4);
//        root.left.right.parent=root.left;
//        root.right.right= new TreeNode(9);

    }

    public void inOrder(TreeNode node1) {
        if (node1 == null) {
            return;
        }
        inOrder(node1.left);
        System.out.print(node1.node + "->");
        inOrder(node1.right);

    }
// approach 1 if node has parent link
    public TreeNode findSuccessor(TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        }
//        case 1 : if a node has right sub tree , return left most child of a right sub tree
        if(treeNode.right!= null){
            return leftMostChild(treeNode.right);
        }
//        case 2: if a tree has no right sub tree . return unvisited parent
        else {
            TreeNode q = treeNode;
            TreeNode x = q.parent;
            while (x!=null && x.left!=q){
                q = x;
                x = x.parent;
            }
            return x;
        }

    }
    public TreeNode leftMostChild(TreeNode treeNode){
        if(treeNode == null){
            return null;
        }
        while (treeNode.left!=null){
            treeNode = treeNode.left;
        }
        return treeNode;
    }
    // approach 2 if node doesn't has parent link
    public TreeNode findSuccessorUsingBST(TreeNode treeNode){
        if (treeNode == null){
            return null;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();

        while (root.node != treeNode.node ){
            queue.add(root);
            if(treeNode.node <= root.node){
                root = root.left;
            }else {
                root = root.right;
            }
        }
        if(root.right!=null){
            return leftMostChild(root.right);
        }else if(root.left!=null) {
            return queue.poll();
        }
        else {
            while (queue.size()!=1){
                queue.poll();
            }
            return queue.poll();
        }

    }
    public static void main(String[] args) {
        Successor successor = new Successor();
        successor.createATree();
//        successor.inOrder(successor.root);
        System.out.println(successor.findSuccessorUsingBST(successor.root.left.left).node);

    }
}
