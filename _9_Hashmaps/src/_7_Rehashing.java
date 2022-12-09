public class _7_Rehashing {
}
    Create Project: Maps

        Create Pakage: Default

        Create class: MapNode
        -----------------------------------------
public class MapNode<K, V> {
    K key;
    V value;
    MapNode<K, V> next;

    // creating constructor
    public MapNode(K key, V value){
        this.key = key;
        this.value = value;
    }
}
-----------------------------------------

        Create another class: Map
        ----------------------------------------
        import java.util.ArrayList;

public class Map <K, V> {
    ArrayList<MapNode<K, V>> buckets;
    int size;
    int numBuckets;

    // We need constructor
    public Map(){
        numBuckets = 5;
        // creating everywhere null in buckets of ArrayList
        buckets = new ArrayList<>();
        for (int i = 0; i < 20; i++){
            buckets.add(null);
        }
    }

    // Implementing 4 functions:-

    private int getBucketIndex(K key){
        int hasCode =  key.hashCode();  // hasCode is already implemented anyway in the "object" class.
        return hasCode % numBuckets;   // Doing Compression
    }

    public double loadFactor(){
        return (1.0*size)/numBuckets;
    }

    private void rehash(){
        System.out.println("Rehashing: buckets" + numBuckets + " size " + size);

        // Firstly putting the ArrayList in temporary variable
        ArrayList<MapNode<K, V>> temp = buckets;

        // Same "For" loop as in constructor but twice as no. of buckets
        // creating everywhere null in new bucketArray
        buckets = new ArrayList<>();
        for (int i = 0; i < 2*numBuckets; i++){
            buckets.add(null);
        }
        size = 0;
        numBuckets *= 2;

        // Traversing each buckets of previous bucketArray
        for (int i = 0; i < temp.size(); i++){

            // Finding head of LinkedList of previous bucketArray
            MapNode<K, V> head = temp.get(i);

            // Traversing each node of LinkedList
            while (head != null){

                // Finding key and value
                K key = head.key;
                V value = head.value;

                // Inserting in new bucketArray
                insert(key, value);
                head = head.next;
            }
        }

    }

    // 1. Insert Function

    public void insert(K key, V value){

        // Ist work is to decide in which bucket, the key will go
        int bucketIndex = getBucketIndex(key);

        // Creating head for the LinkedList from the buckets
        MapNode<K, V> head = buckets.get(bucketIndex);

        // Traversing through LinkedList for finding the same key
        while (head != null){
            if (head.key.equals(key)){
                head.value = value;   // Updating the value
                return;
            }
            head = head.next;
        }

        // Again fixing the head at start if we can't find the key while traversing
        head = buckets.get(bucketIndex);

        // Creating new entryNode if we can't find the key while traversing
        MapNode<K, V> newElementNode = new MapNode<>(key, value);

        // We should increase the size while creating new Node during inserting
        size++;

        // Attaching new Node before head
        newElementNode.next = head;

        // And attaching the bucketIndex (of buckets of ArrayList) with the new Node
        buckets.set(bucketIndex, newElementNode);

        // Calculate the loadFactor after inserting
        // loadFactor = No. of elements / No. of buckets
        double loadFactor = (1.0*size)/numBuckets;

        // Rehashing
        if (loadFactor > 0.7){
            rehash();
        }
    }

    // 2. Size Function

    public int size(){
        return size;
    }

    // 3. getValue Function

    public V getValue(K key){

        // Ist work is to decide in which bucket, the key will go
        int bucketIndex = getBucketIndex(key);

        // Creating head for the LinkedList from the buckets
        MapNode<K, V> head = buckets.get(bucketIndex);

        // Traversing through LinkedList for finding the same key
        while (head != null){
            if (head.key.equals(key)){
                return head.value;  // if key is found
            }
            head = head.next;
        }
        return null;    // if key is not found
    }

    // 4. removeKey Function

    public V removeKey(K key){

        // Ist work is to decide in which bucket, the key will go
        int bucketIndex = getBucketIndex(key);

        // Creating head for the LinkedList from the buckets
        MapNode<K, V> head = buckets.get(bucketIndex);

        // Creating previous Node for the LinkedList as null
        MapNode<K, V> prev = null;

        // Traversing through LinkedList for finding the same key
        while (head != null){
            if (head.key.equals(key)){

                // Updating the size if we found the key
                size--;

                if (prev == null){
                    buckets.set(bucketIndex, head.next);    // if key is found at head Node
                }else{
                    prev.next = head.next;      // if key is found except at head Node
                }

                return head.value;    // for both
            }
            prev = head;
            head = head.next;
        }
        return null;    // if key is not found
    }
}
-----------------------------------------

        Create another class: OurMapUse
        ----------------------------------------
public class OurMapUse {
    public static void main(String[] args) {
        Map<String, Integer> map = new Map<>();

        // Rehashing
        for (int i = 0; i < 20; i++){
            map.insert("abc" + i, 1 + i);
            System.out.println("i = " + i + " lf = " + map.loadFactor());
        }

        // Delete
        map.removeKey("abc3");
        map.removeKey("abc7");

        // Searching
        for (int i = 0; i < 20; i++){
            System.out.println("abc" + i + ":" + map.getValue("abc" + i));
        }
    }
}
-----------------------------------------
        Output:
        i = 0 lf = 0.2
        i = 1 lf = 0.4
        i = 2 lf = 0.6
        Rehashing: buckets5 size 4
        i = 3 lf = 0.4
        i = 4 lf = 0.5
        i = 5 lf = 0.6
        i = 6 lf = 0.7
        Rehashing: buckets10 size 8
        i = 7 lf = 0.4
        i = 8 lf = 0.45
        i = 9 lf = 0.5
        i = 10 lf = 0.55
        i = 11 lf = 0.6
        i = 12 lf = 0.65
        i = 13 lf = 0.7
        Rehashing: buckets20 size 15
        i = 14 lf = 0.375
        i = 15 lf = 0.4
        i = 16 lf = 0.425
        i = 17 lf = 0.45
        i = 18 lf = 0.475
        i = 19 lf = 0.5
        abc0:1
        abc1:2
        abc2:3
        abc3:null
        abc4:5
        abc5:6
        abc6:7
        abc7:null
        abc8:9
        abc9:10
        abc10:11
        abc11:12
        abc12:13
        abc13:14
        abc14:15
        abc15:16
        abc16:17
        abc17:18
        abc18:19
        abc19:20