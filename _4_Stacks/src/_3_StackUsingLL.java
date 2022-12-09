public class _3_StackUsingLL {
}
    Create Project: Stack

        Create Package: default

Create class: Node
        --------------------
public class Node<T> {

    T data;
    Node<T> next;

    Node(T data){
        this.data = data;
        next = null;
    }
}
-----------------------

        Create class: StackUsingLL
        ----------------------------------------------
public class StackUsingLL<T> {
    private Node<T> head;
    private int size;

    public StackUsingLL(){
        head = null;
        size = 0;
    }

    int size(){
        return size;
    }

    boolean isEmpty(){
        return size() == 0;  // head == null
    }

    T top() throws StackEmptyException {
        if (size() == 0) {
            // StackEmptyException e = new StackEmptyException();
            // throw e;
            throw new StackEmptyException();
        }
        return head.data;
    }

    void push(T element){
        Node<T> newNode = new Node<T>(element);
        newNode.next = head;
        head = newNode;
        size++;
    }

    T pop() throws StackEmptyException {
        if (size() == 0) {
            // StackEmptyException e = new StackEmptyException();
            // throw e;
            throw new StackEmptyException();
        }
        T tempData = head.data;;
        head = head.next;
        size--;
        return tempData;
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
        StackUsingLL<Integer> stack = new StackUsingLL<>();

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

//////////////////////////////////////////////////////////////////////////////

        Q. Code : Stack Using LL
        -------------------------
        Implement a Stack Data Structure specifically to store integer data using a Singly Linked List.

        The data members should be private.

        You need to implement the following public functions :

        1. Constructor:
        It initialises the data members as required.

        2. push(data) :
        This function should take one argument of type integer. It pushes the element into the stack and returns nothing.

        3. pop() :
        It pops the element from the top of the stack and in turn, returns the element being popped or deleted. In case the stack is empty, it returns -1.

        4. top :
        It returns the element being kept at the top of the stack. In case the stack is empty, it returns -1.

        5. size() :
        It returns the size of the stack at any given instance of time.

        6. isEmpty() :
        It returns a boolean value indicating whether the stack is empty or not.

        ---------------------------------
        Operations Performed on the Stack:
        --------------------------------------
        Query-1(Denoted by an integer 1): Pushes an integer data to the stack.

        Query-2(Denoted by an integer 2): Pops the data kept at the top of the stack and returns it to the caller.

        Query-3(Denoted by an integer 3): Fetches and returns the data being kept at the top of the stack but doesn't remove it, unlike the pop function.

        Query-4(Denoted by an integer 4): Returns the current size of the stack.

        Query-5(Denoted by an integer 5): Returns a boolean value denoting whether the stack is empty or not.
        ----------------------------------
        Solution:
        -----------
/*
    Following is the structure of the node class for a Singly Linked List

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

*/

public class Stack {

    //Define the data members
    private Node head;
    private int size;


    public Stack() {
        //Implement the Constructor
        head = null;
        size = 0;
    }



    /*----------------- Public Functions of Stack -----------------*/


    public int getSize() {
        //Implement the getSize() function
        return size;
    }

    public boolean isEmpty() {
        //Implement the isEmpty() function
        return size == 0;  // head == null
    }

    public void push(int element) {
        //Implement the push(element) function
        Node newNode=new Node(element);
        if (head==null)
        {
            head=newNode;
        }
        else
        {
            newNode.next=head;
            head=newNode;
        }
        size++;
    }

    public int pop() {
        //Implement the pop() function
        if (head==null)
        {
            size=0;
            return -1;
        }
        else
        {
            int tempData = head.data;;
            head = head.next;
            size--;
            return tempData;
        }
    }

    public int top() {
        //Implement the top() function
        if (head==null)
        {
            return -1;
        }
        else
        {
            return head.data;
        }
    }
}