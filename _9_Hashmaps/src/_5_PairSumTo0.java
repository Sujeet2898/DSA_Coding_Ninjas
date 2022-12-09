public class _5_PairSumTo0 {
}
    Q.  Pair Sum to 0
        ----------------------------------------
        Given a random integer array A of size N. Find and print the count of pair of elements in the array which sum up to 0.
        Note: Array A can contain duplicate elements as well.
        ----------------------------------------
        Create Project: Maps

        Create Package: Default

        Create class: MapUse
        -----------------------------------------
        import java.util.HashMap;

public class MapUse {

    public static int PairSum(int[] input, int size) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int count = 0;

        for(int i : input) {

            if( map.containsKey(-i) ) {
                for(int j=0;j<map.get(-i);j++) {
                    count++;
                }
            }

            if(map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            }
            else {
                map.put(i, 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[] = {2, 1, -2, 2, 3};
        System.out.println(PairSum(arr, 5));
    }
}
----------------------
        output:
        2

