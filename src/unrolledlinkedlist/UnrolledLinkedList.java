/*
 * MIT
 */
package unrolledlinkedlist;

import java.util.ArrayList;

/**
 *
 * @author Dominykas
 * @param <E>
 */
public class UnrolledLinkedList<E> implements ULLInterface<E> {
    /**
     * First node of the list
     */
    private Node<E> first;
    /**
     * Last node of the list
     */
    private Node<E> last;
    /**
     * Actual list size
     */
    private int size;
    /**
     * Maximum elements capacity per node
     */
    private final int nodeCapacity;
    /**
     * Constructor
     * @param capacity 
     */
    UnrolledLinkedList(int capacity) {
        first = null;
        last = null;
        size = 0;
        nodeCapacity = capacity + 1;
    }
    /**
     * Remove the specified element from the list
     * @param element
     * @return True, if operation is successful, false otherwise
     */
    @Override
    public boolean remove(E element) {
        if(element == null) {
            return false;
        }
        
        Node<E> elementNode = getNode(element);
        elementNode.removeElement(element);
        Node<E> nextNode = elementNode.next;
        while(elementNode.getElementsCount() < nodeCapacity / 2 && 
                nextNode != null && nextNode.getElement(nextNode.getElementsCount() - 1) != null)
        {
            E elementToBeMoved = nextNode.getElement(nextNode.getElementsCount() - 1);
            elementNode.AddElement(elementToBeMoved);
            nextNode.removeElement(elementToBeMoved);
        }
        
        if(nextNode != null && nextNode.getElementsCount() < nodeCapacity / 2)
        {
            mergeNodes(elementNode, nextNode);
            nextNode.elements.removeAll(nextNode.elements);
            removeNode(elementNode);
        }
        
        if(elementNode.getElementsCount() == 0)
        {
            removeNode(nodeBefore(elementNode));
            return true;
        }
        return false;
    }
    /**
     * Remove a node which is after the given one
     * @param nodeBefore 
     */
    private void removeNode(Node<E> nodeBefore) {
        if (nodeBefore == null)
        {
            first = null;
            last = null;
        }
        else if(nodeBefore.next == last)
        {
            nodeBefore.next = null;
            last = nodeBefore;
            nodeBefore.next = null;
            
        } else {
            Node<E> temporary = nodeBefore.next;
            nodeBefore.next = temporary.next;
            temporary = null;
        }
    }
    /**
     * Merge the array of the second node elements to the first node
     * @param node1
     * @param node2 
     */
    private void mergeNodes(Node<E> node1, Node<E> node2) {
        for (E element : node2.getElements())
        {
            node1.AddElement(element);
        }
    }
    /**
     * Get the node before the specified node
     * @param node
     * @return The node before
     */
    private Node<E> nodeBefore(Node<E> node)
    {
        for(Node<E> start = first; start != null; start = start.next)
        {
            if(start.next == node)
            {
                return start;
            }
        }
        return null;
    }
    /**
     * Get the first node containing specified element
     * @param element
     * @return Node
     */
    private Node<E> getNode(E element) {
        for(Node<E> start = first; start != null; start = start.next)
        {
            if(start.containsElement(element))
            {
                return start;
            }
        }
        return null;
    }
    /**
     * 
     * @return maximum node elements capacity
     */
    public int getNodeSize() {
        return nodeCapacity - 1;
    }
    /**
     * Check if the list contains the specified element
     * @param element
     * @return True if contains, false otherwise
     */
    @Override
    public boolean contains(E element) {
        for(Node<E> start = first; start != null; start = start.next)
        {
            if(start.containsElement(element))
                return true;
        }
        return false;
    }
    /**
     * Check if the list is empty
     * @return True if empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    /**
     * Format list data to a string
     * @return List data
     */
    public String toString() {
        String results = "";
        for(Node<E> start = first; start != null; start = start.next)
        {
            results += start.toString();
        }
        return results;
    }
    /**
     * Get the size of the list
     * @return Nodes amount
     */
    @Override
    public int size() {
        return size;
    }
    /**
     * 
     * @return how many elements are stored in this list
     */
    public int dataSize() {
        int sum = 0;
        for(Node<E> start = first; start != null; start = start.next)
        {
            sum += start.getElementsCount();
        }
        return sum;
    }
    /**
     * Destroy the list by disconnecting nodes, Java trash collector will do the rest
     */
    @Override
    public void destroy() {
        first = null;
        last = null;
        size = 0;
    }
    /**
     * Add an element to the last node of the list
     * @param element 
     */
    @Override
    public void add(E element) {
        if (element == null) {
            return;
        }
        
        if (first == null) {
            first = new Node<>(null, nodeCapacity);
            first.AddElement(element);
            last = first;
            size++;
            return;
        } 
        
        if(last.getElementsCount() + 1 < nodeCapacity)
        {
            last.AddElement(element);
        } else {
            Node<E> newNode = new Node<>(null, nodeCapacity);
            for(int i = last.getElementsCount() / 2 + 1; i < last.getElementsCount(); i++)
            {
                E currentElement = last.getElement(i);
                newNode.AddElement(currentElement);
                last.removeElement(currentElement);
            }
            newNode.AddElement(element);
            last.next = newNode;
            last = newNode;
            size++;
        }
    }
    /**
     * Node class
     * @param <E> 
     */
    private static class Node<E> {
        /**
         * Elements array
         */
        private final ArrayList<E> elements;
        /**
         * Next node
         */
        private Node<E> next;
        /**
         * Max number of elements in the array
         */
        private final int maxElements;
        /**
         * Node constructor
         * @param next
         * @param maxElements 
         */
        Node(Node<E> next, int maxElements)
        {
            this.next = next;
            this.maxElements = maxElements;
            this.elements = new ArrayList<>();
        }
        
        /**
         * Adds a new element to the array
         * @param element
         * @return true if operation is successful, false otherwise
         */
        protected boolean AddElement(E element) {
            if(elements.size() < maxElements)
            {
                this.elements.add(element);
                return true;
            } 
            return false;
        }
        /**
         * Gets the size of the elements array
         * @return Size of array
         */
        protected int getElementsCount() {
            return this.elements.size();
        }
        /**
         * Gets the whole array of elements
         * @return Array
         */
        protected ArrayList<E> getElements() {
            return this.elements;
        }
        /**
         * Gets element at the specified index in the array
         * @param index
         * @return Element
         */
        protected E getElement(int index) {
            return this.elements.get(index);
        }
        /**
         * Removes the specified element from the list
         * @param element
         * @return true if operation is successful, false otherwise
         */
        protected boolean removeElement(E element) {
            return this.elements.remove(element);
        }
        /**
         * Checks if the specified element is included in the list
         * @param element
         * @return True if it does, false otherwise
         */
        protected boolean containsElement(E element) {
            return this.elements.contains(element);
        }
        /**
         * Node elements string
         * @return 
         */
        @Override
        public String toString() {
            String heading = "Node elements: \r\n";
            for (E element : this.elements) {
                heading += "        " + element.toString() + "\r\n";
            }
            return heading;
        }
        
    }
}

