import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by griffin on 12/16/17.
 */
public class RemoveDuplicatesTest {

    private RemoveDuplicates removeDuplicates;

    private Random random;

    @Before
    public void setup() {
        random = new Random();
        removeDuplicates = new RemoveDuplicates();
    }

    @Test
    public void shouldReturnOriginalListWhenSizeIsOne() {
        final int anyData = random.nextInt();
        Node node = new Node(anyData);
        removeDuplicates.removeDuplicates(node);
        assertEquals(node.getData(), anyData);
        assertNull(node.getNext());
    }

    @Test
    public void shouldReturnSingleNodeWhenInputIsATwoNodeListContainingDuplicateData() {
        final int anyData = random.nextInt();
        Node node = new Node(anyData);
        Node duplicateNode = new Node(anyData);
        node.setNext(duplicateNode);
        removeDuplicates.removeDuplicates(node);
        assertEquals(node.getData(), anyData);
        assertNull(node.getNext());
    }

}