public class _6_SortKSortedArray {
}
    Create Project: Priority_Queue

        Create Package: default

Create class: PriorityQueueUse
        -----------------------------------------------
        Time Complexity: O(nlogk)
        -----------------------------------------------
        import java.util.PriorityQueue;

public class PriorityQueueUse {

    ppublic static void sortKSorted(int arr[], int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Adding first (K + 1) elements into funnel (PriorityQueue)
        for (int i = 0; i <= k; i++){
            pq.add(arr[i]);
        }

        // Maintaining the funnel (PriorityQueue) of k + 1 size by removing & adding one element
        for (int i = k + 1; i < arr.length; i++) {

            // Remove & print the minElement of the funnel (PriorityQueue)
            System.out.print(pq.remove() + " ");

            // Adding next element of K into funnel (PriorityQueue)
            pq.add(arr[i]);
        }

        // Remove & print the left elements of funnel (PriorityQueue)
        while (pq.size() > 0){
            System.out.print(pq.remove() + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = {2,4,1,9,6,8};
        int k = 3;
        sortKSorted(arr, k);
    }
}
}
        --------------------------------------------
        Output:
        1 2 4 6 8 9
