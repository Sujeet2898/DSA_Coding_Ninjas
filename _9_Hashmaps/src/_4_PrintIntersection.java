public class _4_PrintIntersection {
}
    Q.  Print Intersection
-----------------------------------------
        You have been given two integer arrays/lists (ARR1 and ARR2) of size N and M, respectively. You need to print their intersection; An intersection for this problem can be defined when both the arrays/lists contain a particular value or to put it in other words, when there is a common value that exists in both the arrays/lists
        -----------------------------------------
        Create Project: Maps

        Create Package: Default

        Create class: MapUse
        -----------------------------------------
        import java.util.HashMap;

public class MapUse {

    public static void printIntersection(int[] arr1, int[] arr2){

        // Creating HasMap whose first is "integer" stored in array & second is "freuency" of interger stored in array
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i : arr1) {
            if(map.containsKey(i)) {
                map.put(i, map.get(i) + 1 );    // updating frequency
            }else {
                map.put(i, 1);                  // 1 if it is single
            }
        }

        for(int i : arr2) {

            // condition for intersection
            if(map.containsKey(i) && map.get(i) > 0) {

                // if freuency is greater than 0, then there is intersection
                // print that intersection
                System.out.println(i);

                // And reduce the frequency by 1
                map.put(i, map.get(i)-1);
            }
        }
    }

    public static void main(String[] args) {
        int arr1[] ={1,4,5,2,2,3,6,5,3,2};
        int arr2[] = {0,2,3,2,6,6,5,1};
        printIntersection(arr1,arr2);
    }
}
----------------------
        output:
        2
        3
        2
        6
        5
        1