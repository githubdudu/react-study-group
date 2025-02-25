package day2.java;

/*
 * Double Linked List
 */
public class DLL2<V> implements List2<V> {
    private int size;


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
        Node newNode = new Node(item, sentinel.prev, sentinel);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
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
        return sentinel.prev.item;
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
        V removedItem = sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
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
        for (int i = 0; i < size; i++) {
            if (current.item.equals(item)) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    @Override
    public boolean contains(V item) {
        // TODO: Implement this method
        return indexOf(item) != -1;
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

    public static void main(String[] args) {
        // Here we use created Pair class to test

        DLL2<Pair<Integer, String>> dll = new DLL2<>();
        dll.addLast(new Pair<>(1, "one"));
        dll.addLast(new Pair<>(2, "two"));
        dll.addLast(new Pair<>(3, "three"));
        dll.addLast(new Pair<>(4, "four"));
        dll.addLast(new Pair<>(5, "five"));
        System.out.println(dll);

        System.out.println("dll.size(): "+ dll.size());
        System.out.println("dll.isEmpty(): " + dll.isEmpty());

        System.out.println("dll.indexOf(Pair(3,\"three\")): " + dll.indexOf(new Pair<>(3, "three")));
        System.out.println("dll.contains(Pair(3,\"three\")): " + dll.contains(new Pair<>(3, "three")));
        System.out.println("dll.indexOf(Pair(10,\"ten\")): " + dll.indexOf(new Pair<>(10, "ten")));
        System.out.println("dll.contains(Pair(10,\"ten\")): " + dll.contains(new Pair<>(10, "ten")));

        System.out.println("Pair(10,\"ten\") has been added at index 2");
        dll.add(2, new Pair<>(10, "ten"));
        System.out.println(dll);

        System.out.println("Pair(20, \"twenty\") has been added at the beginning");
        dll.addFirst(new Pair<>(20, "twenty"));
        System.out.println(dll);

        System.out.println("Pair(30, \"thirty\") has been added at the end");
        dll.addLast(new Pair<>(30, "thirty"));
        System.out.println(dll);

        System.out.println("dll.get(2): " + dll.get(2));
        System.out.println("dll.getFirst(): " + dll.getFirst());
        System.out.println("dll.getLast(): " + dll.getLast());

        System.out.println("Node of index 2 has been removed");
        System.out.println(dll.remove(2));
        System.out.println(dll);
        System.out.println("First node has been removed");
        System.out.println(dll.removeFirst());
        System.out.println(dll);
        System.out.println("Last node has been removed");
        System.out.println(dll.removeLast());
        System.out.println(dll);
    }
}