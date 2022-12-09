public class _1_QueueUsingArray {
}
    Create Project: Queue

        Create Package: default

Create class: QueueUsingArray
        ----------------------------------------------
public class QueueUsingArray {

    private int data[];
    private int front; // index at which front element is stored
    private int rear;  // index at which rear element is stored
    int size;

    public QueueUsingArray(){   // constructor
        data = new int[10];
        front = -1;
        rear = -1;
        size = 0;
    }

    public QueueUsingArray(int capacity){
        data = new int[capacity];
        front = -1;
        rear = -1;
        size = 0;
    }

    int size(){
        return size;
    }

    boolean isEmpty(){
        return size == 0;
    }

    int front() throws QueueEmptyException {
        if (size == 0){
            throw new QueueEmptyException();
        }
        return data[front];
    }

    void enqueue(int element) throws QueueFullException {

        if (size == data.length){
            throw new QueueFullException();
        }

        if (size == 0){
            front = 0;
        }

        size++;

        rear = (rear + 1) % data.length;  // circular queue
//        OR
//        rear++;
//        if (rear == data.length){    // circular queue
//            rear = 0;
//        }

        data[rear] = element;
    }

    int dequeue() throws QueueEmptyException {
        if (size == 0){
            throw new QueueEmptyException();
        }
        int temp = data[front];

        front = (front + 1) % data.length;
//        front++;
//        if (front == data.length){
//            front = 0;
//        }
        size--;
        if (size == 0){
            front = -1;
            rear = -1;
        }
        return temp;
    }

}
------------------------------------------------------
        Create other class: QueueFullException
        ----------------------------------------------
public class QueueFullException extends Exception{
    /**
     *
     */
    private static final long serialVersionUID = 7710094946748781333L;
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
        QueueUsingArray queue = new QueueUsingArray();
        for (int i = 1; i <= 5; i++){
            try {
                queue.enqueue(i);
            } catch (QueueFullException e) {
                e.printStackTrace();
            }
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