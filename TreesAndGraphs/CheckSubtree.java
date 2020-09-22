package TreesAndGraphs;

public class CheckSubtree {
// approach1 RT= O(n+m) Sp = O(n+m) n,m no nodes in T1,T2
    public boolean containsTree(ListOfDepths.TreeNode t1,ListOfDepths.TreeNode t2){
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        getOrderString(t1,s1);
        getOrderString(t2,s2);
        return s1.indexOf(s2.toString()) !=-1;
    }

    public void getOrderString(ListOfDepths.TreeNode t,StringBuilder sb){
        if(t==null){
            sb.append('X');
            return;
        }
        sb.append(t.node);
        getOrderString(t.left,sb);
        getOrderString(t.right,sb);

    }
// Approach 2 RT= O(n+km) k= no occurrences of T2 root in T1 sp = O(logN+logM)
    public boolean contains(ListOfDepths.TreeNode T1,ListOfDepths.TreeNode T2){
        if(T2 == null){
            return true;
        }
        return subTree(T1,T2);

    }
    public boolean subTree(ListOfDepths.TreeNode T1,ListOfDepths.TreeNode T2){
        if(T1==null){
            return false;
        }else if((T1.node==T2.node) && matchTree(T1,T2)){
            return true;
        }
        return subTree(T1.left,T2) || subTree(T1.right,T2);
    }

    public boolean matchTree(ListOfDepths.TreeNode T1,ListOfDepths.TreeNode T2){
        if(T2 == null && T1== null){
            return true;
        }
        else if(T1==null || T2==null){
            return false;
        }else {
            return matchTree(T1.left,T2.left) && matchTree(T1.right,T2.right);
        }
    }
    public static void main(String[] args) {
        ListOfDepths listOfDepths =  new ListOfDepths();
        ListOfDepths.TreeNode root = null;
        int[] array1 = {1,2,3,4};
        int[] array2 = {2,4};
        ListOfDepths.TreeNode T1 = listOfDepths.createTreeFromArray(array1,root,0);
        ListOfDepths.TreeNode T2 = listOfDepths.createTreeFromArray(array2,root,0);
        CheckSubtree checkSubtree = new CheckSubtree();
//        System.out.println(checkSubtree.containsTree(T1,T2));
        System.out.println(checkSubtree.contains(T1,T2));
    }

}
