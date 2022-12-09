public class _23_EvenAfterOddLinkedList {
}
    Q.  Even after Odd LinkedList
-----------------------------
        For a given singly linked list of integers, arrange the elements such that all the even numbers are placed after the odd numbers. The relative order of the odd and even terms should remain unchanged.

        ---------------------------------
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
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static Node<Integer> evenAfterOdd(Node<Integer> head) {

        if (head == null || head.next == null){
            return head;
        }

        Node<Integer> temp = head, oddH = null, oddT = null, evenH = null, evenT = null;

        while(temp != null){
            int data = temp.data;

            // For Even numbers
            if (data % 2 == 0){

                if (evenH == null){   // Adding first node
                    evenH = temp;
                    evenT = temp;
                }
                else{
                    evenT.next = temp;
                    evenT = temp;
                }
            }

            // For Odd numbers
            else{

                if (oddH == null){    // Adding first node
                    oddH = temp;
                    oddT = temp;
                }
                else{
                    oddT.next = temp;
                    oddT = temp;
                }
            }

            temp = temp.next;
        }

        if (oddH == null){     // If there is no odd no, start with even no.
            return evenH;
        }
        else{
            oddT.next = evenH;    // Appending all even no. after all odd no.
        }

        if (evenT != null){
            evenT.next = null;
        }


        return oddH;
    }


    public static void main(String args[]){
        Node<Integer> head = takeInput();
        head = evenAfterOdd(head);
        print(head);
    }
}
---------------------------------
        Input:
        1 2 3 4 5 6 7 -1

        Output:
        1 3 5 7 2 4 6