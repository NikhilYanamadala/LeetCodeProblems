package TreesAndGraphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FirstCommonAncestor {
    public int[] array = new int[7];
    public int count = 0;

    public void BFS(Tree root) {
        LinkedList<Tree> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {
            Tree node = queue.poll();
            array[count] = node.node;
            count++;
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }

    }

    public int firstCommonAncestor(int a, int b) {
        int indexA = -1;
        int indexB = -1;
        int parentIndexofA = -1;
        int parentIndexofB = -1;
        while (true) {
            indexA = findIndex(a);
            indexB = findIndex(b);
            if (indexA == -1 || indexB == -1) {
                return -1;
            }
            if (!isFractional((indexA - 1) / 2)) {
                parentIndexofA = (indexA - 1) / 2;
            } else {
                parentIndexofA = (indexA - 2) / 2;
            }
            if (!isFractional((indexB - 1) / 2)) {
                parentIndexofB = (indexB - 1) / 2;
            } else {
                parentIndexofB = (indexB - 2) / 2;
            }
            if (array[parentIndexofA] == array[parentIndexofB]) {
                return array[parentIndexofA];
            } else {
                a = array[parentIndexofA];
                b = array[parentIndexofB];
            }
        }
    }

    public int findIndex(int num) {
        if (array == null) {
            return -1;
        }
        int len = array.length;
        int i = 0;
        while (i < len) {
            if (array[i] == num) {
                return i;
            } else {
                i = i + 1;
            }
        }
        return -1;
    }

    public boolean isFractional(float f) {
        int decimal = (int) f;
        float fractional = f - decimal;
        if (fractional > 0) {
            return true;
        }
        return false;
    }

    //    approach 2 With out Parent Links
    public Tree findFirstCommonAncestor(Tree root, int a, int b) {
        if (root == null) {
            return null;
        }
        if (!cover(root, a) || !cover(root, b)) {
            return null;
        }
        return ancestorHelper(root, a, b);
    }

    public Tree ancestorHelper(Tree root, int a, int b) {
        if (root == null || root.node == a || root.node == b) {
            return root;
        }
        boolean AIsOnLeft = cover(root.left, a);
        boolean BIsOnLeft = cover(root.left, b);
        if (AIsOnLeft != BIsOnLeft) {
            return root;
        }
        Tree childSide = AIsOnLeft ? root.left : root.right;
        return ancestorHelper(childSide, a, b);
    }

    public boolean cover(Tree node, int toFind) {
        if (node == null) {
            return false;
        }
        if (node.node == toFind) {
            return true;
        }
        return cover(node.left, toFind) || cover(node.right, toFind);

    }


    //    Approach 3 with Parent Links RT=O(d) d=depth of deeper node
    public Tree commonAncestor(Tree p, Tree q) {
        int delta = depth(p) - depth(q);
        Tree first = delta > 0 ? q : p;// get shallower node
        Tree second = delta > 0 ? p : q;// get deeper node
        second = goUp(second, Math.abs(delta));

        while (first != second && first != null && second != null) {
            first = first.parent;
            second = second.parent;
        }
        return first == null || second == null ? null : first;
    }

    public Tree goUp(Tree node, int delta) {
        while (delta > 0 && node != null) {
            node = node.parent;
            delta--;
        }
        return node;
    }

    public int depth(Tree node) {
        int depth = 0;
        while (node != null) {
            node = node.parent;
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        Tree root = tree.createATree();
        FirstCommonAncestor firstCommonAncestor = new FirstCommonAncestor();
//        firstCommonAncestor.BFS(root);
//        System.out.println(Arrays.toString(firstCommonAncestor.array));
//        System.out.println("Coommon Ancestor=" + firstCommonAncestor.firstCommonAncestor(11, 20));
//        System.out.println(firstCommonAncestor.findFirstCommonAncestor(root,4,8).node);
        System.out.println(firstCommonAncestor.commonAncestor(root.left.left, root.left.right).node);
    }
}
