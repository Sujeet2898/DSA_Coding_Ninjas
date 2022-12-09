public class _16_MergeTwoSortedLL {
}
    Q.  Merge two sorted LL
------------------------
        You have been given two sorted(in ascending order) singly linked lists of integers.
        Write a function to merge them in such a way that the resulting singly linked list is also sorted(in ascending order) and return the new head to the list.

        Note :
        Try solving this in O(1) auxiliary space.

        No need to print the list, it has already been taken care.

        ------------------------
        Solution:
        -----------

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

    public static Node<Integer> mergeTwoSortedLinkedLists(Node<Integer> head1, Node<Integer> head2) {
        Node<Integer> t1 = head1, t2 = head2, head3 = null, tail3 = null;

        if (t1.data <= t2.data){
            head3 = t1;
            tail3 = t1;
            t1 = t1.next;
        } else {
            head3 = t2;
            tail3 = t2;
            t2 = t2.next;
        }

        while (t1 != null && t2 != null){
            if (t1.data <= t2.data){
                tail3.next = t1;
                tail3 = t1;     // or tail3 = tail3.next
                t1 = t1.next;
            } else {
                tail3.next = t2;
                tail3 = t2;   // or tail3 = tail3.next
                t2 = t2.next;
            }
        }

        if (t1 != null){      // rest is also attached
            tail3.next = t1;
        } else {
            tail3.next = t2;
        }

        return head3;
    }

    public static void main(String args[]){
        Node<Integer> head1 = takeInput();
        Node<Integer> head2 = takeInput();
        Node<Integer> head3 = mergeTwoSortedLinkedLists(head1,head2);
        print(head3);
    }
}
-----------------------
        Input:
        1 3 4 -1
        2 5 6 7 8 9 -1

        Output:
        1 2 3 4 5 6 7 8 9
