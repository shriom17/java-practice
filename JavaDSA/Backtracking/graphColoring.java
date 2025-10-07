class Solution {
    boolean graphColoring(int v, int[][] edges, int m) {
        // Build adjacency matrix
        int[][] adj = new int[v][v];
        for (int[] e : edges) {
            int u = e[0];
            int w = e[1];
            adj[u][w] = 1;
            adj[w][u] = 1; // undirected
        }

        int[] color = new int[v];
        return solve(0, adj, color, m, v);
    }

    private boolean solve(int node, int[][] adj, int[] color, int m, int v) {
        if (node == v) {
            return true; // all vertices colored
        }

        for (int c = 1; c <= m; c++) {
            if (isSafe(node, adj, color, v, c)) {
                color[node] = c;
                if (solve(node + 1, adj, color, m, v)) {
                    return true;
                }
                color[node] = 0; // backtrack
            }
        }
        return false;
    }

    private boolean isSafe(int node, int[][] adj, int[] color, int v, int c) {
        for (int i = 0; i < v; i++) {
            if (adj[node][i] == 1 && color[i] == c) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Solution solver = new Solution();
        int v = 4;
        int[][] edges = { {0, 1}, {1, 2}, {2, 3}, {3, 0}, {0, 2} };
        int m = 3; // number of colors

        if (solver.graphColoring(v, edges, m)) {
            System.out.println("Graph can be colored with " + m + " colors.");
        } else {
            System.out.println("Graph cannot be colored with " + m + " colors.");
        }
    }
}
