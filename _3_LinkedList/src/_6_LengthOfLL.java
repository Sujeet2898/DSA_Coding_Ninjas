public class _6_LengthOfLL {
}
    Q.  Length of LL
        ------------------
        For a given singly linked list of integers, find and return its length. Do it using an iterative method.

        Remember/Consider :
        While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element.

        -------------------------------
        Solution:
        ---------
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

    public static int length(Node<Integer> head){
        int count = 0;
        Node<Integer> temp = head;
        while (temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }

    public static void main(String args[]){

        Node<Integer> head = takeInput();
        System.out.println(length(head));
    }
}
-----------------------
        Input:
        10 20 30 -1

        Output:
        3

