class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();

        int[][] best = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(best[i], -1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b)->b[2]-a[2]
        );

        int start = health - grid.get(0).get(0);
        if(start <= 0) return false;

        pq.offer(new int[]{0,0,start});
        best[0][0] = start;

        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int x = curr[0];
            int y = curr[1];
            int h = curr[2];

            if(x == m-1 && y == n-1) return true;

            for(int k=0;k<4;k++){
                int nx = x + dx[k];
                int ny = y + dy[k];

                if(nx>=0 && ny>=0 && nx<m && ny<n){
                    int nh = h - grid.get(nx).get(ny);

                    if(nh > 0 && nh > best[nx][ny]){
                        best[nx][ny] = nh;
                        pq.offer(new int[]{nx, ny, nh});
                    }
                }
            }
        }

        return false;
    }
}