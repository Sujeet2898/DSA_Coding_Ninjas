public class _10_KthLargestElement {
}
    Q.  Kth largest element
        -----------------------------------------------
        Given an array A of random integers and an integer k, find and return the kth largest element in the array.
        Note: Try to do this question in less than O(N * logN) time.
        -----------------------------------------------
        Create Project: Priority_Queue

        Create Package: default

Create class: PriorityQueueUse
        -----------------------------------------------
        Time Complexity: O(N * logK)
        -----------------------------------------------
        import java.util.PriorityQueue;

public class PriorityQueueUse {

    public static int kthLargest(int n, int[] input, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < input.length; i++){

            // Adding first K elements into funnel (PriorityQueue)
            if (i < k){
                pq.add(input[i]);

            }else {

                // If minElement of funnel (PriorityQueue) is smaller than the next element of K
                // then, remove the minElement & add next element of K into funnel (PriorityQueue)
                if (input[i] > pq.peek()){
                    pq.remove();
                    pq.add(input[i]);
                }
            }
        }
        return pq.remove();
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int arr[] = {10, 9, 8, 7, 6, 5, 4, 3, 2, 7};
        System.out.println(kthLargest(10, arr,3));
    }
}
--------------------------------------------
        Output:
        8
