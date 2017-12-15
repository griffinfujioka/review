/**
 * Created by griffin on 12/14/17.
 */
public class RotateMatrix {
    public void rotate(int[][] matrix, int n) {

        for(int layer = 0; layer < n/2; layer++) {
            int start = layer;
            int end = n - layer - 1;

            for(int i = start; i < end; i++) {
                int temp = matrix[layer][start];
                matrix[layer][start] = matrix[end][layer];
                matrix[end][layer] = matrix[end][end];
                matrix[end][end] = matrix[layer][end];
                matrix[layer][end] = temp;
            }
        }

        return;
    }
}
