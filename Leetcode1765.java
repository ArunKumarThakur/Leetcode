package Leetcode;

import java.util.Queue;
import java.util.LinkedList;
public class Leetcode1765 {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        Queue<int[]> q = new LinkedList<>();

        int [][]res = new int[m][n];

        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(isWater[i][j] == 1) {
                    res[i][j] = 0;
                    q.offer(new int[]{i,j});
                } else {
                    res[i][j] = -1;
                }
            }
        }

        int [][]dir = {{-1, 0},{0, 1},{1, 0},{0, -1}};
        while(!q.isEmpty()) {
            int arr[] = q.poll();

            int r = arr[0];
            int c = arr[1];
            int h = res[r][c] ;

            for(int j = 0; j<4; j++) {
                int nr = r + dir[j][0];
                int nc = c + dir[j][1];

                if(nr >= 0 && nc >= 0 && nr < m && nc < n && res[nr][nc] == -1){
                    res[nr][nc] = h + 1;
                    q.offer(new int[]{nr,nc});
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int [][]nums = {{0,0,1},{1,0,0},{0,0,0}};
        Leetcode1765 leetcode = new Leetcode1765();
        int [][]res = leetcode.highestPeak(nums);

        for(int []arr : res) {
            for(int value : arr) {
                System.out.print(value +" ");
            }
            System.out.println();
        }
    }
}
