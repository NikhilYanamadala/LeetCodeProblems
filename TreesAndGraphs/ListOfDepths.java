package TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ListOfDepths {
    private TreeNode root;
    class TreeNode{
        public int node;
        TreeNode right,left;
        public TreeNode(int data){
            this.node = data;
            right=null;
            left = null;
        }

    }
    public TreeNode createTreeFromArray(int[] array,TreeNode root,int i){

        if(i < array.length){
            TreeNode temp = new TreeNode(array[i]);
            root= temp;

            root.left = createTreeFromArray(array,root.left,(i*2)+1);
            root.right = createTreeFromArray(array,root.right,(i*2)+2);

        }

        return root;
    }
    public void preOrder(TreeNode node1){
        if (node1 == null) {
            return;
        }
        System.out.print(node1.node + "->");
        preOrder(node1.left);
        preOrder(node1.right);

    }
    public int depthOfATree(TreeNode root){
        if (root == null) {
            return 0;
        }
        int lDepth = depthOfATree(root.left);
        int rDepth = depthOfATree(root.right);
        if (lDepth > rDepth)
           return lDepth+1;
        else
            return rDepth+1;

    }
    public int depthOfTreeUsingIteration(TreeNode root){
        if (root == null){
            return 0;
        }
        int height=0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (true){
            int nodeCount = queue.size();
            if (nodeCount==0){
                return height;
            }
            height++;
            while (nodeCount > 0 ){
                TreeNode newNode = queue.poll();
                if (newNode.left!=null){
                    queue.add(newNode.left);
                }
                if (newNode.right!=null){
                    queue.add(newNode.right);
                }
                nodeCount--;
            }
        }
    }
    public ArrayList<LinkedList<Integer>> createLevelOrderLinkedList(TreeNode root){
        ArrayList<LinkedList<Integer>> lists = new ArrayList<>();
        createLevelOrderLinkedListUtil(root,lists,0);
        return lists;
    }
    public void createLevelOrderLinkedListUtil(TreeNode root,ArrayList<LinkedList<Integer>> lists,int level){
        if (root ==null){
            return;
        }
        LinkedList<Integer> ll =null;
        if (lists.size()==level){
            ll = new LinkedList<Integer>();
            lists.add(ll);
        }else {
            ll = lists.get(level);
        }
        ll.add(root.node);
        createLevelOrderLinkedListUtil(root.left,lists,level+1);
        createLevelOrderLinkedListUtil(root.right,lists,level+1);
    }
//    public List<LinkedList<Integer>> createListOfDepths(TreeNode root){
//
//
//    }
    public static void main(String[] args) {
        ListOfDepths listOfDepths =  new ListOfDepths();
        int[] array = {5,3,7,2,8};
        TreeNode node = listOfDepths.createTreeFromArray(array,listOfDepths.root,0);
        listOfDepths.preOrder(node);
        System.out.println(listOfDepths.depthOfTreeUsingIteration(node));
//        for (LinkedList l:listOfDepths.createLevelOrderLinkedList(node)) {
//            System.out.println(l);
//        }
    }
}
