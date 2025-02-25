package day2.java;

/*
 * Double Linked List
 */
public class DLL2 implements List2 {
    private int size;

    private class Node {
        public int value;
        public Node prev;
        public Node next;

        public Node(int value, Node prev, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }

        public Node() {
            this(0, null, null);
        }
    }

    // Critical to have a sentinel node
    // can set any value other than -1
    private Node sentinel = new Node(-1, null, null);

    public DLL2() {
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    @Override
    public void add(int index, int value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node current = sentinel;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        Node newNode = new Node(value, current, current.next);
        current.next.prev = newNode;
        current.next = newNode;
        size++;
    }

    @Override
    public void addFirst(int value) {
        add(0, value);
    }

    @Override
    public void addLast(int value) {
        // TODO: make this method as efficient as possible
    }

    @Override
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node current = sentinel.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.value;
    }

    @Override
    public int getFirst() {
        return get(0);
    }

    @Override
    public int getLast() {
        // TODO: This is not efficient, rewrite this and make it efficient
        return get(size - 1);
    }

    @Override
    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node current = sentinel.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        int removedValue = current.value;
        current.prev.next = current.next;
        current.next.prev = current.prev;
        size--;
        return removedValue;
    }

    @Override
    public int removeFirst() {
        return remove(0);
    }

    @Override
    public int removeLast() {
        // TODO: This is not efficient, rewrite this and make it efficient
        return remove(size - 1);
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
    public int indexOf(int value) {
        // TODO: Implement this method
        return -1;
    }

    @Override
    public boolean contains(int value) {
        // TODO: Implement this method
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node current = sentinel.next;
        while (current != sentinel) {
            sb.append(current.value);
            if (current.next != sentinel) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    // Helper method to convert an array to a DLL
    public static DLL ArrayToDLL(int[] arr) {
        DLL dll = new DLL();
        for (int i = 0; i < arr.length; i++) {
            dll.addLast(arr[i]);
        }
        return dll;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        DLL dll = ArrayToDLL(arr);
        System.out.println(dll);

        System.out.println(dll.size());
        System.out.println(dll.isEmpty());

        System.out.println(dll.indexOf(3));
        System.out.println(dll.contains(3));
        System.out.println(dll.indexOf(10));
        System.out.println(dll.contains(10));

        dll.add(2, 10);
        System.out.println(dll);

        dll.addFirst(20);
        System.out.println(dll);

        dll.addLast(30);
        System.out.println(dll);

        System.out.println(dll.get(2));
        System.out.println(dll.getFirst());
        System.out.println(dll.getLast());

        System.out.println(dll.remove(2));
        System.out.println(dll);
        System.out.println(dll.removeFirst());
        System.out.println(dll);
        System.out.println(dll.removeLast());
        System.out.println(dll);
    }
}