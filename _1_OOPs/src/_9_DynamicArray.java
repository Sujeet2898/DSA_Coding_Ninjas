public class _9_DynamicArray {
}

    Create Project: Object Oriented Programming

        Create Pakage: classes_and_objects

        Create class: DynamicArray
        -----------------------------------------
        package classes_and_objects;

public class DynamicArray {
    private int data[];
    private int nextIndex;

    public DynamicArray() {      // Constructor
        data = new int[5];
        nextIndex = 0;
    }

    public int size() {
        return nextIndex;
    }

    public void add(int element) {
        if (nextIndex == data.length) {  //array is full
            restructure();
        }
        data[nextIndex] = element;    //array has space
        nextIndex++;
    }

    public void set(int index, int element) {
        if (index > nextIndex) {
            return;
        }
        if (index < nextIndex) {
            data[index] = element;
        } else {
            add(element);
        }
    }

    public int get(int index) {
        if (index >= nextIndex) {
            // error out
            return -1;
        }
        return data[index];
    }

    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int removeLast() {
        if (size() == 0) {
            //error out
            return -1;
        }
        int value = data[nextIndex - 1];
        data[nextIndex - 1] = 0;
        nextIndex--;
        return  value;
    }

    private void restructure() {
        int temp[] = data;
        data = new int[data.length * 2];
        for(int i = 0; i < temp.length; i++) {
            data[i] = temp[i];
        }
    }
}

-----------------------------------------

        Create another class: DynamicArrayUse
        ----------------------------------------
        package classes_and_objects;

public class DynamicArrayUse {

    public static void main(String[] args) {
        DynamicArray d = new DynamicArray();

        for (int i = 0; i < 100; i++) {
            d.add(i + 10);
        }

        System.out.println(d.size());

        d.set(4, 10);
        System.out.println(d.get(3));
        System.out.println(d.get(4));

        while (!d.isEmpty()) {
            System.out.println(d.removeLast());
            System.out.println("size = " + d.size());
        }
    }
}
----------------------------------------------
        output:
        100
        13
        10
        109
        size = 99
        108
        size = 98
        107
        size = 97
        106
        size = 96
        105
        size = 95
        104
        size = 94
        103
        size = 93
        102
        size = 92
        101
        size = 91
        100
        size = 90
        99
        size = 89
        98
        size = 88
        97
        size = 87
        96
        size = 86
        95
        size = 85
        94
        size = 84
        93
        size = 83
        92
        size = 82
        91
        size = 81
        90
        size = 80
        89
        size = 79
        88
        size = 78
        87
        size = 77
        86
        size = 76
        85
        size = 75
        84
        size = 74
        83
        size = 73
        82
        size = 72
        81
        size = 71
        80
        size = 70
        79
        size = 69
        78
        size = 68
        77
        size = 67
        76
        size = 66
        75
        size = 65
        74
        size = 64
        73
        size = 63
        72
        size = 62
        71
        size = 61
        70
        size = 60
        69
        size = 59
        68
        size = 58
        67
        size = 57
        66
        size = 56
        65
        size = 55
        64
        size = 54
        63
        size = 53
        62
        size = 52
        61
        size = 51
        60
        size = 50
        59
        size = 49
        58
        size = 48
        57
        size = 47
        56
        size = 46
        55
        size = 45
        54
        size = 44
        53
        size = 43
        52
        size = 42
        51
        size = 41
        50
        size = 40
        49
        size = 39
        48
        size = 38
        47
        size = 37
        46
        size = 36
        45
        size = 35
        44
        size = 34
        43
        size = 33
        42
        size = 32
        41
        size = 31
        40
        size = 30
        39
        size = 29
        38
        size = 28
        37
        size = 27
        36
        size = 26
        35
        size = 25
        34
        size = 24
        33
        size = 23
        32
        size = 22
        31
        size = 21
        30
        size = 20
        29
        size = 19
        28
        size = 18
        27
        size = 17
        26
        size = 16
        25
        size = 15
        24
        size = 14
        23
        size = 13
        22
        size = 12
        21
        size = 11
        20
        size = 10
        19
        size = 9
        18
        size = 8
        17
        size = 7
        16
        size = 6
        15
        size = 5
        10
        size = 4
        13
        size = 3
        12
        size = 2
        11
        size = 1
        10
        size = 0