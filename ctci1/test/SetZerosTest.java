import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by griffin on 12/15/17.
 */
public class SetZerosTest {

    private SetZeros setZeros;

    @Before
    public void setup() {
        setZeros = new SetZeros();
    }

    @Test
    public void shouldNullifyAllRowsContainingZero() {
        int rowWithZero = 2;

        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {0,8,9},
                {10,11,12}
        };

        setZeros.setZeros(matrix);

        for(int i = 0; i < matrix.length - 1; i++) {
            assertEquals(matrix[rowWithZero][i], 0);
        }
    }

    @Test
    public void shouldNullifyAllColumnsContainingZero() {
        int columnWithZero = 0;

        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {0,8,9},
                {10,11,12}
        };

        setZeros.setZeros(matrix);

        for(int i = 0; i < matrix[0].length - 1; i++) {
            assertEquals(matrix[i][columnWithZero], 0);
        }
    }

}