class Solution {
    ArrayList<List<String>>ans=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][]board=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        
        solve(board,0);
        return ans;
    }
    ArrayList<Integer>column=new ArrayList<>();
    ArrayList<Integer>rightdia=new ArrayList<>();
    ArrayList<Integer>leftdia=new ArrayList<>();
    void solve(char[][]board,int row){
        int n=board.length;
        if(row>=n){
            ArrayList<String>temp=new ArrayList<>();
            for(int i=0;i<n;i++){
                temp.add(new String(board[i]));
            }
            ans.add(temp);
            return;
        }
        for(int col=0;col<n;col++){
            if(column.contains(col) || rightdia.contains(row+col) || leftdia.contains(row-col)){
                continue;
            }
            board[row][col]='Q';
            column.add(col);
            rightdia.add(row+col);
            leftdia.add(row-col);
            solve(board,row+1);
            column.remove(column.size()-1);
            rightdia.remove(rightdia.size()-1);
            leftdia.remove(leftdia.size()-1);
            board[row][col]='.';
        }
    }
    
}