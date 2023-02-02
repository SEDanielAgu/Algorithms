/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 *
 * @author Daniel Agu
 */
public class Assignment2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        /*  --------------------Testing balcanced symbols--------------------------------
            Uncomment the code below to test the code for balancing symbols question 3.21
            The test repeatedly asks the user for input of an expression that is either balanced
            or not. Enter 0 to exit the loop
        */
//        Scanner input = new Scanner(System.in);
//        
//        System.out.println("Enter an expression and enter 0 to exit: ");
//        String expression = input.nextLine();
//        while (!(expression.equals("0"))){
//        BalancingSymbols test = new BalancingSymbols();
//        if (test.balancing(expression))
//            System.out.println(expression + " is balanced.");
//        else
//            System.out.println(expression + " is not balanced.");
//        System.out.println("Enter an expression and enter 0 to exit: ");
//        expression = input.nextLine();
//        }



        /*  ------------Testing Binary Search Tree Range Method---------------------
            Uncomment the code below to test the code for the tree range method 4.37
            The test manually enters nodes to create a balanced binary tree and then
            executes the method with the given tree and a predefined range of 10 to 55.
            The output of nodes in the tree that fit the range are then printed.
        */
//        BSTRange testTree = new BSTRange();
//        int k1 = 10;
//        int k2 = 55;
//        
//        testTree.setRoot(testTree.new TreeNode(31));
//        testTree.getRoot().setLeftChild(testTree.new TreeNode(36));
//        testTree.getRoot().setRightChild(testTree.new TreeNode(24));
//        testTree.getRoot().getLeftChild().setLeftChild(testTree.new TreeNode(2));
//        testTree.getRoot().getRightChild().setRightChild(testTree.new TreeNode(78));
//        
//        System.out.println("The nodes in the range are:");
//        testTree.printRange(testTree.getRoot(), k1, k2);



        /*  --------------------Testing Chaining Hash Table-------------------------------
            Uncomment the code below to test the code for the Single Linked List Chaining 
            Hash Table 5.5. The test manually enters nodes into a hash table and performs 
            chaining to deal with collisions. The nodes entered are the same ones from question 
            5.1 to test and see if the answers match.
        */
//        ChainingHashTable test = new ChainingHashTable(10);
//        test.insert(4371);
//        test.insert(1323);
//        test.insert(6173);
//        test.insert(4199);
//        test.insert(4344);
//        test.insert(9679);
//        test.insert(1989);
//        test.printTable();



        /*  --------------------Testing Collsion counter--------------------------------
            Uncomment the code below to test the code for the Collsion counter of the different
            collision resolutions 5.3. The test reads the data file given which contains the array size
            as the first number and the rest are ints to be entered as elements. The class will then print
            out the list after the hashing along with the number of collisions. I crossreferenced the class
            with 5.1 to make sure the hashing was done correctly
        */
//        *************linear****************
        File data = new File("data.txt");
        Scanner parse = new Scanner(data);
        CollisionCounter test = new CollisionCounter(parse.nextInt());
        while (parse.hasNextInt()) {
            test.linearProbingInsert(parse.nextInt());
        }
        test.printTable();
        System.out.println("Linear collision count: " + test.getLinearCollisionCount());

//        ***********quadratic********************
//        System.out.println();
//        parse = new Scanner(data);
//        test = new CollisionCounter(parse.nextInt());
//        while (parse.hasNextInt()) {
//            test.quadraticProbingInsert(parse.nextInt());
//        }
//        test.printTable();
//        System.out.println("Quadratic collision count: " + test.getQuadraticCollisionCount());

//        ***************doubleHashing ********************* 
//        System.out.println();
//        parse = new Scanner(data);
//        test = new CollisionCounter(parse.nextInt());
//        while (parse.hasNextInt()) {
//            test.doubleHashingInsert(parse.nextInt());
//        }
//        test.printTable();
//        System.out.println("Double hash collision count: " + test.getDoubleHashCollisionCount());
    }
}
