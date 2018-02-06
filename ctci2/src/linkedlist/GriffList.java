package linkedlist;

import exception.NoSuchNodeException;

/**
 * Interface for Griffin's implementation(s) of a list, which is an ordered collection.
 *
 * To some extent, based on {@link java.util.List}.
 */
public interface GriffList {

    /**
     * Add new node to the end of list with the specified data.
     *
     * @param data
     */
    void add(int data);

    /**
     * Return the node at the specified position in the list.
     *
     * @param index
     * @return
     */
    Node get(int index) throws NoSuchNodeException;

    /**
     * Delete a node in the middle of the list given access only to that node.
     *
     * @param node
     * @return
     */
    boolean delete(Node node);

    /**
     * Partition the list such that all elements less than x are positioned to the left of x,
     * and all elements greater than x are positioned to the right of x.
     * @param x
     */
    void partition(int x);
}
