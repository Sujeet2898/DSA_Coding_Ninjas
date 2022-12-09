public class _13_PrintReverseLinkedList {
}
    Q.  Print Reverse LinkedList
        ----------------------------
        You have been given a singly linked list of integers. Write a function to print the list in a reverse order.
        To explain it further, you need to start printing the data from the tail and move towards the head of the list, printing the head data at the end.

        Note :
        You can’t change any of the pointers in the linked list, just print it in the reverse order.
        -------------------------------
        Solution:
        ----------
        Create Project: LinkedList

        Create Package: default

Create class: Node
        -------------------
public class Node<T> {

    T data;
    Node<T> next;

    Node(T data){
        this.data = data;
        next = null;
    }
}
--------------------------

        Create class: LinkedListUse
        ---------------------------
        import java.util.Scanner;

public class LinkedListUse {

    public static Node<Integer> takeInput(){
        Node<Integer> head = null, tail= null;
        Scanner s = new Scanner(System.in);
        int data = s.nextInt();

        while (data != -1){
            Node<Integer> newNode = new Node<Integer>(data);
            if (head == null){
                head = newNode;
                tail = newNode;
            }else{
                tail.next = newNode;
                tail = newNode;   // Or tail = tail.next;
            }
            data = s.nextInt();
        }
        return head;
    }

    public static void printReverse(Node<Integer> root) {
        Node<Integer> smallOutput=printReverseRecursion(root);
    }

    public static Node<Integer> printReverseRecursion(Node<Integer> node) {
        if (node==null)
            return node;
        Node<Integer> smallOutput=printReverseRecursion(node.next);
        System.out.print(node.data+" ");
        return smallOutput;
    }

    public static void main(String args[]){
        Node<Integer> head = takeInput();
        printReverse(head);
    }
}
--------------------
        Input:
        -1

        Output:

        -------------
        Input:
        10 20 30 -1

        Output:
        30 20 10
        ------------------
        Input:
        70 -1

        Output:
        70