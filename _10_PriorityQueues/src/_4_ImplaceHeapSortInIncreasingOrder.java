public class _4_ImplaceHeapSortInIncreasingOrder {
}
Q.  Code - Implace Heap sort in increasing order
        ----------------------------------------------
        Given an integer array of size N. Sort this array (in increasing order) using heap sort.
        Note: Space complexity should be O(1).
        ----------------------------------------------
        Create Project: Priority_Queue

        Create Package: default

Create class: PriorityQueueUse
        -----------------------------------------------
        Time Complexity: O(1)
        -----------------------------------------------
public class PriorityQueueUse {

    // Insertion follows Up Heapify

    private static void insertIntoVirtualHeap(int[] arr, int i){

        // Elements are already added into array unlike heapInsert into ArrayList

        int childIndex = i;
        int parentIndex = (childIndex - 1) / 2;

        // Maintaining Max Priority Queue -> Heap Order Priority
        // Work is done till child reaches root
        while (childIndex > 0) {

            // ParentElement should be smaller than its childElement in "Min Priority Queue"
            if (arr[childIndex] > arr[parentIndex]){

                // Swapping childElement with ParentElement
                int temp = arr[childIndex];
                arr[childIndex] = arr[parentIndex];
                arr[parentIndex] = temp;

                // Now the childIndex becomes current parentIndex
                childIndex = parentIndex;
                // And calculating parentIndex again
                parentIndex = (childIndex - 1) / 2;

            } else {

                // If childElement is equal or greater than its parentElement, then we don't need swapping
                return;
            }
        }
    }

    // Deletion follows Down Heapify

    private static int removeMaxVirtualHeap(int[] arr, int heapSize){

        // Storing the root (MinElement) in temporary variable for finally returning
        int temp = arr[0];

        // Placing the lastElement at root
        arr[0] = arr[heapSize - 1];

        // Removing the lastElement by decreasing heapSize
        heapSize--;

        int index = 0;
        int maxIndex = index;
        int leftChildIndex = 1;
        int rightChildIndex = 2;

        // Maintaining Min Priority Queue -> Heap Order Priority
        // Work is done till childElement becomes leafNode i.e leftChildElement should be valid & within the range of heap
        while (leftChildIndex < heapSize){

            // LeftChildElement already exits as entry condition is the same
            if (arr[leftChildIndex] > arr[maxIndex]){
                maxIndex = leftChildIndex;
            }

            // Checking existing of rightChildElement
            if (rightChildIndex < heapSize && arr[rightChildIndex] > arr[maxIndex]){
                maxIndex = rightChildIndex;
            }

            if (maxIndex == index){

                // No swapping if Heap Order Priority is not hampered
                break;

            }else {

                // Swapping ParentElement (here, index) with ChildElement (here, maxIndex)
                int temp1 = arr[index];
                arr[index] = arr[maxIndex];
                arr[maxIndex] = temp1;

                // Now the ParentIndex becomes current ChildIndex
                index = maxIndex;
                // And calculating ChildIndex again
                leftChildIndex = 2 * index + 1;
                rightChildIndex = 2 * index + 2;
            }
        }

        // Returning the initial root (MinElement) stored in temporary variable
        return temp;
    }
--------------------------------------------------------------
    public static void main(String[] args) {

        int arr[] = {5,1,9,2,0,6};

        // Conversion of array into heap
        for (int i = 0; i < arr.length; i++){
            insertIntoVirtualHeap(arr, i);
        }
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }

        System.out.println();
        System.out.println();

        // Conversion of Heap into Sorted Heap in O(1)
        // Max Priority Queue gives Sorted Heap in increasing order
        for (int i = 0; i < arr.length; i++){
            arr[arr.length - 1 - i] = removeMaxVirtualHeap(arr, arr.length - i);
        }
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
----------------------------------------------------------
        output:
        0 1 6 5 2 9     // Conversion of array into heap

        0 1 2 5 6 9    // Conversion of Heap into Sorted Heap