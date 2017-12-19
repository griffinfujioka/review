import linkedlist.Node;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by griffin on 12/16/17.
 *
 * Remove duplicates from an unsorted linked list.
 */
public class RemoveDuplicates {

    public void removeDuplicates(Node head) {
        Set<Integer> valuesInList = new HashSet<>();

        Node previous = null;

        while(head != null) {
            if(valuesInList.contains(head.getData())) {
                // Remove node
                previous.setNext(head.getNext());
            } else {
                valuesInList.add(head.getData());
                previous = head;
            }
            head = head.getNext();
        }
    }

}
