public class _5_InbuiltPriorityQueue {
}
    Create Project: Priority_Queue

        Create Package: default

Create class: PriorityQueueUse
        -----------------------------------------------
        Min Priority Queue
        -----------------------------------------------
        import java.util.PriorityQueue;

public class PriorityQueueUse {

    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int arr[] = {9,1,0,4,7,3};
        for (int i = 0; i < arr.length; i++){
            pq.add(arr[i]);
        }
        System.out.println(pq.element());    // peek()  print: 0

        System.out.println();

        while (!pq.isEmpty()){
            System.out.print(pq.remove() + " ");
        }
    }
}
--------------------------------------------
        Output:
        0

        0 1 3 4 7 9

        -----------------------------------------------
        Max Priority Queue
        -----------------------------------------------
        import java.util.PriorityQueue;
        import java.util.Collections;

public class PriorityQueueUse {

    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int arr[] = {9,1,0,4,7,3};
        for (int i = 0; i < arr.length; i++){
            pq.add(arr[i]);
        }
        System.out.println(pq.element());    // peek()  print: 9

        System.out.println();

        while (!pq.isEmpty()){
            System.out.print(pq.remove() + " ");
        }
    }
}
--------------------------------------------
        Output:
        9

        9 7 4 3 1 0