public class _7_KLargestElements {
}
    Q.  K largest Elements - Code
        -----------------------------------------------
        You are given with an integer k and an array of integers that contain numbers in random order. Write a program to find k largest numbers from given array. You need to save them in an array and return it.
        Time complexity should be O(nlogk) and space complexity should be not more than O(k).
        -----------------------------------------------
        Create Project: Priority_Queue

        Create Package: default

Create class: PriorityQueueUse
        -----------------------------------------------
        Time Complexity: O(nlogk)
        -----------------------------------------------
        import java.util.PriorityQueue;
        import java.util.ArrayList;

public class PriorityQueueUse {

    public static ArrayList<Integer> kLargest(int input[], int k){
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

        ArrayList<Integer> output = new ArrayList<>();
        // Remove & print the elements as long as funnel (PriorityQueue) is empty
        while (pq.size() > 0){
            output.add(pq.remove());
        }
        return output;
    }

    public static void main(String[] args) {
        int arr[] = {2,4,1,9,6,8};
        int k = 3;
        System.out.println(kLargest(arr, k));
    }
}
--------------------------------------------
        Output:
        [6, 8, 9]
        --------------------------------------------
        OR
        -------------------------------------------
        import java.util.PriorityQueue;

public class PriorityQueueUse {

    public static void printKLargest(int arr[], int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++){

            // Adding first K elements into funnel (PriorityQueue)
            if (i < k){
                pq.add(arr[i]);

            }else {

                // If minElement of funnel (PriorityQueue) is smaller than the next element of K
                // then, remove the minElement & add next element of K into funnel (PriorityQueue)
                if (arr[i] > pq.peek()){
                    pq.remove();
                    pq.add(arr[i]);
                }
            }
        }

        // Remove & print the elements as long as funnel (PriorityQueue) is empty
        while (pq.size() > 0){
            System.out.print(pq.remove() + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = {2,4,1,9,6,8};
        int k = 3;
        printKLargest(arr, k);
    }
}
--------------------------------------------
        Output:
        6 8 9
