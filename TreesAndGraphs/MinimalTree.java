package TreesAndGraphs;

public class MinimalTree {
    class TreeNode{
        public int data;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int d){
            data = d;
            left = null;
            right = null;
        }

    }
    public TreeNode createMinimalBinartTree(int[] array,int start,int end){
        if (end < start){
            return null;
        }
        int n = (start+end)/2;
        TreeNode node = new TreeNode(array[n]);
        node.left = createMinimalBinartTree(array,start,n-1);
        node.right = createMinimalBinartTree(array,n+1,end);
        return node;
    }
    public void preOrder(TreeNode node){
        if (node == null) {
            return;
        }
        System.out.print(node.data + "->");
        preOrder(node.left);
        preOrder(node.right);

    }
    public static void main(String[] args) {
        int[] array = {2,3,4,5,6,7,8,9};
        MinimalTree minimalTree = new MinimalTree();
        minimalTree.preOrder(minimalTree.createMinimalBinartTree(array,0,array.length-1));
    }
}
