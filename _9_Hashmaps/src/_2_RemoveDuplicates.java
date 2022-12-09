public class _2_RemoveDuplicates {
}
    Create Project: Maps

        Create Package: Default

        Create class: RemoveDuplicates
        -----------------------------------------
        import java.util.ArrayList;
        import java.util.HashMap;

public class RemoveDuplicates {

    public static ArrayList<Integer> removeDuplicates(int a[]){
        ArrayList<Integer> output = new ArrayList<>();

        // Creating HashMap for checking intergers as true or false
        HashMap<Integer, Boolean> seen = new HashMap<>();

        // Iterate in array
        for (int i = 0; i < a.length; i++){

            // If HasMap already contains that interger, then continue
            if (seen.containsKey(a[i])){
                continue;
            }

            // Otherwise add it into ArrayList
            output.add(a[i]);

            // If HasMap already contains that interger a[i], then we don't need to seen (true) it again
            seen.put(a[i], true);
        }

        // return ArrayList of Interger
        return output;
    }
------------------------------------------------------
    OR
-----------------------------------------------------
        import java.util.ArrayList;
import java.util.HashMap;

    public class RemoveDuplicates {

        public static ArrayList<Integer> removeDuplicates(int arr[]) {
            ArrayList<Integer> output = new ArrayList<>();
            HashMap<Integer, Boolean> map = new HashMap<>();

            // Iterate in array
            for (int i : arr) {

                // if map doesn't contain single unique integer
                if (!map.containsKey(i)) {

                    // means map contain duplicates
                    map.put(i, true);

                    // add this integer into ArrayList
                    output.add(i);
                }
            }
            return output;
        }

        public static void main(String[] args) {
            int a[] = {1, 3, 2, 4, 1, 2, 2, 2, 10000, 3, 2};
            ArrayList<Integer> output = removeDuplicates(a);

            // for (int i = 0; i < output.size(); i++){
            // System.out.println(output.get(i));
            // }

            for (int i : output) {
                System.out.println(i);
            }
        }
    }
----------------------
    output:
            1
            3
            2
            4
            10000