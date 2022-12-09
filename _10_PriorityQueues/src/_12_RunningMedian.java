public class _12_RunningMedian {
}
    Q.  Running Median
-----------------------------------------------
        You are given a stream of 'N' integers. For every 'i-th' integer added to the running list of integers, print the resulting median.
        Print only the integer part of the median.
        -----------------------------------------------
        Input Format :
        The first line of input contains an integer 'N', denoting the number of integers in the stream.
        The second line of input contains 'N' integers separated by a single space.
        -----------------------------------------------
        Output Format :
        Print the running median for every integer added to the running list in one line (space-separated)
        -----------------------------------------------
        Create Project: Priority_Queue

        Create Package: default

Create class: PriorityQueueUse
        -----------------------------------------------
        Time Complexity: O(N * logN)
        -----------------------------------------------
        import java.util.PriorityQueue;

public class PriorityQueueUse {

    public static void findMedian(int arr[])  {
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());  // smaller half of data
        PriorityQueue<Integer> min = new PriorityQueue<>();  // greater half of data

        for(int val : arr) {

            // add()

            // For adding in Min PriorityQueue, it should not be empty
            // And value which is going to be added must be larger than peek value
            if (min.size() > 0 && val > min.peek()) {
                min.add(val);

            } else {

                // Generally adding is done on Max PriorityQueue
                max.add(val);
            }

            // Balancing is necessary if difference of size is greater than 1
            if (max.size() - min.size() == 2) {
                min.add(max.remove());
            } else if (min.size() - max.size() == 2) {
                max.add(min.remove());
            }

            // peek()

            if(max.size() > min.size()) {
                System.out.print(max.peek() + " ");
            }
            else if(max.size() < min.size()) {
                System.out.print(min.peek() + " ");
            }
            else {
                System.out.print( (max.peek() + min.peek()) / 2 + " ");
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {6, 2, 1, 3, 7, 5};
        findMedian(arr);
    }
}
--------------------------------------------
        Output:
        6 4 2 2 3 4