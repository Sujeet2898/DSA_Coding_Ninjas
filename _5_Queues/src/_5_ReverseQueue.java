public class _5_ReverseQueue {
}
    Q.  Reverse Queue
-----------------
        You have been given a queue that can store integers as the data. You are required to write a function that reverses the populated queue itself without using any other data structures.
        ------------------------------------

        Create Project: Queue

        Create Package: default

Create class: QueueCollections
        --------------------------------
        import java.util.LinkedList;
        import java.util.Queue;

public class QueueCollections {

    public static void reverseQueue(Queue<Integer> input) {

        if (input.size() == 0 || input.size() == 1){
            return;
        }

        int temp = input.remove();
        reverseQueue(input);
        input.add(temp);
    }

    public static void main(String[] args){

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);
        queue.add(60);
        queue.add(70);
        queue.add(80);
        queue.add(90);
        queue.add(100);

        reverseQueue(queue);

        while (!queue.isEmpty()) {
            System.out.print( queue.peek() + ", ");
            queue.remove();
        }
    }
}
-----------------------------
        Output:
        100 90 80 70 60 50 40 30 20 10
