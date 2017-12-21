import linkedlist.Node; /**
 * Implement an algorithm to find the kth to last element in a singly linked list.
 */
public class FindKthFromLastElement {

    /**
     * Use a runner strategy with runner starting at k and walker started at beginning of list.
     * When runner reaches the last node in the list, then walker will be the correct node to return;
     * @param head
     * @param k
     * @return
     */
    public Node find(Node head, int k) {
        Node walker = head;
        for(int i = 0; i < k; i++) {
            if(head.getNext() == null)
                throw new IllegalArgumentException("k cannot be greater than the length of the list.");

            head = head.getNext();
        }

        while(head.getNext() != null) {
            head = head.getNext();
            walker = walker.getNext();
        }

        return walker;
    }
}
