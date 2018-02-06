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

    @Test
    public void shouldPartitionListOfSizeOneByReturningTheOriginalList() {
        int anyRandomNumber = random.nextInt();
        griffSinglyLinkedList.add(anyRandomNumber);
        griffSinglyLinkedList.partition(anyRandomNumber);
        assertNotNull(griffSinglyLinkedList.getFirst());
        assertEquals(griffSinglyLinkedList.getFirst().getData(), anyRandomNumber);
    }


    @Test
    public void shouldPartitionListAroundXWhenMultipleInstancesOfXArePresent() {
        int anyRandomValueOfX = Math.abs(random.nextInt() + 1);
        int anyRandomValueLessThanX = anyRandomValueOfX - 1;
        int anyRandomValueGreaterThanX = anyRandomValueOfX + 1;

        assertTrue(anyRandomValueLessThanX < anyRandomValueOfX);
        assertTrue(anyRandomValueGreaterThanX > anyRandomValueOfX);

        griffSinglyLinkedList.add(anyRandomValueOfX);
        griffSinglyLinkedList.add(anyRandomValueLessThanX);
        griffSinglyLinkedList.add(anyRandomValueOfX);
        griffSinglyLinkedList.add(anyRandomValueGreaterThanX);

        griffSinglyLinkedList.partition(anyRandomValueOfX);

        assertNotNull(griffSinglyLinkedList);
        assertNotNull(griffSinglyLinkedList.getFirst());
        Node head = griffSinglyLinkedList.getFirst();
        assertEquals(head.getData(), anyRandomValueLessThanX);
        assertNotNull(head.getNext());
        Node firstInstanceOfX = head.getNext();
        assertEquals(firstInstanceOfX.getData(), anyRandomValueOfX);
        assertNotNull(firstInstanceOfX.getNext());
        Node secondInstanceOfX = firstInstanceOfX.getNext();
        assertEquals(secondInstanceOfX.getData(), anyRandomValueOfX);
        assertNotNull(secondInstanceOfX.getNext());
        Node tail = secondInstanceOfX.getNext();
        assertEquals(tail.getData(), anyRandomValueGreaterThanX);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenPartitionInputListDoesNotContainX() {
        int anyRandomValueOfX = Math.abs(random.nextInt() + 1);
        int anyRandomValueLessThanX = random.nextInt(anyRandomValueOfX);
        int anyRandomValueGreaterThanX = Math.abs(random.nextInt() + anyRandomValueOfX);
        griffSinglyLinkedList.add(anyRandomValueLessThanX);
        griffSinglyLinkedList.add(anyRandomValueGreaterThanX);
        griffSinglyLinkedList.partition(anyRandomValueOfX);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenHeadOfPartitionInputListIsNull() {
        int anyRandomValueOfX = Math.abs(random.nextInt() + 1);
        griffSinglyLinkedList.partition(anyRandomValueOfX);
    }

    @Test
    public void shouldUseXAsHeadOfOutputListWhenPartitionInputListDoesNotContainValuesLessThanX() {
        int anyRandomValueOfX = Math.abs(random.nextInt() + 1);
        int anyRandomValueGreaterThanX = anyRandomValueOfX + 1;
        griffSinglyLinkedList.add(anyRandomValueOfX);
        griffSinglyLinkedList.add(anyRandomValueGreaterThanX);
        griffSinglyLinkedList.partition(anyRandomValueOfX);
        assertNotNull(griffSinglyLinkedList);
        assertNotNull(griffSinglyLinkedList.getFirst());
        assertEquals(griffSinglyLinkedList.getFirst().getData(), anyRandomValueOfX);
    }

    @Test
    public void shouldUseXAsTailOfOutputListWhenPartitionInputListDoesNotContainValuesGreaterThanX() {
        int anyRandomValueOfX = Math.abs(random.nextInt() + 1);
        int anyRandomValueLessThanX = anyRandomValueOfX - 1;
        griffSinglyLinkedList.add(anyRandomValueOfX);
        griffSinglyLinkedList.add(anyRandomValueLessThanX);
        griffSinglyLinkedList.partition(anyRandomValueOfX);
        assertNotNull(griffSinglyLinkedList);
        assertNotNull(griffSinglyLinkedList.getFirst());
        assertEquals(griffSinglyLinkedList.getFirst().getData(), anyRandomValueLessThanX);
        assertNotNull(griffSinglyLinkedList.getFirst().getNext());
        Node instanceOfX = griffSinglyLinkedList.getFirst().getNext();
        assertEquals(instanceOfX.getData(), anyRandomValueOfX);
        assertNull(instanceOfX.getNext());
    }

    @Test
    public void shouldPartitionListAroundXByMovingNodesContainingValuesGreaterThanXToTheRightOfX() {
        int anyRandomValueOfX = Math.abs(random.nextInt() + 1);
        int anyRandomValueGreaterThanX = anyRandomValueOfX + 1;
        griffSinglyLinkedList.add(anyRandomValueGreaterThanX);
        griffSinglyLinkedList.add(anyRandomValueOfX);
        griffSinglyLinkedList.partition(anyRandomValueOfX);
        assertNotNull(griffSinglyLinkedList);
        assertNotNull(griffSinglyLinkedList.getFirst());
        assertEquals(griffSinglyLinkedList.getFirst().getData(), anyRandomValueOfX);
        assertNotNull(griffSinglyLinkedList.getFirst().getNext());
        Node nodeContainingValueGreaterThanX = griffSinglyLinkedList.getFirst().getNext();
        assertEquals(nodeContainingValueGreaterThanX.getData(), anyRandomValueGreaterThanX);
        assertNull(nodeContainingValueGreaterThanX.getNext());
    }

}