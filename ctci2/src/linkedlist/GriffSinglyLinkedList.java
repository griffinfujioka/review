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

    public void partition(int x) {
        if(this.head == null)
            throw new IllegalArgumentException("Cannot partition null list");

        Node ltHead = null, ltTail = null, gtHead = null, gtTail = null, eqHead = null, eqTail = null;
        Node iterator = this.head;
        while(iterator != null) {
            if(iterator.getData() > x) {
                if(gtHead == null) {
                    gtHead = new Node(iterator.getData());
                    gtTail = gtHead;
                } else {
                    gtTail.setNext(new Node(iterator.getData()));
                    gtTail = gtTail.getNext();
                }
            }
            else if(iterator.getData() < x) {
                if(ltHead == null) {
                    ltHead = new Node(iterator.getData());
                    ltTail = ltHead;
                } else {
                    ltTail.setNext(new Node(iterator.getData()));
                    ltTail = ltTail.getNext();
                }
            }
            else {
                if(eqHead == null) {
                    eqHead = new Node(iterator.getData());
                    eqTail = eqHead;
                } else {
                    eqTail.setNext(new Node(iterator.getData()));
                    eqTail = eqTail.getNext();
                }
            }

            iterator = iterator.getNext();
        }

        if(eqHead == null)
            throw new IllegalArgumentException(String.format("Cannot partition list around x=%d because x is not present in list.", x));

        if(ltTail == null)
            this.head = eqHead;
        else {
            this.head = ltHead;
            ltTail.setNext(eqHead);
        }

        eqTail.setNext(gtHead);
    }
}
