public class _1_InbuiltHashmap {
}
    Create Project: Maps

        Create Package: Default

        Create class: MapUse
        -----------------------------------------
        import java.util.HashMap;
        import java.util.Set;

public class MapUse {
    public static void main(String[] args) {

        HashMap<String, Integer> map = new HashMap<>();

        // insert
        map.put("abc", 1);
        map.put("def", 2);
        map.put("abc1", 1);
        map.put("def1", 2);
        map.put("abc", 1);
        map.put("def", 2);

        // size()
        System.out.println("size: " + map.size());    // Print:- size: 4

        //check presence
        if (map.containsKey("abc")){
            System.out.println("Has abc");    // Print: Has abc
        }                                     //        Has abc
        if (map.containsKey("abc1")){
            System.out.println("Has abc");
        }

        // get Value
        int v = map.get("abc");
        System.out.println(v);       // Print: 1

        int u = 0;
        if (map.containsKey("abc2")){
            u = map.get("abc2");
        }
        System.out.println(u);       // Print: 0

        // remove
        int s = map.remove("abc");
        System.out.println(s);       // Print: 1

        // iterate
        Set<String> keys = map.keySet();    // Set<E> java.util :- uses .keySet() function
        for (String str : keys){
            System.out.println(str);    // Print: abc1
        }                               //        def2
    }                                   //        def
}
----------------------
        output:
        size: 4
        Has abc
        Has abc
        1
        0
        1
        abc1
        def1
        def