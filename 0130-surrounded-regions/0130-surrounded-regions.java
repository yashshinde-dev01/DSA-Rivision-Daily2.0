class Solution {
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;


        for(int i=0;i<m;i++){
            if(board[i][0]=='O')dfs(board,i,0);
            if(board[i][n-1]=='O')dfs(board,i,n-1);
        }
        for(int j=0;j<n;j++){
            if(board[0][j]=='O')dfs(board,0,j);
            if(board[m-1][j]=='O')dfs(board,m-1,j);
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }else if(board[i][j]=='#'){
                    board[i][j]='O';
                }
            }
        }
    }
    void dfs(char[][]mat,int si,int ej){
        int m=mat.length;
        int n=mat[0].length;

        if(si<0 || ej<0 || si>=m || ej>=n || mat[si][ej]!='O'){
            return;
        }
        mat[si][ej]='#';

        dfs(mat,si+1,ej);
        dfs(mat,si-1,ej);
        dfs(mat,si,ej+1);
        dfs(mat,si,ej-1);

    }
}