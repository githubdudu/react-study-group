package day2.java;

import java.util.NoSuchElementException;

/*
 * Double Linked List
 */
public class DLL2<V> implements List2<V> {
    private int size;
    private Node tail;

    private class Node {
        public V item;
        public Node prev;
        public Node next;

        public Node(V item, Node prev, Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }

        public Node() {
            this(null, null, null);
        }
    }

    // Critical to have a sentinel node
    // can set any value other than -1
    private Node sentinel = new Node(null, null, null);

    public DLL2() {
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        tail = sentinel;
        size = 0;
    }

    @Override
    public void add(int index, V item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node current = sentinel;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        Node newNode = new Node(item, current, current.next);
        current.next.prev = newNode;
        current.next = newNode;
        size++;
    }

    @Override
    public void addFirst(V item) {
        add(0, item);
    }

    @Override
    public void addLast(V item) {
        // TODO: make this method as efficient as possible
        Node newNode = new Node(item, tail, sentinel);
        sentinel.prev = newNode;
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    @Override
    public V get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node current = sentinel.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.item;
    }

    @Override
    public V getFirst() {
        return get(0);
    }

    @Override
    public V getLast() {
        // TODO: This is not efficient, rewrite this and make it efficient
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        return tail.item;
    }

    @Override
    public V remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node current = sentinel.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        V removedItem = current.item;
        current.prev.next = current.next;
        current.next.prev = current.prev;
        size--;
        return removedItem;
    }

    @Override
    public V removeFirst() {
        return remove(0);
    }

    @Override
    public V removeLast() {
        // TODO: This is not efficient, rewrite this and make it efficient
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }

        V removedItem = tail.item;
        tail = tail.prev;
        tail.next = sentinel;
        sentinel.prev = tail;
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
    public int indexOf(V item) {
        // TODO: Implement this method
        Node current = sentinel.next;
        int index = 0;

        while (current != sentinel) {
            if (current.item == item) {
                return index;
            }
            current = current.next;
            index++;
        }

        return -1;
    }

    @Override
    public boolean contains(V item) {
        // TODO: Implement this method

        Node current = sentinel.next;

        while (current != sentinel) {
            if (current.item == item) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node current = sentinel.next;
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