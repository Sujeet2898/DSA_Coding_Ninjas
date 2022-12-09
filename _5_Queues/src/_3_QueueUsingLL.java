public class _3_QueueUsingLL {
}
    Create Project: Queue

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

        Create class: QueueUsingLL
        ----------------------------------------------
public class QueueUsingLL<T> {

    private Node<T> front;
    private Node<T> rear;
    int size;

    public QueueUsingLL(){   // Constructor
        front = null;
        rear = null;
        size = 0;
    }

    int size(){
        return size;
    }

    boolean isEmpty(){
        return size == 0;
    }

    T front() throws QueueEmptyException {
        if (size == 0){
            throw new QueueEmptyException();
        }
        return front.data;
    }

    void enqueue(T element){
        Node<T> newNode = new Node<>(element);
        if (front == null){
            front = newNode;
            rear = newNode;
        }else{
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    T dequeue() throws QueueEmptyException {
        if (size == 0){
            throw new QueueEmptyException();
        }

        T temp = front.data;
        front = front.next;

        if (size == 1){
            rear =null;
        }
        size--;

        return temp;
    }
}
-----------------------------------------------
        Create other class: QueueEmptyException
        ----------------------------------------------
public class QueueEmptyException extends Exception{
    /**
     *
     */
    private static final long serialVersionUID = 7710094946748781333L;
}
---------------------------------------------

        Create other class: QueueUse
        ----------------------------------------------
public class QueueUse {

    public static void main(String[] args){
        QueueUsingLL<Integer> queue = new QueueUsingLL<>();
        for (int i = 1; i <= 5; i++){
            queue.enqueue(i);
        }

        while (!queue.isEmpty()){
            try {
                System.out.println(queue.dequeue());
            } catch (QueueEmptyException e) {
                e.printStackTrace();
            }
        }
    }
}
----------------------------------------------
        Output:
        1
        2
        3
        4
        5

//////////////////////////////////////////////////////////////////////////////

        Q.  Queue using LL - Code
        -------------------------
        Implement a Queue Data Structure specifically to store integer data using a Singly Linked List.

        The data members should be private.

        You need to implement the following public functions :

        1. Constructor:
        It initialises the data members as required.

        2. enqueue(data) :
        This function should take one argument of type integer. It enqueues the element into the queue and returns nothing.

        3. dequeue() :
        It dequeues/removes the element from the front of the queue and in turn, returns the element being dequeued or removed. In case the queue is empty, it returns -1.

        4. front() :
        It returns the element being kept at the front of the queue. In case the queue is empty, it returns -1.

        5. getSize() :
        It returns the size of the queue at any given instance of time.

        6. isEmpty() :
        It returns a boolean value indicating whether the queue is empty or not.

        --------------------------------------
        Operations Performed on the Stack:
        -------------------------------------
        Query-1(Denoted by an integer 1): Enqueues an integer data to the queue.

        Query-2(Denoted by an integer 2): Dequeues the data kept at the front of the queue and returns it to the caller.

        Query-3(Denoted by an integer 3): Fetches and returns the data being kept at the front of the queue but doesn't remove it, unlike the dequeue function.

        Query-4(Denoted by an integer 4): Returns the current size of the queue.

        Query-5(Denoted by an integer 5): Returns a boolean value denoting whether the queue is empty or not.
        -------------------------
        Solution:
        ------------
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

public class Queue {

    //Define the data members
    private Node front;
    private Node rear;
    private int size;



    public Queue() {
        //Implement the Constructor
        front = null;
        rear = null;
        size = 0;
    }



    /*----------------- Public Functions of Stack -----------------*/


    public int getSize() {
        //Implement the getSize() function
        return size;
    }


    public boolean isEmpty() {
        //Implement the isEmpty() function
        return size == 0;
    }


    public void enqueue(int data) {
        //Implement the enqueue(element) function
        Node newNode = new Node(data);
        if (front == null){
            front = newNode;
            rear = newNode;
        }else{
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }


    public int dequeue() {
        //Implement the dequeue() function
        if(front != null){
            int temp = front.data;
            front = front.next;

            size--;
            return temp;
        }else{
            return -1;
        }
    }


    public int front() {
        //Implement the front() function
        if(front != null){
            return front.data;
        }else{
            return -1;
        }
    }
}