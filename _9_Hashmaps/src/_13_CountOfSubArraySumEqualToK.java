public class _13_CountOfSubArraySumEqualToK {
}
    Create Project: Maps

        Create Package: Default

        Create class: countOfsubArraySumEqualK
        ----------------------------------------------------

        import java.util.HashMap;

public class countOfsubArraySumEqualK{

    public static int subArraySumEqualK(int[] arr, int k){
        int count = 0;

        // HashMap contains sum and frequency of that sum
        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int i = -1;

        // Put frequency 1 at sum 0
        map.put(0, 1);

        while (i < arr.length - 1){
            i++;
            sum += arr[i];

            if (map.containsKey(sum - k)){
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {3,9,-2,4,1,-7,2,6,-5,8,-3,-7,6,2,1};
        System.out.println(subArraySumEqualK(arr, 5));
    }
}
----------------------
        output:
        7