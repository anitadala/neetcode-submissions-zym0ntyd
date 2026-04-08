class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false; // necessary condition

        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        for (int[] e : edges) {
            int a = find(parent, e[0]);
            int b = find(parent, e[1]);
            if (a == b) return false; // cycle
            parent[a] = b; // union
        }
        return true; // with edges == n-1 and no cycles, graph is connected
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x) parent[x] = find(parent, parent[x]);
        return parent[x];
    }
}
