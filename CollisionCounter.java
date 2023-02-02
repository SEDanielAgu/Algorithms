/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Daniel Agu
 */
public class CollisionCounter {

    // element class holds and integer and was implemented in the case of user entry of a 0
    // arrays are by default 0's if the type is an int so this solves the problem
    public class Element {

        int value = 0;

        public Element(int n) {
            value = n;
        }

        // set method for element
        public void setValue(int n) {
            value = n;
        }
        // get method for element
        public int getValue() {
            return value;
        }
    }

    // variables that keep track of the number of collisions for each resolution method along with the hash table
    int linearCollisions = 0;
    int quadraticCollisions = 0;
    int doubleHashCollisions = 0;
    Element[] hashTable;
    
    public CollisionCounter(int size) {
        hashTable = new Element[size];
    }
    
    // the method goes through and implements the linear probing collision resolution and keeps track of the number of
    // collisions. Hash function: (h + 1) mod k where k is table length
    public void linearProbingInsert(int n) {
        int i = 0;
        int index = (n + i) % hashTable.length;     // sets the intial index
        if (hashTable[index] == null) {             // checks the current hash table index to see if the spot is full or not
            hashTable[index] = new Element(n);
        } else {                                    
            while (hashTable[index] != null) {      
                linearCollisions++;                 // if the spot is not full increment i and the number of collisions
                i++;
                index = (n + i) % hashTable.length; // then re-run the hashing function until a spot is found
            }
            hashTable[index] = new Element(n);
        }
    }

    // the method goes through and implements the quadratic probing collision resolution and keeps track of the number of
    // collisions. Hash function: (h + i^2) mod k where k is table length
    public void quadraticProbingInsert(int n) {
        int i = 0;
        int index = (n + i) % hashTable.length;     // sets the intial index
        if (hashTable[index] == null) {             // checks the current hash table index to see if the spot is full or not
            hashTable[index] = new Element(n);
        } else {                                    
            while (hashTable[index] != null) {      
                quadraticCollisions++;                      // if the spot is not full increment i and the number of collisions
                i++;    
                index = (n + (i * i)) % hashTable.length;   // then re-run the hashing function until a spot is found
            }
            hashTable[index] = new Element(n);
        }
    }

    // the method goes through and implements the quadratic probing collision resolution and keeps track of the number of
    // collisions. Hash function: ((h mod k) + (i * (7 - (h mod 7)))) mod k where k is table length
    public void doubleHashingInsert(int n) {
        int i = 0;
        int index = ((n % hashTable.length) + (i * (7 - (n % 7)))) % hashTable.length;  // sets the intial index
        if (hashTable[index] == null) {                                                 // checks the current hash table index to see if the spot is full or not
            hashTable[index] = new Element(n);
        } else {
            while (hashTable[index] != null) {
                doubleHashCollisions++;                                                 // if the spot is not full increment i and the number of collisions
                i++;
                index = ((n % hashTable.length) + (i * (7 - (n % 7)))) % hashTable.length;   // then re-run the hashing function until a spot is found
            }
            hashTable[index] = new Element(n);
        }
    }

    // returns the amount of collisions using linear probing
    public int getLinearCollisionCount() { 
        return linearCollisions;
    }

    // returns the amount of collisions using quadratic probing
    public int getQuadraticCollisionCount() {
        return quadraticCollisions;
    }
    
    // returns the amount of collisions using double hashing
    public int getDoubleHashCollisionCount() {
        return doubleHashCollisions;
    }
    
    // prints out the hash table in order
    public void printTable() {
        for (int i = 0; i < hashTable.length; i++) {
            System.out.print(i + ": ");
            if (hashTable[i] != null)
                System.out.print(hashTable[i].getValue() + "");
            System.out.println();
        }
    }
}
