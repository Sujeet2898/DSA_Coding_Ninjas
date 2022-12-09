public class _12_EliminateDuplicatesFromLL {
}
    Q.  Eliminate duplicates from LL
---------------------------------
        You have been given a singly linked list of integers where the elements are sorted in ascending order. Write a function that removes the consecutive duplicate values such that the given list only contains unique elements and returns the head to the updated list.
        --------------------------
        Solution:
        ---------------
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

    public static void print(Node<Integer> head){

        while(head != null){
            System.out.print(head.data +" ");
            head = head.next;
        }
    }

    public static Node<Integer> removeDuplicates(Node<Integer> head) {
        //Your code goes here
        if (head==null || head.next==null) {
            return head;
        }

        Node<Integer> t2=head.next,t1=head;

        while (t2!=null) {

            if (t2.data != t1.data) {
                t1.next=t2;
                t1=t1.next;
            }

            t2=t2.next;
        }

        t1.next=t2;

        return head;
    }

    public static void main(String args[]){
        Node<Integer> head = takeInput();
        print(removeDuplicates(head));
    }
}
---------------------------------
        Input:
        -1

        Output:

        -----------
        Input:
        1 1 2 2 3 4 5 5 5 -1

        Output:
        1 2 3 4 5
        ------------
        Input:
        1 1 2 2 3 4 5 5 5 6 7 8 9 -1

        Output:
        1 2 3 4 5 6 7 8 9