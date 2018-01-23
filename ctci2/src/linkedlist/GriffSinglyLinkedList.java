package linkedlist;

import exception.NoSuchNodeException;

public class GriffSinglyLinkedList implements GriffList {

    private Node head;


    public void add(int data) {
        if(this.head == null)
            this.head = new Node(data);
        else {
            Node temp = head;
            while(temp.getNext() != null) {
                temp = temp.getNext();
            }

            temp.setNext(new Node(data));
        }
    }

    public Node get(int index) throws NoSuchNodeException {
        if(this.head == null)
            throw new NoSuchNodeException("No entries in list.");

        int counter = 0;
        Node temp = head;
        while(counter < index) {
            counter++;
            temp = temp.getNext();
        }

        return temp;
    }

    public Node getFirst() {
        return head;
    }

    public void removeDuplicates() {

    }

    public boolean delete(Node node) {
        if(node == null)
            return false;

        if(this.head == node) {
            this.head = null;
            return true;
        } else if (node.getNext() != null) {
            Node nextNode = node.getNext();
            node.setData(nextNode.getData());
            node.setNext(nextNode.getNext());
            return true;
        }

        return false;
    }
}
