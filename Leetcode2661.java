package Leetcode;
import java.util.*;
public class Leetcode2661 {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        HashMap<Integer, Integer> rowMap = new HashMap<>();
        HashMap<Integer, Integer> colMap = new HashMap<>();
        int row = mat.length;
        int col = mat[0].length;
        for(int i = 0; i<row; i++) {
            for(int j = 0; j<col; j++) {
                rowMap.put(mat[i][j], i);
                colMap.put(mat[i][j], j);
            }
        }

        int []rowIndex = new int[row];
        int []colIndex = new int[col];
        for(int i = 0; i<arr.length; i++) {
            int rowIdx = rowMap.get(arr[i]);
            int colIdx = colMap.get(arr[i]);

            rowIndex[rowIdx]++;
            colIndex[colIdx]++;

            if(rowIndex[rowIdx] == col) return i;
            if(colIndex[colIdx] == row) return i;
        }

        return -1;
    }
    public static void main(String[] args) {
        int []arr = {1,3,4,2};
        int [][]mat = {{1,4}, {2,3}};
        Leetcode2661 l1 = new Leetcode2661();
        int idx = l1.firstCompleteIndex(arr, mat);
        System.out.println(idx);
    }
}




