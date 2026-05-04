import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private List<List<String>> result = new ArrayList<>();
    private int[] x; 

    public List<List<String>> solveNQueens(int n) {
        x = new int[n];
        nQueen(0, n);
        return result;
    }
    private boolean QueenPos(int k, int i){
            for(int j=0; j<k;j++){
                if(x[j]==i||(Math.abs(x[j]-i)==Math.abs(j-k))){
                    return false;
                }
            }
            return true;
        }
    private void nQueen(int k, int n) {
        for (int i = 0; i < n; i++) {
            if (QueenPos(k, i)) {
                x[k] = i; 
                if (k == n - 1) { 
                    result.add(construct(n));
                } else {
                    nQueen(k + 1, n); 
                }
            }
        }
    }
    private List<String> construct(int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[x[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}