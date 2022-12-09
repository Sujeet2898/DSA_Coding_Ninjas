public class _2_MaxPriorityQueue {
}
Q.  Code : Max Priority Queue
        ---------------------------------------------
        Implement the class for Max Priority Queue which includes following functions -
        ---------------------------------------------
        Time Complexity: O(logn) for insert & removeMax
        O(1) for all other function
        ----------------------------------------------
        1. getSize -
        Return the size of priority queue i.e. number of elements present in the priority queue.

        2. isEmpty -
        Check if priority queue is empty or not. Return true or false accordingly.

        3. insert -
        Given an element, insert that element in the priority queue at the correct position.

        4. getMax -
        Return the maximum element present in the priority queue without deleting. Return -Infinity if priority queue is empty.

        5. removeMax -
        Delete and return the maximum element present in the priority queue. Return -Infinity if priority queue is empty.
        ----------------------------------------------
        Create Project: Priority_Queue

        Create Package: default

Create class: PQ
        ---------------------------
        import java.util.ArrayList;

public class PQ {

    private ArrayList<Integer> heap;

    // Creating constructor
    public PQ() {
        heap = new ArrayList<>();
    }

    boolean isEmpty() {
        return heap.size() == 0;
    }

    int getSize() {
        return heap.size();
    }


    int getMax() {
        if (isEmpty()){
            return Integer.MIN_VALUE;
        }
        return heap.get(0);
    }

    // Insertion follows Up Heapify

    void insert(int element) {

        // element is inserted at end of heap (ArrayList)
        heap.add(element);

        // Initially, childIndex is the last element of the heap (ArrayList)
        int childIndex = heap.size() - 1;

        int parentIndex = (childIndex - 1) / 2;

        // Maintaining Max Priority Queue -> Heap Order Priority
        // Work is done till child reaches root i.e index 0 of ArrayList
        while (childIndex > 0){

            // Comparing child & parent priority
            // ParentElement should be greater than its childElement in "Max Priority Queue"
            if (heap.get(childIndex) > heap.get(parentIndex)){

                // Swapping childElement with ParentElement
                int temp = heap.get(childIndex);
                heap.set(childIndex, heap.get(parentIndex));
                heap.set(parentIndex, temp);

                // Now the childIndex becomes current parentIndex
                childIndex = parentIndex;
                // And calculating parentIndex again
                parentIndex = (childIndex - 1) / 2;

            } else {

                // If childElement is equal or smaller than its parentElement, then we don't need swapping
                return;
            }
        }
    }

    // Deletion follows Down Heapify

    int removeMax() {

        if (isEmpty()){
            return Integer.MIN_VALUE;
        }

        // Storing the root (MaxElement) in temporary variable for finally returning
        int temp = heap.get(0);

        // Placing the lastElement at root
        heap.set(0, heap.get(heap.size() - 1));

        // Removing the lastElement as it has become same as root
        heap.remove(heap.size() - 1);

        int index = 0;
        int maxIndex = index;
        int leftChildIndex = 1;
        int rightChildIndex = 2;

        // Maintaining Max Priority Queue -> Heap Order Priority
        // Work is done till childElement becomes leafNode i.e leftChildElement should be valid & within the range of heap
        while (leftChildIndex < heap.size()){

            // LeftChildElement already exits as entry condition is the same
            if (heap.get(leftChildIndex) > heap.get(maxIndex)){
                maxIndex = leftChildIndex;
            }

            // Checking existing of rightChildElement
            if (rightChildIndex < heap.size() && heap.get(rightChildIndex) > heap.get(maxIndex)){
                maxIndex = rightChildIndex;
            }

            if (maxIndex == index){

                // No swapping if Heap Order Priority is not hampered
                break;

            } else {

                // Swapping ParentElement (here, index) with ChildElement (here, minIndex)
                int temp1 = heap.get(index);
                heap.set(index, heap.get(maxIndex));
                heap.set(maxIndex, temp1);

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
}
------------------------------------------------------------
        Create another class: PriorityQueueUse
        ----------------------------------------
public class PriorityQueueUse {

    public static void main(String[] args) throws PriorityQueueException {

        PQ priorityQueue = new PQ();
        int arr[] = {5,1,9,2,0};

        // HeapSort: 1. Inserting elements in heap
        //           2. Removing elements from heap
        //           3. And we get the elements in sorted form

        // Inserting elements in heap
        for (int i = 0; i < arr.length; i++){
            priorityQueue.insert(arr[i]);
        }

        // Removing elements from heap
        while (!priorityQueue.isEmpty()){
            System.out.print(priorityQueue.removeMin() + " ");
        }
        System.out.println();
    }
}
--------------------------------
        Output:
        9 5 2 1 0