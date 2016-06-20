/**
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * Follow up:
 * Could you do this in-place?
 */

public class RotateImage {
    public void rotate(int[][] matrix) {
        for (int start = 0, end = matrix.length - 1; start < end; start++, end--) {
            for (int i = 0; i < end - start; i++) {
                int swap = matrix[start][start + i];
                matrix[start][start + i] = matrix[end - i][start];
                matrix[end - i][start] = matrix[end][end - i];
                matrix[end][end - i] = matrix[start + i][end];
                matrix[start + i][end] = swap;
            }
        }
    }
}