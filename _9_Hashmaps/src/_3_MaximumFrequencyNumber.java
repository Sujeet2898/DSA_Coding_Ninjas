public class _3_MaximumFrequencyNumber {
}
    Q.  Maximum Frequency Number
        -----------------------------------------
        You are given an array of integers that contain numbers in random order. Write a program to find and return the number which occurs the maximum times in the given input.
        If two or more elements contend for the maximum frequency, return the element which occurs in the array first.
        -----------------------------------------
        Create Project: Maps

        Create Package: Default

        Create class: MapUse
        -----------------------------------------
        import java.util.HashMap;

public class MapUse {

    public static int maximumFrequency(int[] arr) {

        // Creating HasMap whose first is "integer" stored in array & second is "freuency" of interger stored in array
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i : arr) {
            if(map.containsKey(i)) {
                map.put(i, map.get(i) + 1 );    // updating frequency
            }else {
                map.put(i, 1);                  // 1 if it is single
            }
        }

        int maxFreq = 0;
        int max = Integer.MIN_VALUE;

        for(int i : arr) {
            if( maxFreq < map.get(i) ) {
                maxFreq = map.get(i);
                max = i;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int a[] = {1, 3, 2, 4, 1, 2, 2, 2, 10000, 3, 2};
        System.out.println(maximumFrequency(a));
    }
}
----------------------
        output:
        2