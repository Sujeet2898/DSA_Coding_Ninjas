public class _1_Arraylists {
}

ArrayList :  ArrayList is Dynamic version of Array. There is no need to give size in ArrayList.  ArrayList internally kept an Array in which we are storing elements and this Array continuously grow when we add more elements. Array grow to its double size. It is generic. So, we can create ArrayList of non-primitive type like Integer, Byte, Short, Long, Float, Double, String, Character, Boolean, Student, etc. We can't write primitive type i.e int, byte, short, long, float, double, boolean and char.
        ---------------------------------------------------

        Create Project: LinkedList

        Create Package: default

Create class: ArrayListDemo
        ---------------------------
        import java.util.ArrayList;

public class ArrayListDemo {

    public static void main(String[] args){

        ArrayList<Integer> list1 = new ArrayList<>();
        System.out.println(list1.size());
        list1.add(15);
        list1.add(20);
        list1.add(25);
        list1.add(2, 50);
        System.out.println(list1.size());
        System.out.println(list1.get(2));

        for (int i = 0; i < list1.size(); i++){
            System.out.print(list1.get(i) + " ");
        }

        System.out.println();

        list1.remove(1);

        for (int i = 0; i < list1.size(); i++){
            System.out.print(list1.get(i) + " ");
        }
    }
}
--------------------------------
        Output:
        0
        4
        50
        15 20 50 25
        15 50 25

        *********************************************
        import java.util.ArrayList;

public class ArrayListDemo {

    public static void main(String[] args){

        ArrayList<Integer> list1 = new ArrayList<>();
        System.out.println(list1.size());
        list1.add(15);
        list1.add(20);
        list1.add(25);
        list1.add(2, 50);

        for (int i = 0; i < list1.size(); i++){          // For Loop : Move in Indexes (Used for making changes in list)
            System.out.print(list1.get(i) + " ");
        }

        System.out.println();

        for (int element : list1){               // For Each Loop : Move in Elements  (Used for "Quick Traversal or Iteration")
            System.out.print(element + " ");
        }
    }
}
--------------------------------
        Output:
        0
        15 20 50 25
        15 20 50 25
