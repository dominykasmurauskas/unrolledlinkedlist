/*
 * MIT
 */
package unrolledlinkedlist;

/**
 *
 * @author Dominykas
 * @param <E>
 */
public interface ULLInterface<E> {
    
    /**
     * Add a new element to the Unrolled Linked List
     * @param element
     */
    void add ( E element );
    
    /**
     * Destroy an element from the Unrolled Linked List
     * @param element
     * @return true, if operation is successful, false otherwise
     */
    boolean remove (E element);
    
    /**
     * Check if the specified element exists in the Unrolled Linked list
     * @param element
     * @return true if element is included in the list, false otherwise
     */
    boolean contains( E element );
    
    /**
     * Check if the Unrolled Linked List is empty
     * @return true if empty, false otherwise
     */
    boolean isEmpty();
    
    /**
     * Get the amount of nodes in the Unrolled Linked List
     * @return amount of nodes
     */
    int size();
    
    /**
     * Destroy the linked list by disconnecting nodes. 
     */
    void destroy();
}
