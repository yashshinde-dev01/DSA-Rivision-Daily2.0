class Solution {
    public int orangesRotting(int[][] grid) {
         Queue<int[]> que = new LinkedList<>();
        int m, n;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
         m = grid.length;
        n = grid[0].length;
        int time=0;
        int fresh=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    que.add(new int[]{i,j});
                }
                else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
         if (fresh == 0) return 0;
        while (!que.isEmpty()) {
            boolean spred=false;
            int size=que.size();
            for(int k=0;k<size;k++){
            int[] cell = que.poll();
            int i = cell[0];
            int j = cell[1];
            
            for (int[] dir : directions) {
                
                int new_i = i + dir[0];
                int new_j = j + dir[1];
                
                if(new_i >= 0 && new_i < m && new_j >= 0 && new_j < n && grid[new_i][new_j] == 1) {
                    grid[new_i][new_j]=2;
                    fresh--;
                    que.add(new int[] {new_i, new_j});
                    spred=true;
                }
            }
            }
            if(spred){
                time++;
            }
        } 
        if(fresh>0){
            return -1;
        }
        return time;
    }
}