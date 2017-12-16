import java.util.HashSet;
import java.util.Set;

/**
 * Created by griffin on 12/15/17.
 */
public class SetZeros {
    public void setZeros(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> columns = new HashSet<>();

        for(int i = 0; i < matrix.length - 1; i++) {
            for(int j = 0; j < matrix[0].length - 1; j++) {
                if(matrix[i][j] == 0) {
                    rows.add(i);
                    columns.add(j);
                }
            }
        }

        for(Integer row : rows) {
            for(int i = 0; i < matrix.length - 1; i++) {
                matrix[row][i] = 0;
            }
        }

        for(Integer column : columns) {
            for(int i = 0; i < matrix[0].length - 1; i++) {
                matrix[i][column] = 0;
            }
        }


    }
}
