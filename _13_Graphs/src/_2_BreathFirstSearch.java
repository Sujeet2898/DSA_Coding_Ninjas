public class _2_BreathFirstSearch {
}
    Create Project: Graphs

        Create Pakage: Default

        Create class: Node
        -----------------------------------------
        Create class: Node
        -----------------------------------------
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
        Create another class: Graph
        ----------------------------------------------
        import java.util.Scanner;

public class Graph {

    public static void printDFSHelper(int edges[][], int startingVertex, boolean visited[]){
        System.out.println(startingVertex);
        visited[startingVertex] = true;
        for (int i = 0; i < edges.length; i++){
            if (edges[startingVertex][i] == 1 && !visited[i]){
                printDFSHelper(edges, i, visited);  // i become startingVertex
            }
        }
    }

    public static void print(int edges[][]){
        boolean visited[] = new boolean[edges.length];

        // Traversing each disconnected graph
        for (int i = 0; i < edges.length; i++) {
            if (!visited[i]) {
                printDFSHelper(edges, i, visited);
            }
        }
    }

    public static void printBFSHelper(int edges[][], int startingVertex, boolean visited[]){
        QueueUsingLL<Integer> queue = new QueueUsingLL<>();

        // Adding startingVertex into Queue
        queue.enqueue(startingVertex);

        // As soon as something is going into the queue, we should marked it as visited
        visited[startingVertex] = true;

        // Work : As long as Queue is not empty
        while (!queue.isEmpty()){
            int front;

            try {

                // Work 1 : Removing frontNode from the Queue
                front = queue.dequeue();

            } catch (QueueEmptyException e) {
                return;
            }

            // Work 2 : Printing the Removed frontNode
            System.out.println(front);

            // Work 3 : Adding whatever adjacent to startingVertex into the queue
            for (int i = 0; i < edges.length; i++){
                if (edges[front][i] == 1 && !visited[i]){
                    queue.enqueue(i);

                    // As soon as something is going into the queue, we should marked it as visited
                    visited[i] =true;
                }
            }
        }
    }

    public static void BFS(int edges[][]){
        boolean visited[] = new boolean[edges.length];
        for (int i = 0; i < edges.length; i++){
            if (!visited[i]){
                printBFSHelper(edges,i,visited);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int noOfVertices = scn.nextInt();
        int noOfEdges = scn.nextInt();
        int edges[][] = new int[noOfVertices][noOfVertices];  // Each cell is 0 by default

        // Taking two vertices & making edge; single edge between two vertices is denoted as 1
        for (int i = 0; i < noOfEdges; i++){
            int firstVertex = scn.nextInt();
            int secondVertex = scn.nextInt();
            edges[firstVertex][secondVertex] = 1;
            edges[secondVertex][firstVertex] = 1;
        }
        System.out.println("DFS");
        print(edges);
        System.out.println("BFS");
        BFS(edges);
    }
}

----------------------------------------------------
        Graph:
        0      3
        / \      \
        1 - 2      4
        Input:
        5
        4
        0 1
        1 2
        0 2
        3 4

        Output:
        DFS
        0
        1
        2
        3
        4
        BFS
        0
        1
        2
        3
        4
        --------------------------
        Graph:
        0
        / \
        1   2
        |   |
        3 - 4

        Input:
        5
        5
        0 1
        0 2
        1 3
        3 4
        2 4
        Output:
        DFS
        0
        1
        3
        4
        2
        BFS
        0
        1
        2
        3
        4