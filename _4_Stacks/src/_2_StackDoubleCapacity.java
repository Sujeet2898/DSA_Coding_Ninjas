public class _2_StackDoubleCapacity {
}
    Create Project: Stack

        Create Package: default

Create class: StackUsingArray
        ----------------------------------------------
public class StackUsingArray {

    private int data[];
    private int top;  // is the index of topmost element of stack

    public StackUsingArray(){   // constructor
        data = new int[10];
        top = -1;
    }
    public StackUsingArray(int capacity){   // other constructor
        data = new int[capacity];
        top = -1;
    }

    public boolean isEmpty(){         // Time Complexity = O(1)
//        if (top == -1){
//            return  true;
//        }else {
//            return false;
//        }
        return (top == -1);
    }

    public int size(){    // Time Complexity = O(1)
        return top + 1;  // Initially when Stack has made, the Top is -1
        // And Stack size is zero
        // So, top(-1) + 1 will be zero
    }

    public int top() throws StackEmptyException{    // Time Complexity = O(1)
        if (size() == 0){
            // StackEmptyException
            StackEmptyException e = new StackEmptyException();
            throw e;
        }
        return data[top];
    }

    public void push(int elem) throws StackFullException {      // Time Complexity = O(1)
        if (size() == data.length){                             // Time Complexity = O(n) during doubleCapacity()
//            // StackFullException
//            StackFullException e = new StackFullException();
//            throw e;
            doubleCapacity();
        }
        top++;
        data[top] = elem;
    }

    private void doubleCapacity(){
        int temp[] = data;
        data = new int[2 * temp.length];
        for (int i = 0; i <= top; i++){
            data[i] = temp[i];
        }
    }

    public int pop() throws StackEmptyException {     //Time Complexity = O(1)
        if (size() == 0){
            // StackEmptyException
            StackEmptyException e = new StackEmptyException();
            throw e;
        }
        int temp = data[top];
        top--;
        return temp;
    }
}
------------------------------------------------------
        Create other class: StackFullException
        ----------------------------------------------
public class StackFullException extends Exception {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
}
-----------------------------------------------
        Create other class: StackEmptyException
        ----------------------------------------------
public class StackEmptyException extends Exception{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
}
---------------------------------------------

        Create other class: StackUse
        ----------------------------------------------
public class StackUse {

    public static void main(String[] args) throws StackFullException {
        StackUsingArray stack = new StackUsingArray(3);       // doubleCapacity() works

        for (int i = 0; i <= 5; i++){
            stack.push(i);
        }
        while (!stack.isEmpty()){
            try {
                System.out.println(stack.pop());
            } catch (StackEmptyException e) {
                // Never reach here
            }
        }

    }
}
----------------------------------------------
        Output:
        5
        4
        3
        2
        1
        0