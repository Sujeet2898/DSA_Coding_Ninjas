public class _10_PairsWithDifferenceK {
}
    Q.  Pairs with difference K
-----------------------------------------
        You are given with an array of integers and an integer K. You have to find and print the count of all such pairs which have difference K.
        Note: Take absolute difference between the elements of the array.Create Project: Maps
        -----------------------------------------
        Create Package: Default

        Create class: MapUse
        -----------------------------------------
        import java.util.HashMap;

public class MapUse {

    public static int getPairsWithDifferenceK(int arr[], int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        int pairCount = 0;
        for (int i : arr){

            // Ist way of pairing
            int pairNum1 = i + k;
            boolean isPair = false;
            if (i == pairNum1){
                isPair = true;
            }
            if (map.containsKey(pairNum1)){
                pairCount += map.get(pairNum1);
            }

            // 2nd way of pairing
            int pairNum2 = i - k;
            if (i == pairNum2){
                isPair = true;
            }
            if (map.containsKey(pairNum2)){
                pairCount += map.get(pairNum2);
            }

            if (map.containsKey(i)){
                map.put(i, map.get(i) + 1);
            }else{
                map.put(i, 1);
            }
        }

        return pairCount;
    }

    public static void main(String[] args) {
        int[] arr = {2,-1,3,5,6,0,-1,2,6};
        System.out.println(getPairsWithDifferenceK(arr,3));
    }
}
----------------------
        output:
        9
