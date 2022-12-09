public class _9_CheckMaxHeap {
}
    Q.  Check Max-Heap
        -----------------------------------------------
        Given an array of integers, check whether it represents max-heap or not. Return true if the given array represents max-heap, else return false.
        -----------------------------------------------
        Create Project: Priority_Queue

        Create Package: default

Create class: PriorityQueueUse
        -----------------------------------------------
        Time Complexity: O(n)
        -----------------------------------------------

public class PriorityQueueUse {

    public static boolean checkMaxHeap(int arr[]) {
        for(int  i=0;i<arr.length;i++) {
            int parentIndex = i;
            int leftChildIndex = 2*i + 1;
            int rightChildIndex = 2*i + 2;

            if( leftChildIndex < arr.length && arr[parentIndex] < arr[leftChildIndex] ) {
                return false;
            }
            if( rightChildIndex < arr.length && arr[parentIndex] < arr[rightChildIndex] ) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int arr[] = {10, 9, 8, 7, 6, 5, 4, 3, 2, 7};
        System.out.println(checkMaxHeap(arr));
    }
}
--------------------------------------------
        Output:
        false
