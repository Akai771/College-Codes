package Practical14;
import java.util.*;

public class DepthFirstSearch {
    private int V; // Number of vertices
    private int[][] adjMatrix; // Adjacency matrix
    // Constructor

    public DepthFirstSearch(int V) {
        this.V = V;
        adjMatrix = new int[V][V]; // Initialize the adjacency matrix
    }

    // Method to add an edge in an undirected graph
    public void addEdge(int u, int v) {
        adjMatrix[u][v] = 1;
        adjMatrix[v][u] = 1; // Since it's undirected, mirror the edge
    }

    // DFS Traversal
    public void dfs(int start) {
        boolean[] visited = new boolean[V];

        System.out.print("DFS Traversal: ");
        dfsUtil(start, visited);
        System.out.println();
    }

    // Utility function for DFS (recursive)
    private void dfsUtil(int node, boolean[] visited) {
        visited[node] = true;
        System.out.print((char) (node + 65) + " "); // Convert index to char (A, B, C, ...)
        // Visit all neighbors of the current node
        for (int i = 0; i < V; i++) {
            if (adjMatrix[node][i] == 1 && !visited[i]) {
                dfsUtil(i, visited);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Get number of vertices and edges from the user
        System.out.print("Enter the number of vertices: ");
        int V = sc.nextInt();
        DepthFirstSearch graph = new DepthFirstSearch(V); // Create a graph with V vertices
        System.out.print("Enter the number of edges: ");
        int E = sc.nextInt();
        // Get edges from the user
        System.out.println("Enter the edges (u v) where u and v are vertices (0 to " + (V - 1) + "):");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.addEdge(u, v);
        }

        // Get the start vertex for DFS
        System.out.print("Enter the start vertex for DFS (0 to " + (V - 1) + "): ");
        int start = sc.nextInt();

        // Perform DFS
        graph.dfs(start);
        sc.close();
    }
}