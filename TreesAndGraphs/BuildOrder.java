package TreesAndGraphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class BuildOrder {
    private int V;
    private LinkedList<Integer>[] adj;
    public Stack<Integer> stack ;

    public Stack<Integer> DFS(LinkedList<Integer>[] adj,int v){
        this.adj = adj;
        this.V = v;
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for (int i=0;i < v;i++) {
            if(!visited[i]) {
                DFSUtil(i, visited, stack);
            }
        }
        return stack;
    }
    public void DFSUtil(int startnode,boolean[] visited,Stack<Integer> stack){
        visited[startnode] =true;
        Iterator<Integer> i = adj[startnode].listIterator();
        while (i.hasNext()){
            int node = i.next();
            if (!visited[node]){
                DFSUtil(node,visited,stack);
            }
        }
        stack.push(startnode);
    }

    public static void main(String[] args) {
        Graph graph1 = new Graph(6);
        graph1.addEdgeForDirectedGraph(0,3);
        graph1.addEdgeForDirectedGraph(3,1);
        graph1.addEdgeForDirectedGraph(3,2);
        graph1.addEdgeForDirectedGraph(4,0);
        graph1.addEdgeForDirectedGraph(5,0);
        graph1.addEdgeForDirectedGraph(5,4);
        graph1.addEdgeForDirectedGraph(5,1);
        System.out.println("Stack="+new BuildOrder().DFS(graph1.adj,graph1.V));

    }
}
