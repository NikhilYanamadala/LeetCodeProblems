package TreesAndGraphs;

public class CheckBalanced {
    public TreeNode root;

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
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(7);
//        root.right.right= new TreeNode(9);

    }
    public void preOrder(TreeNode node1){
        if (node1 == null) {
            return;
        }
        System.out.print(node1.node + "->");
        preOrder(node1.left);
        preOrder(node1.right);

    }
//    runtime = O(N logN) because each node touch once per above it
    public boolean isBalanced(TreeNode root) {
        /*if (root == null) {
            return true;
        }
        int heightDiff = getHeight(root.left) - getHeight(root.right);
        if (Math.abs(heightDiff) > 1) {
            return false;
        } else {
            return isBalanced(root.left) && isBalanced(root.right);
        }*/
        return checkHeight(root) != Integer.MIN_VALUE;

    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
//    RT = O(N) sp = O(H) H = height of a tree
    public int checkHeight(TreeNode node){
        if (node == null){
            return -1;
        }
        int leftHeight=checkHeight(node.left);
        if(leftHeight ==Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        int rightHeight=checkHeight(node.right);
        if(rightHeight ==Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        int heightDiff = leftHeight-rightHeight;
        if(Math.abs(heightDiff) >1){
            return Integer.MIN_VALUE;
        }else {
            return Math.max(leftHeight,rightHeight)+1;
        }
    }
    public static void main(String[] args) {
        CheckBalanced checkBalanced = new CheckBalanced();
        checkBalanced.createATree();
        checkBalanced.preOrder(checkBalanced.root);
        System.out.println(checkBalanced.isBalanced(checkBalanced.root));
    }

}
