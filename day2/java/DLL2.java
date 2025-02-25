package day2.java;

public class DLL2 implements List2 {
    private int size;

    // Reference from DLL
    private class Node {
        public Object item;
        public DLL2.Node prev;
        public DLL2.Node next;

        public Node(Object item, DLL2.Node prev, DLL2.Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }


        public Node() {
            this(0, null, null);
        }
    }

    private DLL2.Node sentinel = new DLL2.Node(-1, null, null);

    public DLL2() {
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    // Reference from DLL
    @Override
    public void add(int index, Object item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        DLL2.Node current = sentinel;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        DLL2.Node newNode = new DLL2.Node(item, current, current.next);
        current.next.prev = newNode;
        current.next = newNode;
        size++;
    }

    @Override
    public void addFirst(Object item) {
        add(0, item);
    }

    @Override
    public void addLast(Object item) {
        add(size, item);
    }

    // Reference from DLL
    @Override
    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        DLL2.Node current = sentinel.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.item;

    }

    @Override
    public Object getFirst() {
        return get(0);
    }

    @Override
    public Object getLast() {
        return sentinel.prev.item;
    }

    // Reference from DLL
    @Override
    public Object remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        DLL2.Node current = sentinel.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        Object removedObject = current.item;
        current.prev.next = current.next;
        current.next.prev = current.prev;
        size--;
        return removedObject;

    }

    @Override
    public Object removeFirst() {
        return remove(0);
    }

    @Override
    public Object removeLast() {
        DLL2.Node lastNode = sentinel.prev;
        Object removedItem = lastNode.item;

        lastNode.prev.next = sentinel;
        sentinel.prev = lastNode.prev;
        size--;

        return removedItem;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int indexOf(Object item) {
        for (int i = 0; i < size; i++) {
            if (get(i).equals(item)) {
                return i;
            }
        }
        return -1;

    }

    @Override
    public boolean contains(Object item) {
        for (int i = 0; i < size; i++) {
            if (get(i).equals(item)) {
                return true;
            }
        }
        return false;
    }

    // Reference from DLL
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        DLL2.Node current = sentinel.next;

        if (current == null) {
            return "Null";
        }

        while (current != sentinel) {
            sb.append(current.item);
            if (current.next != sentinel) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    // Reference from DLL
    public static DLL2 ArrayToDLL(Object[] arr) {
        DLL2 dll2 = new DLL2();
        for (int i = 0; i < arr.length; i++) {
            dll2.addLast(arr[i]);
        }
        return dll2;
    }

    public static void main(String[] args) {
        String[] arr = {"apple", "orange", "lemon", "melon"};
        DLL2 dll2 = ArrayToDLL(arr);
        System.out.println(dll2);

        System.out.println(dll2.size());
        System.out.println(dll2.isEmpty());

        System.out.println(dll2.indexOf("orange"));
        System.out.println(dll2.contains("lemon"));
        System.out.println(dll2.indexOf("apple"));
        System.out.println(dll2.contains("berry"));

        dll2.add(2, "tomato");
        System.out.println(dll2);

        dll2.addFirst(20);
        System.out.println(dll2);

        dll2.addLast(88.8);
        System.out.println(dll2);

        System.out.println(dll2.get(2));
        System.out.println(dll2.getFirst());
        System.out.println(dll2.getLast());

        System.out.println(dll2.remove(2));
        System.out.println(dll2);
        System.out.println(dll2.removeFirst());
        System.out.println(dll2);
        System.out.println(dll2.removeLast());
        System.out.println(dll2);
    }
}
