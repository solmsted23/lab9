/*
 * Mike McKee
 * CPSC 5002, Seattle University 
 * This is free an unencumbered software released into public domain. 
 */

/**
 * This is a generic stack class and includes: a constructor,
 * push, pop, peek, and empty methods.  
 * @param <E> data type of stack elements 
 * @author Mike McKee
 */
public class Stack<E> {
    /**
     * top of the stack
     */
    private Node head; 
    /**
     * The Node class is used to implement the linked list for a generic stack
     * @author Mike McKee
     * @param <E> data type of stack elements 
     */
    private class Node {
        /**
         * Holds stack element.
         */
        public E data; 
        
        /**
         * Points to next node in linked list. 
         */
        public Node next; 
        
        /**
         * The Node constructor initializes each instance of the Node class. 
         * @param data  The data that is stored in Node
         * @param next  A pointer to the succeeding Node
         */
        public Node(E data, Node next) {
            this.data = data;
            this.next = next; 
        }
    }
    
    /**
     * The Stack no-arg constructor initializes new instances of Stack objects. 
     */
    public Stack () {
        head = null;
    }
    
    /**
     * The push method adds an item to the top of the stack. 
     * @param data The item that is to be added to top of stack
     */
    public void push(E data) {
        head = new Node (data, head);
    }
    
    /**
     * The peek method returns the item currently at top of stack but does not
     * remove item from stack. peek throws an exception if it is called when
     * the stack is empty. 
     * @return item at top of stack
     * @throws IllegalArgumentException if user tries to peek at empty stack
     */
    public E peek() {
        if (empty())
            throw new IllegalArgumentException("Error: The stack is empty!");
        else
            return head.data;      
    }
    
    /**
     * The pop method removes and returns the item at top of stack. If the 
     * stack is empty, pop throws an exception. 
     * @return item at top of stack
     */
    public E pop() {
        E data;    //holds item on top of stack 
        
        data = peek();          //peek throws an exception if stack is empty 
        head = head.next;
        return data; 
    }
    
    /**
     * The empty method returns true if stack is empty and false otherwise.
     * @return true if stack is empty and false otherwise
     */
    public boolean empty() {
        return head == null;
    }
    
    /**
     * toString method returns the items in the stack as a String
     * @return String representation of items in the stack. 
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Node i = head; i != null; i = i.next) {
            sb.append(i.data); 
        }
        return sb.toString();
    }
    
    /**
     * makes a copy of a stack 
     * @return copy of a stack
     */
    public Stack<E> copy() { 
        Stack<E> copyStack = new Stack<>();
        if (head == null)
            return copyStack; 
        
        if (copyStack.empty())          //if copyStack is empty 
            copyStack.push(head.data);
        
        Node p = copyStack.head; 
        
        //when stack is not empty
        for (Node i = head.next; i != null; i = i.next) { 
            p.next = new Node(i.data, null);
            p = p.next;     
        }
        return copyStack;
    }
    
    /**
     * Compares if two stacks are equal.
     * @param s1 stack to compare 
     * @return true if both stacks are equal and false otherwise 
     */
    public boolean equals(Stack<E> s1) {
        Node p = head; 
        Node p1 = s1.head; 
        
        while (p != null & p1 != null) {
            if (p.data != p1.data)
                return false; 
            p = p.next;
            p1 = p1.next; 
        }
            
        if (p == null && p1 == null)
            return true; 
        else 
            return false; 
    }
}
