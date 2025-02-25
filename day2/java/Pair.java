package day2.java;

public class Pair<T1, T2> {
    public T1 first;
    public T2 second;

    public Pair(T1 key, T2 value) {
        this.first = key;
        this.second = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Pair<T1, T2> pair = (Pair<T1, T2>) obj;
        return first.equals(pair.first) && second.equals(pair.second);
    }

    @Override
    public String toString() {
        return "Pair(" + first + ", " + second + ")";
    }
}
