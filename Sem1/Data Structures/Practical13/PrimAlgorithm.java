package Practical13;
import java.util.*;

public class PrimAlgorithm {
    // Prim's algorithm to find MST
    public static void primMST(int V, List<List<int[]>> adj) {
        boolean[] visited = new boolean[V];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1])); // Min-heap based on weight

        // Start from the first vertex (vertex 0)
        pq.add(new int[] { 0, 0 }); // {vertex, weight}

        int mstWeight = 0;
        List<String> mstEdges = new ArrayList<>();
        int[] parent = new int[V];
        Arrays.fill(parent, -1);

        while (!pq.isEmpty()) {
            int[] edge = pq.poll();
            int u = edge[0];
            int weight = edge[1];

            // If this vertex has already been visited, skip it
            if (visited[u])
                continue;

            visited[u] = true;
            mstWeight += weight;

            // Add the edge to MST (skip the starting vertex 0)
            if (weight > 0) {
                mstEdges.add((char) (parent[u] + 65) + " - " + (char) (u + 65) + " with weight " + weight);
            }

            // Add all the neighbors to the priority queue
            for (int[] neighbor : adj.get(u)) {
                int v = neighbor[0];
                int w = neighbor[1];
                if (!visited[v]) {
                    parent[v] = u;
                    pq.add(new int[] { v, w });
                }
            }
        }

        // Print the MST
        System.out.println("Edges in MST:");
        for (String edge : mstEdges) {
            System.out.println(edge);
        }
        System.out.println("Total weight of MST: " + mstWeight);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices (V): ");
        int V = sc.nextInt();

        System.out.print("Enter number of edges (E): ");
        int E = sc.nextInt();

        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        System.out.println("Enter edges (u v weight):");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int weight = sc.nextInt();
            
            adj.get(u).add(new int[] { v, weight });
            adj.get(v).add(new int[] { u, weight });
        }
        // Run Prim's algorithm
        primMST(V, adj);
        sc.close();
    }
}