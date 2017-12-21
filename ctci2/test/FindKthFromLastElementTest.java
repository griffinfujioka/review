import linkedlist.Node;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class FindKthFromLastElementTest {

    private FindKthFromLastElement findKthFromLastElement;

    private Random random;

    @Before
    public void setup() {
        random = new Random();
        findKthFromLastElement = new FindKthFromLastElement();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenKIsGreaterThanTheLengthOfTheList() {
        int anyData = random.nextInt();
        Node anyNode = new Node(anyData);
        findKthFromLastElement.find(anyNode, 2);
    }

    @Test
    public void shouldReturnTailWhenKIsIsZero() {
        int anyData = random.nextInt();
        int anySecondData = random.nextInt();
        Node anyNode = new Node(anyData);
        Node anySecondNode = new Node(anySecondData);
        anyNode.setNext(anySecondNode);
        assertEquals(anySecondNode, findKthFromLastElement.find(anyNode, 0));
    }

    @Test
    public void shouldReturnHeadWhenKIsEqualToTheLengthOfTheListMinusOne() {
        int anyData = random.nextInt();
        int anySecondData = random.nextInt();
        int anyThirdData = random.nextInt();
        Node anyNode = new Node(anyData);
        Node anySecondNode = new Node(anySecondData);
        Node anyThirdNode = new Node(anyThirdData);
        anyNode.setNext(anySecondNode);
        anySecondNode.setNext(anyThirdNode);

        assertEquals(anyNode, findKthFromLastElement.find(anyNode, 2));
    }

    @Test
    public void shouldReturnKthFromLastElement() {
        int anyData = random.nextInt();
        int anySecondData = random.nextInt();
        int anyThirdData = random.nextInt();
        Node anyNode = new Node(anyData);
        Node anySecondNode = new Node(anySecondData);
        Node anyThirdNode = new Node(anyThirdData);
        anyNode.setNext(anySecondNode);
        anySecondNode.setNext(anyThirdNode);

        assertEquals(anySecondNode, findKthFromLastElement.find(anyNode, 1));
    }
}