public class _22_GenericMethods {
}

    Create Project: Recursion

        Create Package: generics

        Create class: Print
        -----------------------
        package generics;

public class Print {
    public static<T> void printArray(T a[]){
        for (int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        Integer a[] = new Integer[10];
        for (int i = 0; i < 10; i++){
            a[i] = i + 1;
        }

        String s[] = new String[10];
        for (int i = 0; i < 10; i++){
            s[i] = "abc";
        }

        printArray(a);
        printArray(s);
    }
}
------------------------
        Output:
        1 2 3 4 5 6 7 8 9 10
        abc abc abc abc abc abc abc abc abc abc