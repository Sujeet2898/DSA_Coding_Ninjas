public class _17_MergeSort {
}
    Q.  Merge Sort
---------------
        Given a singly linked list of integers, sort it using 'Merge Sort.'
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

    public static Node<Integer> midPoint(Node<Integer> head) {

        if (head==null || head.next==null){
            return head;
        }

        Node<Integer> fast = head, slow = head;

        while(fast.next != null && fast.next.next != null){    // for odd & even
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
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

        if (t1 != null){
            tail3.next = t1;
        } else {
            tail3.next = t2;
        }

        return head3;
    }

    public static Node<Integer> mergeSort(Node<Integer> head) {

        if (head == null || head.next == null){
            return head;
        }

        Node<Integer> midNode = midPoint(head), part1Head = head, part2Head = null;

        part2Head = midNode.next;
        midNode.next = null;

        Node<Integer> head1 = mergeSort(part1Head);
        Node<Integer> head2 = mergeSort(part2Head);
        Node<Integer> newHead = mergeTwoSortedLinkedLists(head1, head2);
        return newHead;
    }

    public static void main(String args[]){
        Node<Integer> head = takeInput();
        print(mergeSort(head));
    }
}
-----------------------
        Input:
        -1

        Output:

        ---------
        Input:
        4 5 1 6 3 2 -1

        Output:
        1 2 3 4 5 6