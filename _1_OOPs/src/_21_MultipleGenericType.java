public class _21_MultipleGenericType {
}

    Create Project: Recursion

        Create Package: generics

        Create class: Pair
        ---------------------------
        package generics;

public class Pair<T, V> {
    private T first;
    private V second;

    public Pair(T first, V second){
        this.first = first;
        this.second = second;
    }

    public T getFirst(){
        return first;
    }
    public void setFirst(T first){
        this.first = first;
    }

    public V getSecond() {
        return second;
    }

    public void setSecond(V second) {
        this.second = second;
    }
}
----------------------------------

        Create class: PairUse
        ---------------------
        package generics;

public class PairUse {
    public static void main(String[] args){
        Pair<String, String> p = new Pair<String, String>("ab", "cd");
        p.setFirst("def");
        String s = p.getFirst();

        Pair<Integer, String> p1 = new Pair<Integer, String>(1,"temp");

        Pair<Character, Character> p2 = new Pair<>('a', 'c');

        int a = 10;
        int b = 12;
        int c = 23;

        Pair<Integer, Integer> internalPair = new Pair<>(a, b);
        Pair<Pair<Integer, Integer>, Integer> p3 = new Pair<>(internalPair, c);

        System.out.println(p3.getSecond());
        System.out.println(p3.getFirst().getFirst());
        System.out.println(p3.getFirst().getSecond());
    }
}
----------------------------
        Output:
        23
        10
        12