class Solution {
    int ans = Integer.MAX_VALUE;

    public int minScore(int n, int[][] roads) {
        ArrayList<int[]>[] adj = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++)
            adj[i] = new ArrayList<>();

        for (int[] r : roads) {
            adj[r[0]].add(new int[]{r[1], r[2]});
            adj[r[1]].add(new int[]{r[0], r[2]});
        }

        boolean[] vis = new boolean[n + 1];
        dfs(1, adj, vis);

        return ans;
    }

    private void dfs(int node, ArrayList<int[]>[] adj, boolean[] vis) {
        vis[node] = true;

        for (int[] nei : adj[node]) {
            int next = nei[0];
            int wt = nei[1];

            ans = Math.min(ans, wt);

            if (!vis[next])
                dfs(next, adj, vis);
        }
    }
}