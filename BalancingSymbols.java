/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.EmptyStackException;

/**
 *
 * @author Daniel Agu
 */
public class BalancingSymbols {

    public class ArrayStack {

        // initalizes the pointer to the top of the stack and creates an array of size 20 that holds the stack
        private int top = 0;
        private String[] elements = new String[20];

        // checks to see if the stack is empty and returns true or false
        public boolean isEmpty() {
            if (top == 0) {
                return true;
            }
            return false;
        }

        // pushes a given element into the top spot of the array 
        // if the array(stack) is full it creates a new array 5 times the size and copies the elements over
        public void push(String d) {
            if (top == elements.length) {
                String[] newElements = new String[elements.length * 5];
                for (int i = 0; i < elements.length; i++) {
                    newElements[i] = elements[i];
                }
                elements = newElements;
            }

            elements[top] = d;
            top++;
        }

        // pops the top element from the stack and returns it if the stack is not empty 
        public String pop() {
            if (isEmpty()) {
                throw new EmptyStackException();
            }
            String poppedElement = peek();
            top--;
            return poppedElement;
        }

        // peeks to check the top element in the stack and returns it if the stack is not empty
        public String peek() {
            if (isEmpty()) {
                throw new EmptyStackException();
            }
            String topElement = elements[top - 1];
            return topElement;
        }
    }

    // method that chckes for the matching symbols
    boolean matchingSymbols(String a, String b) {
        if (a.equals("/*") && b.equals("*/")) {
            return true;
        }
        if (a.equals("(") && b.equals(")")) {
            return true;
        }
        if (a.equals("[") && b.equals("]")) {
            return true;
        }
        if (a.equals("{") && b.equals("}")) {
            return true;
        }
        if (a.equals("begin") && b.equals("end")) {
            return true;
        }
        return false;
    }

    // method that balances the symbols using the stack
    boolean balancing(String expression) {
        ArrayStack stack = new ArrayStack();
        for (int i = 0; i < expression.length(); i++) {     // traverses the expression given
            if (i == 0 && expression.contains("begin") && expression.substring(0, 5).equals("begin")) {     // pushes begin if it is found
                stack.push(expression.substring(0, 5));
            } else if (isCloseSymbol(expression.charAt(i) + "")) {
                if (stack.isEmpty() || !matchingSymbols(stack.peek(), expression.charAt(i) + "")) {     // pops if a single close symbol is found or exits if the stack is empty or the wrong symbol is found
                    return false;
                } else {
                    stack.pop();
                }
            } else if ((i + 1) < expression.length() && isCloseSymbol(expression.charAt(i) + expression.charAt(i + 1) + "")) { // pops if */ is found or exits if the stack is empty or if the open symbol is not /*
                if (stack.isEmpty() || !matchingSymbols(stack.peek(), (expression.charAt(i) + expression.charAt(i + 1) + ""))) {
                    return false;
                } else {
                    stack.pop();
                }
            } else if (isOpenSymbol(expression.charAt(i) + "")) { // pushes a single open single to the stack
                stack.push(expression.charAt(i) + "");
            } else if ((i + 1) < expression.length() && isOpenSymbol(expression.charAt(i) + expression.charAt(i + 1) + "")) { // pushes /* to the stack if its found
                stack.push(expression.charAt(i) + expression.charAt(i + 1) + "");
            } else if (i == expression.length() - 3 && expression.contains("end") && expression.substring(expression.length() - 3, expression.length()).equals("end")) { // pops begin if the correct matching symbol is begin and exits if the stack is empty
                if (stack.isEmpty() || !matchingSymbols(stack.peek(), expression.substring(expression.length() - 3, expression.length()))) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    // method that checks to see if it is an open symbol
    boolean isOpenSymbol(String syb) {
        String[] symbols = {"/*", "(", "[", "{", "begin"};
        for (String i : symbols) {
            if (i.equals(syb)) {
                return true;
            }
        }
        return false;
    }

    // method that checks to see if it is an close symbol
    boolean isCloseSymbol(String syb) {
        String[] symbols = {"*/", ")", "]", "}", "end"};
        for (String i : symbols) {
            if (i.equals(syb)) {
                return true;
            }
        }
        return false;
    }
}
