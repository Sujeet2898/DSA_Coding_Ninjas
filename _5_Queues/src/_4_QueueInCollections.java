public class _4_QueueInCollections {
}
    Queue is Interface. So, we can't create object of interface. But we can create its reference and point it to the object of linked list class as linked list class implements queue.
        ---------------------------------
        Create Project: Queue

        Create Package: default

Create class: QueueCollections
        --------------------
        mport java.util.LinkedList;
        import java.util.Queue;

public class QueueCollections {

    public static void main(String[] args){

        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        System.out.println(queue.poll());   // 10 is removed and printed
        System.out.println(queue.peek());   // 20 is at the top (but not removed) and is printed
        System.out.println(queue.size());   // final size left after removing
    }
}
----------------------
        Output:
        10    // 10 is removed and printed
        20    // 20 is at the top (but not removed) and is printed
        2     // final size left after removing
