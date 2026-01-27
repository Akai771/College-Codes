package Practical11;
import java.util.Scanner;

public class AdjacencyMatrix {
    private int[][] adjMatrix; // Adjacency matrix to represent the graph
    private int V; // Number of vertices

    // Constructor to initialize graph with V vertices
    public AdjacencyMatrix(int V) {
        this.V = V;
        adjMatrix = new int[V][V]; // Initialize the adjacency matrix with all 0s
    }

    // Method to add an edge to the graph
    public void addEdge(int u, int v) {
        // For an undirected graph, set both adjMatrix[u][v] and adjMatrix[v][u] to 1
        adjMatrix[u][v] = 1;
        adjMatrix[v][u] = 1; // Since it's undirected
    }

    // Method to print the adjacency matrix
    public void printGraph() {
        System.out.println("Adjacency Matrix Representation of the Graph:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Main method to test the implementation
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Input: Number of vertices and edges
        System.out.print("Enter number of vertices (V): ");
        int V = sc.nextInt();
        AdjacencyMatrix graph = new AdjacencyMatrix(V); // Create a graph with V vertices
        System.out.print("Enter number of edges (E): ");

        int E = sc.nextInt();
        System.out.println("Enter the edges (u v) where u and v are vertices (0 to " + (V - 1) + "):");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.addEdge(u, v);
        }

        // Print the adjacency matrix representation of the graph
        graph.printGraph();
        sc.close();
    }
}