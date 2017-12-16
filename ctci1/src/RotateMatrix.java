/**
 * Created by griffin on 12/14/17.
 */
public class RotateMatrix {
    public void rotate(int[][] matrix, int n) {

        for(int layer = 0; layer < n/2; layer++) {
            int start = layer;
            int end = n - layer - 1;

            for(int i = start; i < end; ++i) {
                int offset = i - start;
                int temp = matrix[start][i];
                matrix[start][i] = matrix[end-offset][start];
                matrix[end - offset][start] = matrix[end][end - offset];
                matrix[end][end - offset] = matrix[i][end];
                matrix[i][end] = temp;
            }
        }

        return;
    }
}
