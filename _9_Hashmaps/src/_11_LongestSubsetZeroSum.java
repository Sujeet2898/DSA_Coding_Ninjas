public class _11_LongestSubsetZeroSum {
}
    Q.  Longest subset zero sum
----------------------------------------------------
        Given an array consisting of positive and negative integers, find the length of the longest subarray whose sum is zero.
        ----------------------------------------------------
        Create Project: Maps

        Create Package: Default

        Create class: LongestSubsetZeroSum
        ----------------------------------------------------

        import java.util.HashMap;

public class LongestSubsetZeroSum{

    public static int lengthOfLongestSubsetWithZeroSum(int arr[]){

        // HashMap contains sum and index of array
        HashMap<Integer, Integer> map = new HashMap<>();

        int maxLength = 0;
        int sum = 0;
        int i = -1;

        // Put zero-sum at -1 index i.e before arrayIndex
        map.put(sum, i);

        while (i < arr.length - 1){
            i++;
            sum += arr[i];

            // false means first time occurrence of sum at index
            if (map.containsKey(sum) == false){
                map.put(sum, i);
            }else{
                // If again same sum is found, we have to calculate length between them for knowing zero sum length
                // length = present index of sum - previous same index of sum
                int length = i - map.get(sum);

                if (length > maxLength){
                    maxLength = length;
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {2,8,-3,-5,2,-4,6,1,2,1,-3,4};
        System.out.println(lengthOfLongestSubsetWithZeroSum(arr));
    }
}
----------------------
        output:
        8