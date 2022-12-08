public class _22_TowerOfHanoi {
}

    Tower of Hanoi
        --------------
        Tower of Hanoi is a mathematical puzzle where we have three rods and n disks. The objective of the puzzle is to move all disks from source rod to destination rod using third rod (say auxiliary). The rules are :
        1) Only one disk can be moved at a time.
        2) A disk can be moved only if it is on the top of a rod.
        3) No disk can be placed on the top of a smaller disk.

        Print the steps required to move n disks from source rod to destination rod.
        Source Rod is named as 'a', auxiliary rod as 'b' and destination rod as 'c'.

        Input Format :
        Integer n

        Output Format :
        Steps in different lines (in one line print source and destination rod name separated by space)
        ---------------------------------------------


        Create Project: Recursion

        Create Package: Default

        Create class: TowerOfHanoi
        -----------------------------------------

        import java.util.Scanner;
public class TowerOfHanoi {

    public static void towerOfHanoi(int disks, char source, char auxiliary, char destination) {

        if (disks==0){
            return;
        }

        else{

            towerOfHanoi(disks-1,source,destination,auxiliary);

            System.out.println(source + " "+ destination);

            towerOfHanoi(disks-1,auxiliary,source,destination);
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        towerOfHanoi(n, 'a', 'b', 'c');
    }
}
--------------------------------------
        Input:
        1
        Output:
        a c
        ----
        Input:
        2
        Output:
        a b
        a c
        b c
        -----
        Input:
        3
        Output:
        a c
        a b
        c b
        a c
        b a
        b c
        a c

        *********************

        import java.util.*;
public class Main{

    public static void towerHanoi(int n, char s, char h, char d) {
        if (n == 1) {
            System.out.println("move 1st disk from " + s + " to " + d);
            return;
        }
        towerHanoi(n - 1, s, d, h);
        System.out.println("move " + n + "th disk from " + s + " to " + d);
        towerHanoi(n - 1, h, s, d);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        towerHanoi(n, 's', 'h', 'd');
    }
}
----------------------
        input:
        3

        output:
        move 1st disk from s to d
        move 2th disk from s to h
        move 1st disk from d to h
        move 3th disk from s to d
        move 1st disk from h to s
        move 2th disk from h to d
        move 1st disk from s to d
