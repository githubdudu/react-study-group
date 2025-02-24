package day2.java;

public interface List2<V> {
    //Inserts the specified element at the specified position
    void add(int index, V item);
    //Inserts the specified element at the beginning of this list
    void addFirst(V item);
    //Appends the specified element to the end of this list
    void addLast(V item);
    
    //Returns the element at the specified position in this list
    V get(int index);
    //Returns the first element in this list
    V getFirst();
    //Returns the last element in this list
    V getLast();

    // Removes the element at the specified position in this list, Shifts any subsequent elements to the left
    V remove(int index);
    //Removes and returns the first element from this list
    V removeFirst();
    //Removes and returns the last element from this list
    V removeLast();

    // Returns the number of elements in this list
    int size();
    // Returns true if this list contains no elements
    boolean isEmpty();

    // Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element
    int indexOf(V item);
    // Returns true if this list contains the specified element
    boolean contains(V item);
}
