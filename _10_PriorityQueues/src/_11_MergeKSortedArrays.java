public class _11_MergeKSortedArrays {
}
    Q.  Merge K sorted arrays
----------------------------------------------
        Given k different arrays, which are sorted individually (in ascending order). You need to merge all the given arrays such that output array should be sorted (in ascending order).
        Hint : Use Heaps.
        ----------------------------------------------
        Input Format:
        The first line of input contains an integer, that denotes value of k.
        The following lines of input represent k sorted arrays. Each sorted array uses two lines of input. The first line contains an integer, that denotes the size of the array. The following line contains elements of the array.
        ----------------------------------------------
        Output Format:
        The first and only line of output contains space separated elements of the merged and sorted array, as described in the task.
        ----------------------------------------------
        Create Project: Priority_Queue

        Create Package: default

Create class: PriorityQueueUse
        -----------------------------------------------
        Time Complexity: O(K * N * log(K * N))
        where K is no. of arrays to merge & N is average length of arrays
        -----------------------------------------------
        import java.util.PriorityQueue;
        import java.util.ArrayList;
        import java.util.Comparator;
        import java.util.Scanner;

public class PriorityQueueUse {

    public static class Pair implements Comparable<Pair> {
        int listIndex;
        int dataIndex;
        int value;

        Pair(int listIndex, int dataIndex, int value){
            this.listIndex = listIndex;
            this.dataIndex = dataIndex;
            this.value = value;
        }

        public int compareTo(Pair other){         // Pair1 & Pair2 are compared using interface 'Comparable'
            return this.value - other.value;      // 'this' means Pair1 & 'other' means Pair2
        }                                         // +ve ->  Pair1 > Pair2
    }                                            // -ve ->  Pair1 < Pair2
    // 0 ->  Pair1 = Pair2

    public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> input){
        ArrayList<Integer> output = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        // Adding value of '0'th index (dataIndex) of each sorted array (listIndex) into PriorityQueue
        for (int i = 0; i < input.size(); i++){
            Pair ldv = new Pair(i, 0, input.get(i).get(0));
            pq.add(ldv);
        }

        // Work is done till PriorityQueue becomes empty
        while (pq.size() > 0){

            // Remove the minElement of PriorityQueue
            Pair ldv = pq.remove();

            // And add the removedElement into the ArrayList
            output.add(ldv.value);

            // Increase the index of same removedElement of sortedArray
            ldv.dataIndex++;

            // If increaseIndex is less than size of that sortedArray,
            // then update with value of increaseIndex
            if (ldv.dataIndex < input.get(ldv.listIndex).size()){
                ldv.value = input.get(ldv.listIndex).get(ldv.dataIndex);

                // Add the updatedValue into PriorityQueue
                pq.add(ldv);
            }
        }
        return output;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int k = scn.nextInt();
        ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();
        while(k > 0) {
            int n = scn.nextInt();
            ArrayList<Integer> current = new ArrayList<Integer>();
            for(int i = 0; i < n; i++) {
                current.add(scn.nextInt());
            }
            input.add(current);
            k--;
        }
        ArrayList<Integer> output = mergeKSortedArrays(input);
        for(int i : output) {
            System.out.print(i + " ");
        }
    }
}
--------------------------------------------
        Input:
        3
        4
        10 20 30 40
        5
        5 9 12 18 32
        3
        11 15 17

        Output:
        5 9 10 11 12 15 17 18 20 30 32 40