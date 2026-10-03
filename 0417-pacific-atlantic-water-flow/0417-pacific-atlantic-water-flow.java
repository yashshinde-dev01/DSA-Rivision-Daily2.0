class Solution {

    int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    ArrayList<List<Integer>>ans=new ArrayList<>();
      public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;
         boolean[][]atlantic=new boolean[m][n];
      boolean[][]pacific=new boolean[m][n];

      // top row and bottom row start dfs from here 
      for(int i=0;i<n;i++){
        DFS(heights,0,i,Integer.MIN_VALUE,pacific);
        DFS(heights,m-1,i,Integer.MIN_VALUE,atlantic);
      }

      // left col and right col dfs 
      for(int i=0;i<m;i++){
         DFS(heights,i,0,Integer.MIN_VALUE,pacific);
        DFS(heights,i,n-1,Integer.MIN_VALUE,atlantic);
      }
      for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(atlantic[i][j]==true && pacific[i][j]==true){
                ans.add(Arrays.asList(i,j));
            }
        }
      }
      return ans;
    }
    void DFS(int[][]matrix,int i,int j,int prev,boolean[][]visi){
        int m=matrix.length;
        int n=matrix[0].length;
        if(i<0 || i>=m || j<0 || j>=n || visi[i][j]==true){
            return;
        }
        if(matrix[i][j]<prev){
            return ;
        }
        visi[i][j]=true;
        for(int[]neig:dirs){
            int new_i=i+neig[0];
            int new_j=j+neig[1];

            DFS(matrix,new_i,new_j,matrix[i][j],visi);
        }
    }
}