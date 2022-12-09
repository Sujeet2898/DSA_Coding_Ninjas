public class _11_AppendLastNToFirst {
}
Q.  AppendLastNToFirst
        ----------------------
        You have been given a singly linked list of integers along with an integer 'N'. Write a function to append the last 'N' nodes towards the front of the singly linked list and returns the new head to the list.
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

    public static Node<Integer> appendLastNToFirst(Node<Integer> head, int n) {

        if (n == 0 || head == null){
            return head;
        }
        Node<Integer> fast = head;
        Node<Integer> slow = head;
        Node<Integer> initialHead = head;

        for (int i = 0; i < n; i++){
            fast = fast.next;
        }
        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        Node<Integer> temp = slow.next;
        slow.next = null;
        fast.next = initialHead;
        head = temp;

        return head;
    }

    public static void main(String args[]){
        Node<Integer> head = takeInput();
        print(appendLastNToFirst(head,2));
    }
}
---------------------------------
        Input:
        10 20 30 40 50 -1

        Output:
        40 50 10 20 30
