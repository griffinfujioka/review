package linkedlist;

import exception.NoSuchNodeException;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class GriffSinglyLinkedListTest {

    private Random random;

    private GriffSinglyLinkedList griffSinglyLinkedList;

    @Before
    public void setup() {
        random = new Random();
        griffSinglyLinkedList = new GriffSinglyLinkedList();
    }

    @Test
    public void shouldInstantiateGriffLinkedListWithoutAnyDataForHeadNode() {
        assertNotNull(griffSinglyLinkedList);
    }

    @Test
    public void shouldInstantiateHeadNodeWhenAddingFirstNodeToList()  {
        int anyData = random.nextInt();
        griffSinglyLinkedList.add(anyData);
        assertNotNull(griffSinglyLinkedList);
        assertNotNull(griffSinglyLinkedList.getFirst());
        assertEquals(griffSinglyLinkedList.getFirst().getData(), anyData);
    }

    @Test
    public void shouldAddNodeToEndOfLinkedList() {
        int anyData = random.nextInt();
        int anyOtherData = random.nextInt();
        griffSinglyLinkedList.add(anyData);
        griffSinglyLinkedList.add(anyOtherData);
        assertNotNull(griffSinglyLinkedList.getFirst());
        assertEquals(griffSinglyLinkedList.getFirst().getData(), anyData);
        assertNotNull(griffSinglyLinkedList.getFirst().getNext());
        assertEquals(griffSinglyLinkedList.getFirst().getNext().getData(), anyOtherData);
    }

    @Test(expected = NoSuchNodeException.class)
    public void shouldThrowNoSuchNodeExceptionWhenInputToGetIsLargerThanListSize() throws NoSuchNodeException {
        GriffSinglyLinkedList list = new GriffSinglyLinkedList();
        list.get(0);
    }

    @Test
    public void shouldReturnHeadForGetZerothIndex() throws NoSuchNodeException {
        int anyData = random.nextInt();
        griffSinglyLinkedList.add(anyData);
        assertEquals(griffSinglyLinkedList.getFirst(), griffSinglyLinkedList.get(0));
    }

    @Test
    public void shouldReturnTailForGetFirstIndexOfListSizeTwo() throws NoSuchNodeException {
        int anyData = random.nextInt();
        int anyOtherData = random.nextInt();
        griffSinglyLinkedList.add(anyData);
        griffSinglyLinkedList.add(anyOtherData);
        assertNotNull(griffSinglyLinkedList.get(1));
        assertEquals(griffSinglyLinkedList.get(1).getData(), anyOtherData);
    }

    @Test
    public void shouldReturnOriginalListWhenRemovingDuplicatesSizeIsOne() {
        final int anyData = random.nextInt();
        griffSinglyLinkedList.add(anyData);
        griffSinglyLinkedList.removeDuplicates();
        assertNotNull(griffSinglyLinkedList.getFirst());
        assertEquals(griffSinglyLinkedList.getFirst().getData(), anyData);
        assertNull(griffSinglyLinkedList.getFirst().getNext());
    }

    @Test
    public void shouldDeleteNodeInMiddleOfListGivenOnlyAccessToThatNodeWhenInputIsNull() {
        assertFalse(griffSinglyLinkedList.delete(null));
    }

    @Test
    public void shouldDeleteNodeInMiddleOfListGivenOnlyAccessToThatNodeWhenNextNodeIsNull() {
        final int anyData = random.nextInt();
        griffSinglyLinkedList.add(anyData);
        Node node = griffSinglyLinkedList.getFirst();
        assertNotNull(node);
        assertNull(node.getNext());
        assertTrue(griffSinglyLinkedList.delete(node));
        assertNull(griffSinglyLinkedList.getFirst());
    }

    @Test
    public void shouldDeleteNodeInMiddleOfListGivenOnlyAccessToThatNodeWhenNextNodeIsNotNull() throws NoSuchNodeException {
        final int anyFirstData = Math.abs(random.nextInt());
        final int anySecondData = random.nextInt(anyFirstData - 1);      // ensure that anySecondData != anyFirstData
        final int anyThirdData = random.nextInt();
        griffSinglyLinkedList.add(anyFirstData);
        griffSinglyLinkedList.add(anySecondData);
        griffSinglyLinkedList.add(anyThirdData);
        Node secondNode = griffSinglyLinkedList.get(1);
        assertEquals(secondNode.getData(), anySecondData);
        assertTrue(griffSinglyLinkedList.delete(secondNode));
    }

}