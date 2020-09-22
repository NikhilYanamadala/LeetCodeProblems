package TreesAndGraphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
    public int V;
    public LinkedList<Integer>[] adj;

    public Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }

    }

    public void addEdgeForDirectedGraph(int u, int w) {
        adj[u].add(w);
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);

    }

    public void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.println(v + " ");
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n]) {
                DFSUtil(n, visited);
            }
        }

    }

    public void DFS(int v) {
        boolean visited[] = new boolean[V];
        DFSUtil(v, visited);

    }
    public void BFSUtil(int v , boolean[] visited){
        LinkedList<Integer> queue = new LinkedList<>();
        visited[v] = true;
        queue.add(v);

        while (queue.size() >0){
            int node = queue.poll();
            System.out.println(node+" ");
            Iterator<Integer> i = adj[node].listIterator();

            while (i.hasNext()){
                int n = i.next();
                if(!visited[n]){
                    visited[n]=true;
                    queue.add(n);
                }
            }
        }
    }
    public void BFS(int v){
        boolean visited[] = new boolean[V];
        BFSUtil(v,visited);
    }
    public static void printGraph(ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            System.out.println("\nAdjacency list of vertex" + i);
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(" -> " + adj.get(i).get(j));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int v = 4;
//        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(v);
//        for (int i = 0; i < v; i++)
//            adj.add(new ArrayList<Integer>());
//
//        // Adding edges one by one
//        addEdge(adj, 0, 1);
//        addEdge(adj, 0, 4);
//        addEdge(adj, 1, 2);
//        addEdge(adj, 1, 3);
//        addEdge(adj, 1, 4);
//        addEdge(adj, 2, 3);
//        addEdge(adj, 3, 4);
//        printGraph(adj);
        Graph graph = new Graph(v);
        graph.addEdgeForDirectedGraph(0, 1);
        graph.addEdgeForDirectedGraph(0, 2);
        graph.addEdgeForDirectedGraph(1, 2);
        graph.addEdgeForDirectedGraph(1, 3);
        graph.addEdgeForDirectedGraph(2, 0);
        graph.addEdgeForDirectedGraph(3, 3);
        System.out.println("Following is Depth First Traversal " + "(starting from vertex 2)");
//        graph.DFS(2);
        graph.BFS(2);
    }
}
