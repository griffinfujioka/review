import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by griffin on 12/14/17.
 */
public class RotateMatrixTest {

    private RotateMatrix rotateMatrix;

    private Random random;

    @Before
    public void setup() {
        random = new Random();
        rotateMatrix = new RotateMatrix();
    }

    @Test
    public void shouldReturnOriginalMatrixWhenNEqualsOne() {
        final int anyInteger = random.nextInt();
        int[][] matrix = new int[][] { {anyInteger} };
        rotateMatrix.rotate(matrix, matrix.length);
        assertEquals(matrix[0][0], anyInteger);
    }

    @Test
    public void shouldReturnRotatedTwoByTwoMatrix() {
        final int arraySize = 2;
        int[][] matrix = createMatrix(arraySize);
        int topLeft = matrix[0][0];
        int topRight = matrix[0][1];
        int bottomLeft = matrix[1][0];
        int bottomRight = matrix[1][1];

        rotateMatrix.rotate(matrix, arraySize);

        assertEquals(bottomLeft, matrix[0][0]);
        assertEquals(topLeft, matrix[0][1]);
        assertEquals(topRight, matrix[1][1]);
        assertEquals(bottomRight, matrix[1][0]);
    }

    @Test
    public void shouldReturnRotatedThreeByThreeMatrix() {
    }

    private int[][] createMatrix(int size) {
        int[][] matrix = new int[size][size];
        for(int i = 0; i < size; i++) {
            for(int j=0; j < size; j++) {
                matrix[i][j] = random.nextInt(10);
            }
        }

        return matrix;
    }
}