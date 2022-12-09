public class _25_SwapTwoNodesOfLL {
}
    Q.  Swap two Nodes of LL
        -------------------------
        You have been given a singly linked list of integers along with two integers, 'i,' and 'j.' Swap the nodes that are present at the 'i-th' and 'j-th' positions.
        -------------------------
        Remember, the nodes themselves must be swapped and not the datas.
        ------------------------

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

    public static Node<Integer> swapNodes(Node<Integer> head, int i, int j){
        if (i == j){
            return head;
        }

        Node<Integer> temp = head, tempP = null;
        Node<Integer> P1 = null, C1 = null, P2 = null, C2 = null;

        int pos = 0;

        while (temp != null){
            if (pos == i){
                P1 = tempP;
                C1 = temp;
            } else if (pos == j){
                P2 = tempP;
                C2 = temp;
            }
            tempP = temp;
            temp = temp.next;
            pos ++;
        }

        if (P1 != null){
            P1.next = C2;
        }else {
            head = C2;
        }

        if (P2 != null){
            P2.next = C1;
        }else{
            head = C1;
        }

        Node<Integer> CurrentC1 = C2.next;
        C2.next = C1.next;
        C1.next = CurrentC1;

        return head;
    }

    public static void main(String args[]){
        Node<Integer> head = takeInput();
        head = swapNodes(head,1,3);
        print(head);
    }
}
---------------------------------
        Input:
        1 2 3 4 5 6 7 -1

        Output:
        1 4 3 2 5 6 7


        ******************************


/*
Link: https://www.youtube.com/watch?v=MiZkTndx3Uc
Question: Swapping Nodes in a Linked List (Swap Datas)
You are given the head of a linked list, and an integer k.
Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 0-indexed).
 */

        import java.util.ArrayList;
        import java.util.Scanner;

public class Solution {

    static class Node<T> {

        T data;
        Node<T> next;

        Node(T data){
            this.data = data;
            next = null;
        }
    }
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

    public static Node<Integer> swapNodes(Node<Integer> head, int k) {
        Node<Integer> t1 = head, t2 = head;
        ArrayList<Integer> arr = new ArrayList<>();

        // t1 is used during converting linkedList into Arraylist
        while (t1 != null){
            arr.add(t1.data);
            t1 = t1.next;
        }

        // Swapping in arrayList
        int i = 0, n = arr.size();
        swap(arr, k - 1, n - k);

        // t2 is used during converting ArrayList into linkedList
        while (t2 != null){
            t2.data = arr.get(i);
            t2 = t2.next;
            i++;
        }
        return head;
    }

    private static void swap(ArrayList<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    public static void main(String[] args) {
        Node<Integer> head = takeInput();
        head = swapNodes(head,2);
        print(head);
    }
}
--------------------------
        Input:
        1 2 3 4 5 -1
        Output:
        1 4 3 2 5