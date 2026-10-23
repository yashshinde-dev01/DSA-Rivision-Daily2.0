class Solution {
    int ans=0;
    public int totalNQueens(int n) {
        char[][]board=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        
        solve(board,0);
        return ans;
    }
     void solve(char[][]board,int row){
        int n=board.length;
        if(row>=n){
            // ArrayList<String>temp=new ArrayList<>();
            // for(int i=0;i<n;i++){
            //     temp.add(new String(board[i]));
            // }
            // ans.add(temp);
            // return;
            ans++;
        }
        for(int col=0;col<n;col++){
            if(isValid(board,row,col)){
                board[row][col]='Q';
                solve(board,row+1);
                board[row][col]='.';
            }
        }
    }
     boolean isValid(char[][]board,int r,int c){
        // looking upward
        int n=board.length;
        for(int i=r-1; i>=0;i--){
            if(board[i][c]=='Q'){
                return false;
            }
        }
        // Upper-right diagonal
for (int i = r - 1, j = c + 1;
     i >= 0 && j < n; i--, j++) {
    if (board[i][j] == 'Q') {
        return false;
    }
}

// Upper-left diagonal
for (int i = r - 1, j = c - 1;
     i >= 0 && j >= 0; i--, j--) {
    if (board[i][j] == 'Q') {
        return false;
    }
}
        return true;
    }
}