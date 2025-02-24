package day2.java;

public interface List {
    //Inserts the specified element at the specified position
    void add(int index, int value);
    //Inserts the specified element at the beginning of this list
    void addFirst(int value);
    //Appends the specified element to the end of this list
    void addLast(int value);
    
    //Returns the element at the specified position in this list
    int get(int index);
    //Returns the first element in this list
    int getFirst();
    //Returns the last element in this list
    int getLast();

    // Removes the element at the specified position in this list, Shifts any subsequent elements to the left
    int remove(int index);
    //Removes and returns the first element from this list
    int removeFirst();
    //Removes and returns the last element from this list
    int removeLast();

    // Returns the number of elements in this list
    int size();
    // Returns true if this list contains no elements
    boolean isEmpty();

    // Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element
    int indexOf(int value);
    // Returns true if this list contains the specified element
    boolean contains(int value);
}
