public class _19_RemoveLeafNodesInTree {
}
    Q.  Remove leaf nodes in Tree
        ----------------------------------------------
        Remove all leaf nodes from a given generic Tree. Leaf nodes are those nodes, which don't have any children.
        ----------------------------------------------
        Create Project: Trees

        Create Package: default

Create class: TreeNode
        ----------------------------------------------
        import java.util.ArrayList;

public class TreeNode<T> {
    public T data;
    public ArrayList<TreeNode<T>> children;

    public TreeNode(T data){
        this.data = data;
        children = new ArrayList<>();
    }
}
----------------------------------------------
        Create class: Node
        --------------------
public class Node<T> {

    T data;
    Node<T> next;

    Node(T data){
        this.data = data;
        next = null;
    }
}
----------------------------------------------

        Create class: QueueUsingLL
        ----------------------------------------------
public class QueueUsingLL<T> {

    private Node<T> front;
    private Node<T> rear;
    int size;

    public QueueUsingLL(){   // Constructor
        front = null;
        rear = null;
        size = 0;
    }

    int size(){
        return size;
    }

    boolean isEmpty(){
        return size == 0;
    }

    T front() throws QueueEmptyException {
        if (size == 0){
            throw new QueueEmptyException();
        }
        return front.data;
    }

    void enqueue(T element){
        Node<T> newNode = new Node<>(element);
        if (front == null){
            front = newNode;
            rear = newNode;
        }else{
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    T dequeue() throws QueueEmptyException {
        if (size == 0){
            throw new QueueEmptyException();
        }

        T temp = front.data;
        front = front.next;

        if (size == 1){
            rear =null;
        }
        size--;

        return temp;
    }
}
-----------------------------------------------
        Create other class: QueueEmptyException
        ----------------------------------------------
public class QueueEmptyException extends Exception{
    /**
     *
     */
    private static final long serialVersionUID = 7710094946748781333L;
}
---------------------------------------------

        Create class: TreeUse
        ----------------------------------------------
        import java.util.*;

public class TreeUse {

    public static TreeNode<Integer> takeInputLevelWise(){
        Scanner sc = new Scanner(System.in);

        //  Firstly taking rootData
        System.out.println("Enter root data");
        int rootData = sc.nextInt();

        // Creating Queue in which we store pendingNodes whose children haven't asked yet.
        QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<>();

        // Creating Node of the tree as root using rootData
        TreeNode<Integer> root = new TreeNode<Integer>(rootData);

        // Adding root into Queue as children of node hasn't asked yet
        pendingNodes.enqueue(root);

        // Work : As long as Queue is not empty
        while (!pendingNodes.isEmpty()){

            //  Handle the queueEmptyException of Queue by Try and Catch option
            try {

                // Work 1 : Removing frontNode from the Queue
                TreeNode<Integer> frontNode = pendingNodes.dequeue();

                // Work 2 : Asking number of children of frontNode.
                System.out.println("Enter num of children of " + frontNode.data);
                int numChildren = sc.nextInt();

                // Work 3 : Applying loop for taking all inputs for the number of children of frontNode
                for (int i = 0; i < numChildren; i++){
                    System.out.println("Enter " + (i + 1) + "th child of " + frontNode.data);

                    // 3.1  Taking childInput
                    int child = sc.nextInt();

                    // 3.2  Creating node for the childInput i.e childNode
                    TreeNode<Integer> childNode = new TreeNode<Integer>(child);

                    // 3.3  Linking childNode with the frontNode
                    frontNode.children.add(childNode);

                    // 3.4  Adding that childNode also into Queue as children of childNode hasn't asked yet
                    pendingNodes.enqueue(childNode);
                }
            } catch (QueueEmptyException e) {
                // Shouldn't come here
                return null;
            }
        }
        return root;
    }

    public static void printLevelWise(TreeNode<Integer> root){
        QueueUsingLL<TreeNode<Integer>> mainQueue = new QueueUsingLL<>();
        mainQueue.enqueue(root);

        QueueUsingLL<TreeNode<Integer>> childQueue = new QueueUsingLL<>();

        // Work : As long as Queue is not empty
        while (!mainQueue.isEmpty()){

            // Steps: 1. dequeue  2. print  3. enqueue
            try {
                root = mainQueue.dequeue();   // 1. dequeue
                System.out.print(root.data + " ");   // 2. print

                for (TreeNode<Integer> child: root.children){
                    childQueue.enqueue(child);  // 3. enqueue
                }

                if (mainQueue.size() == 0){
                    mainQueue = childQueue;
                    childQueue = new QueueUsingLL<>();
                    System.out.println();
                }
            } catch (QueueEmptyException e) {
                e.printStackTrace();
            }
        }
    }

    // Link: https://www.youtube.com/watch?v=0PBC_EEBHGg

    public static TreeNode<Integer> removeLeafNodes(TreeNode<Integer> root){

        // Remove in prOrder to avoid other removal as that in case of postOrder
        // 1. Firstly remove away children

        // For removing, alway use reverse loop
        for (int i = root.children.size()-1; i >= 0; i--){
            TreeNode<Integer> child = root.children.get(i);
            if (child.children.size() == 0){
                root.children.remove(child);
            }
        }

        // 2. Then remove remaining children following preOrder
        for (TreeNode<Integer> child: root.children){
            removeLeafNodes(child);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = takeInputLevelWise();
        printLevelWise(root);
        root = removeLeafNodes(root);
        printLevelWise(root);
    }
}

----------------------------------------
        Output:
        Enter root data
        1
        Enter num of children of 1
        1
        Enter 1th child of 1
        2
        Enter num of children of 2
        2
        Enter 1th child of 2
        30
        Enter 2th child of 2
        4
        Enter num of children of 30
        1
        Enter 1th child of 30
        5
        Enter num of children of 4
        1
        Enter 1th child of 4
        60
        Enter num of children of 5
        1
        Enter 1th child of 5
        70
        Enter num of children of 60
        1
        Enter 1th child of 60
        8
        Enter num of children of 70
        1
        Enter 1th child of 70
        9
        Enter num of children of 8
        1
        Enter 1th child of 8
        100
        Enter num of children of 9
        0
        Enter num of children of 100
        0
        --------------
        1
        2
        30 4
        5 60
        70 8
        9 100

        1
        2
        30 4
        5 60
        70 8 