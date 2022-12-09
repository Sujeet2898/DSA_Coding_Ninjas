public class _7_PrintIthNode {
}
    Q.  Print ith Node
        -------------------
        For a given a singly linked list of integers and a position 'i', print the node data at the 'i-th' position.

        Note :
        Assume that the Indexing for the singly linked list always starts from 0.

        If the given position 'i',  is greater than the length of the given singly linked list, then don't print anything.
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

    public static void printIthNode(Node<Integer> head, int i){
        int count = 0;
        Node<Integer> temp = head;
        while (temp != null && count < i){
            count++;
            temp = temp.next;
        }
        if (temp != null){
            System.out.println(temp.data);
        }
    }

    public static void main(String args[]){
        Node<Integer> head = takeInput();
        printIthNode(head, 5);
    }
}
------------------------------
        Input:
        10 20 30 40 50 60 70 -1

        Output:
        60