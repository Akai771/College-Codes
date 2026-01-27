package Practical13;
import java.util.*;

public class KruskalAlgorithm {
    // Union-Find data structure
    static class UnionFind {
        int[] parent;
        int[] rank;

        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                // Union by rank
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }
    }

    static class Edge {
        int u, v, weight;

        Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }

    // Kruskal's algorithm to find MST
    public static void kruskalMST(int V, List<Edge> edges) {

        UnionFind uf = new UnionFind(V);

        // Sort edges by weight
        edges.sort(Comparator.comparingInt(e -> e.weight));
        List<Edge> mst = new ArrayList<>();
        int mstWeight = 0;
        // Process each edge in sorted order
        for (Edge edge : edges) {
            int u = edge.u;
            int v = edge.v;
            int weight = edge.weight;
            // If adding this edge doesn't form a cycle, include it in the MST
            if (uf.find(u) != uf.find(v)) {
                uf.union(u, v);
                mst.add(edge);
                mstWeight += weight;
            }
        }
        // Print the MST
        System.out.println("Edges in MST:");
        for (Edge edge : mst) {
            System.out.println((char) (edge.u + 65) + " - " + (char) (edge.v + 65) + " with weight " + edge.weight);
        }
        System.out.println("Total weight of MST: " + mstWeight);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices (V): ");

        int V = sc.nextInt();
        System.out.print("Enter number of edges (E): ");
        int E = sc.nextInt();

        List<Edge> edges = new ArrayList<>();
        System.out.println("Enter edges (u v weight):");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int weight = sc.nextInt();
            edges.add(new Edge(u, v, weight));
        }
        // Run Kruskal's algorithm
        kruskalMST(V, edges);
        sc.close();
    }
}