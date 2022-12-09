public class _5_TakingLLInput {
}
    Time Complexity: O(n^2)
        ++++++++++++++++++++++++

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
        Node<Integer> head = null;
        Scanner s = new Scanner(System.in);
        int data = s.nextInt();

        while (data != -1){
            Node<Integer> newNode = new Node<Integer>(data);
            if (head == null){
                head = newNode;
            }else{
                Node<Integer> temp = head;
                while (temp.next != null){
                    temp = temp.next;
                }
                temp.next = newNode;
            }
            data = s.nextInt();   // taking next data
        }
        return head;
    }

    public static void print(Node<Integer> head){

        while(head != null){
            System.out.print(head.data +" ");
            head = head.next;
        }
        System.out.println();

    }

    public static void main(String args[]){

        Node<Integer> head = takeInput();
        print(head);
    }
}
--------------------------
        Input:
        1 2 3 4 5 -1

        Output:
        1 2 3 4 5

        ******************************


        Time Complexity: O(n)
        +++++++++++++++++++++++

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
            data = s.nextInt();     // taking next data
        }
        return head;
    }

    public static void print(Node<Integer> head){

        while(head != null){
            System.out.print(head.data +" ");
            head = head.next;
        }
        System.out.println();

    }

    public static void main(String args[]){

        Node<Integer> head = takeInput();
        print(head);
    }
}
--------------------------
        Input:
        1 2 3 4 5 -1

        Output:
        1 2 3 4 5
