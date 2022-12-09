public class _9_LongestConsecutiveSequence {
}
    Q.  Longest Consecutive Sequence
        ----------------------------------------------------
        You are given an array of unique integers that contain numbers in random order. You have to find the longest possible sequence of consecutive numbers using the numbers from given array.
        You need to return the output array which contains starting and ending element. If the length of the longest possible sequence is one, then the output array must contain only single element.
        ----------------------------------------------------
        Time Compexity: O(n)
        ----------------------------------------------------
        Create Project: Maps

        Create Package: Default

        Create class: LongestConsecutiveSequences
        ----------------------------------------------------
        import java.util.ArrayList;
        import java.util.HashMap;

public class LongestConsecutiveSequences{

    public static ArrayList<Integer> longestConsecutiveIncreasingSequence(int[] arr) {
        ArrayList<Integer> output = new ArrayList<>();
        HashMap<Integer, Boolean> map = new HashMap<>();

        // Assuming each value is start of sequence
        for (int val : arr){
            map.put(val, true);
        }

        // value is not a start of sequence if it follows pre-smaller-value
        for (int val : arr){
            if (map.containsKey(val - 1)) {
                map.put(val, false);
            }
        }

        // Finding sequence for true value (value with start of sequence)
        int maxStartPoint = 0;
        int maxLength = 0;

        for (int val : arr){
            if (map.get(val) == true){
                int tempStartPoint = val;
                int tempLength = 1;

                while (map.containsKey(tempStartPoint + tempLength)){
                    tempLength++;
                }

                if (tempLength > maxLength){
                    maxStartPoint = tempStartPoint;
                    maxLength = tempLength;
                }
            }
        }

        for (int i = 0; i < maxLength; i++){
            System.out.println(maxStartPoint + i);
        }

        output.add(maxStartPoint);
        output.add(maxStartPoint + maxLength - 1);
        return output;
    }

    public static void main(String[] args) {
        int[] arr = {9,1,8,6,3,4,2,7,10,15};
        System.out.println(longestConsecutiveIncreasingSequence(arr));
    }
}
----------------------
        output:
        6
        7
        8
        9
        10
        [6, 10]
