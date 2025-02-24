package day2.java;

/*
 * Double Linked List
 */
public class DLL implements List {
    private int size;


    private class Node {
        public int value;
        public Node prev;
        public Node next;

        public Node(int value, Node prev, Node next) {
            this.value = value;
            this.prev = null;
            this.next = null;
        }


        public Node() {
            this(0, null, null);
        }
    }

    // Critical to have a sentinel node
    // can set any value other than -1
    private Node sentinel = new Node(-1, null, null);

    public DLL() {
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
        // This is not efficient, rewrite this and make it efficient
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
        // This is not efficient, rewrite this and make it efficient
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
}