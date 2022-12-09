public class _6_HashmapImplementation {
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
        numBuckets = 20;
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

        // Attaching new Node before head
        newElementNode.next = head;

        // And attaching the bucketIndex (of buckets of ArrayList) with the new Node
        buckets.set(bucketIndex, newElementNode);
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
