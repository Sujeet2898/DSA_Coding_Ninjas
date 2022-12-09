public class _6_ReverseFirstKElementsInQueue {
}
    Q.  Reverse the First K Elements in the Queue
----------------------------------------------
        For a given queue containing all integer data, reverse the first K elements.

        You have been required to make the desired change in the input queue itself.
        ----------------------------------------------

        Create Project: Stack

        Create Package: default

Create class: QueueCollections
        --------------------------------
        import java.util.LinkedList;
        import java.util.Queue;

public class QueueCollections {

    public static Queue<Integer> reverseKElements(Queue<Integer> input, int k){

        if (input.size() > k){
            k = k % input.size();
        }

        if (k == 0 || k == 1){
            return input;
        }

        reverseQueue(input, k);

        for (int i = 0; i < input.size() - k; i++){   // n - k
            input.add(input.remove());
        }

        return input;

    }

    public static void reverseQueue(Queue<Integer> input, int k){

        if (input.size() == 0 || input.size() == 1 || k == 0){
            return;
        }

        int temp=input.remove();
        reverseQueue(input, k - 1);
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

        reverseKElements(queue, 6);
        while (!queue.isEmpty()) {
            System.out.print( queue.peek() + " ");
            queue.remove();
        }
    }
}
----------------------------
        Output:
        60 50 40 30 20 10 70 80 90 100  