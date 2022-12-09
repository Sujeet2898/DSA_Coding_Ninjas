public class _27_BubbleSortIterativeLinkedList {
}
    Q.  Bubble Sort (Iterative) LinkedList
--------------------------------------
        Given a singly linked list of integers, sort it using 'Bubble Sort.'
        ---------------------------------------
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

    public static int findLengthLL(Node<Integer> head) {
        int count=0;
        while(head.next!=null)
        {
            head=head.next;
            count++;
        }
        return count;
    }

    public static Node<Integer> bubbleSort(Node<Integer> head) {

        if (head==null || head.next==null)
        {
            return head;
        }
        int n=findLengthLL(head);
        Node<Integer> node1=null,node2=null,temp=null;
        int data1=0,data2=0;
        for (int i=0;i<n;i++)
        {
            node1=head;
            node2=head.next;
            for (int j=0;j<n-i;j++)
            {
                data1=node1.data;
                data2=node2.data;
                if (data1>data2)
                {
                    node1.data=data2;
                    node2.data=data1;
                }
                node1=node1.next;
                node2=node2.next;

            }
        }
        return head;
    }
    public static void main(String args[]){
        Node<Integer> head = takeInput();
        head = bubbleSort(head);
        print(head);
    }
}
---------------------------------
        Input:
        4 6 2 5 3 1 -1

        Output:
        1 2 3 4 5 6
