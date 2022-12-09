public class _8_KSmallestElements {
}
    Q.  K smallest elements
        -----------------------------------------------
        You are given with an integer k and an array of integers that contain numbers in random order. Write a program to find k smallest numbers from given array. You need to save them in an array and return it.
        Time complexity should be O(n * logk) and space complexity should not be more than O(k).
        Note: Order of elements in the output is not important.
        -----------------------------------------------
        Create Project: Priority_Queue

        Create Package: default

Create class: PriorityQueueUse
        -----------------------------------------------
        Time Complexity: O(nlogk)
        -----------------------------------------------
        import java.util.PriorityQueue;
        import java.util.ArrayList;
        import java.util.Collections;   // Max Priority Queue

public class PriorityQueueUse {

    public static ArrayList<Integer> kSmallest(int n, int[] input, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());       // Max Priority Queue

        for (int i = 0; i < input.length; i++){

            // Adding first K elements into funnel (PriorityQueue)
            if (i < k){
                pq.add(input[i]);

            }else {

                // If maxElement of funnel (PriorityQueue) is greater than the next element of K
                // then, remove the maxElement & add next element of K into funnel (PriorityQueue)
                if (input[i] < pq.peek()){
                    pq.remove();
                    pq.add(input[i]);
                }
            }
        }
        ArrayList<Integer> output = new ArrayList<>();
        // Remove & print the elements as long as funnel (PriorityQueue) is empty
        while (pq.size() > 0){
            output.add(pq.remove());
        }
        return output;
    }

    public static void main(String[] args) {
        int arr[] = {2,10,5,17,7,18,6,4};
        int k = 3;
        System.out.println(kSmallest(8,arr, k));
    }
}
--------------------------------------------
        Output:
        [5, 4, 2]
