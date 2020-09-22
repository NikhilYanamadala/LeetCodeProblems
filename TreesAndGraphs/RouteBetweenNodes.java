package TreesAndGraphs;

import java.util.Iterator;
import java.util.LinkedList;

public class RouteBetweenNodes {
    private int V;
    private LinkedList<Integer> adj[];

    public RouteBetweenNodes(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int w) {
        adj[u].add(w);
    }

    public boolean BFSUtil(int start, int end, boolean[] visited) {
        LinkedList<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        while (queue.size() > 0) {
            int node = queue.poll();
            System.out.println(node + " ");
            Iterator<Integer> i = adj[node].listIterator();
            while (i.hasNext()) {
                int nodeValue = i.next();

                if (!visited[nodeValue]) {
                    if (nodeValue == end) {
                        return true;
                    } else {
                        visited[nodeValue] = true;
                        queue.add(nodeValue);
                    }
                }
            }
        }
        return false;
    }

    public boolean BFS(int start, int end) {
        boolean[] visited = new boolean[V];
        return BFSUtil(start, end, visited);
    }

    public static void main(String[] args) {
        int v = 4;
        RouteBetweenNodes graph = new RouteBetweenNodes(v);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
//        graph.addEdge(1, 3);
        graph.addEdge(2, 0);
        graph.addEdge(3, 3);
        System.out.println(graph.BFS(0, 3));
    }
}
