/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Daniel Agu
 */
public class ChainingHashTable {
    // Node class used to build the sinlge linked list
    public class Node {

        int nodeValue;
        Node nextNode = null;

        // default constructor for a node that accepts the value and the next node in the linked list
        public Node(int a, Node n) {
            nodeValue = a;
            nextNode = n;
        }

        // default constructor for a node that accepts the value of the first node in the linked list
        public Node(int a) {
            nodeValue = a;
        }

        // get methods for the node
        public int getValue() {
            return nodeValue;
        }

        public Node getNextNode() {
            return nextNode;
        }

        // set methods for the node
        public void setValue(int a) {
            nodeValue = a;
        }

        public void setNextNode(Node n) {
            nextNode = n;
        }
    }
    
    // class that builds the linked list to be used in the hash table
    public class SinglyLinkedList {
        Node head;
        
        // default constructor
        public SinglyLinkedList() {
            head = null;
        }
        
        // constructor that takes in a node to become the head of the list
        public SinglyLinkedList(Node n) {
            head = n;
        }
        
        // clears the linked list
        public void clear() {
            head = null;
        }
        
        // method to check and see if the int entered is in the current linked list as a node
        public boolean contains(int n) {
            Node currentNode = head;
            while (currentNode != null) {                   // traverses the linked list
                if (currentNode.getValue() == n) {          // checks the value to find the match
                    return true;                            // return true if the value is found false otherwise
                }
                currentNode = currentNode.getNextNode();
            }
            return false;
        } 

        // method to add a node to the linked list
        public void addNode(int n) {
            Node newNode = new Node(n);     // creates a node with the specified value
            Node currentNode = head;
            
            if (head == null) {     // special case where the list is empty then add the node as the head
                head = newNode;
            } else {
                while (currentNode != null && currentNode.getNextNode() != null) // traverses the list until it hits the end and adds the new node
                    currentNode = currentNode.getNextNode();
                currentNode.setNextNode(newNode);
            }
        }
        
        // method to remove a node with the specified value from the linked list
        public void removeNode(int n) {
            Node currentNode = head;
            Node toBeRemoved = null;
            if (contains(n)) {                  // first makes sure that the value is in the linked list to begin with
                if (head.getValue() == n) {     // special case where the head is the node to be removed
                    head = head.getNextNode();  // set the new head as the previous head's next node
                } else {
                    while (currentNode != null && currentNode.getNextNode() != null) {      // traverses the list searching for the node to be removed
                        currentNode = currentNode.getNextNode();
                        if (currentNode.getNextNode().getValue() == n) {          // if the node's next is the found value then capture the node and break from the loop
                            toBeRemoved = currentNode;
                            break;
                        }
                    }
                    if (toBeRemoved.getNextNode().getNextNode() == null)
                        toBeRemoved.setNextNode(null);
                    else
                        toBeRemoved.setNextNode(toBeRemoved.getNextNode().getNextNode());   // remove the node by setting the its next node to its next next node
                }
            }
        }
        
        // method for printing the linked list
        public void printList() {
            Node currentNode = head;
            while (currentNode != null) {
                System.out.print(currentNode.getValue() + " ");
                currentNode = currentNode.getNextNode();
            }
        }
    }
    
    // defines the hash table of linked lists
    SinglyLinkedList[] table = new SinglyLinkedList[10];
    int size = 0;
    
    // constructor that takes in a predefined hash table
    public ChainingHashTable(SinglyLinkedList[] hashTable) {
        table = hashTable;
    }
    
    // constructor that takes in the hash table's length
    public ChainingHashTable(int tableLength) {
        table = new SinglyLinkedList[tableLength];
    }
    
    // method that checks if the hash tbale is empty
    public boolean isEmpty() {
        if (size == 0)
            return true;
        return false;
    }
    
    // get method for the size of the hash tbale
    public int getSize() {
        return size;
    }
    
    // method to insert the value into the hash tbale
    public void insert(int n) {
        size++;                             // keeps track of the amount of elements in the hash table
        int index = hashFunction(n);        // finds the index in the hash table for the value using the hash function       
        if (table[index] == null) {         // if it is empty place it there
            SinglyLinkedList element = new SinglyLinkedList(new Node(n));
            table[index] = element;
        } else {                            // if it is not empty chain it to what is already present
            table[index].addNode(n);
        }
    }
    
    // method to remove the value from the hash table
    public void remove(int n) {
        int index = hashFunction(n);        // finds the index in the hash table for the value using the hash function
        if (table[index].contains(n))       // checks to see if the value is in the list
            table[index].removeNode(n);     // removes the node
        else 
            System.out.println("Value not found");
        size--;
    }
    
    // hash function that takes in a vlaue and returns the index
    public int hashFunction(int n) {
        return n % table.length;
    }
    
    // prints the table with the chains
    public void printTable() {
        for (int i = 0; i < table.length; i++) {
            System.out.print(i + ": ");
            if (table[i] != null)
                table[i].printList();
            System.out.println();
        }
    }
}
