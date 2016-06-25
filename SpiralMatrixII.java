/**
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * For example,
 * Given n = 3,
 * You should return the following matrix:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 *  ]
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int c = 1;
        int rows = 0, rowe = n-1, cols = 0, cole = n-1;
        while (rows <= rowe && cols <= cole) {
            for (int i = cols; i <= cole; i++) {
                res[rows][i] = c;
                c++;
            }
            rows++;
            
            for (int i = rows; i <= rowe; i++) {
                res[i][cole] = c;
                c++;
            }
            cole--;
            
            if (cols <= cole) {
                for (int i = cole; i>= cols; i--) {
                    res[rowe][i] = c;
                    c++;
                }
                rowe--;
            }
            
            if (rows <= rowe) {
                for (int i = rowe; i >= rows; i--) {
                    res[i][cols] = c;
                    c++;
                }
                cols++;
            }
        }
        return res;
    }
}