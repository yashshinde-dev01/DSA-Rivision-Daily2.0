class Solution {
    class pair{
        int row;
        int col;
        pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    int[][]dire={{0,-1},{0,1},{1,0},{-1,0}};
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        int l=grid[0][0];
        int r=n*n-1;

        int res=0;

        while(l<=r){
            int mid=l+(r-l)/2;
            boolean[][]visi=new boolean[n][n];
            if(possibleReach(grid,0,0,mid,visi)){
                res=mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return res;
    }
    boolean possibleReach(int[][]grid,int i,int j,int t,boolean[][]visi){
        int n=grid.length;
        Queue<pair>que=new LinkedList<>();
        if(grid[i][j]>t)return false;
        que.offer(new pair(i,j));
        visi[i][j]=true;
        while(!que.isEmpty()){
            pair top=que.poll();

            int r=top.row;
            int c=top.col;
            if(r==n-1 && c==n-1)return true;
            for(int[]nebs:dire){
                int nr=r+nebs[0];
                int nc=c+nebs[1];

                if(nr<0 || nr>=n || nc<0 || nc>=n || visi[nr][nc]==true || grid[nr][nc]>t){
                    continue;
                }
                visi[nr][nc]=true;
                que.offer(new pair(nr,nc));
            }
            
        }
        return false;
        
        
    }
}

// int n=grid.length;
//         if(i<0 || i>=n || j<0 || j>=n || visi[i][j]==true || grid[i][j]>t){
//             return false;
//         }
//         visi[i][j]=true;

//         if(i==n-1 && j==n-1){
//             return true;
//         }
//         for(int[] dir:dire){
//             int ni=i+dir[0];
//             int nj=j+dir[1];

//             if(possibleReach(grid,ni,nj,t,visi)){
//                 return true;
//             }
//         }
//         return false;