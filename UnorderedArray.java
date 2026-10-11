import java.util.Objects;

public class UnorderedArray<T> {

    private T[] arr;
    private int numItems;

    @SuppressWarnings("unchecked")
    private T[] createArray(int size) {
        return (T[]) new Object[size];
    }

    // O(n): creates an array of the requested size
    public UnorderedArray(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Size cannot be negative");
        }

        arr = createArray(size);
        numItems = 0;
    }

    // O(1) average; O(n) when resizing is needed
    public void insert(T x) {
        if (numItems == arr.length) {
            resize(Math.max(1, arr.length * 2));
        }

        arr[numItems] = x;
        numItems++;
    }

    // O(n): finds and removes the first matching element
    public boolean delete(T x) {
        for (int i = 0; i < numItems; i++) {
            if (Objects.equals(arr[i], x)) {
                for (int j = i; j < numItems - 1; j++) {
                    arr[j] = arr[j + 1];
                }

                arr[numItems - 1] = null;
                numItems--;
                return true;
            }
        }

        return false;
    }

    // O(n): searches for the first matching element
    public int find(T x) {
        for (int i = 0; i < numItems; i++) {
            if (Objects.equals(arr[i], x)) {
                return i;
            }
        }

        return -1;
    }

    // O(1): retrieves an element by index
    public T get(int index) {
        if (index < 0 || index >= arr.length) {
            throw new IndexOutOfBoundsException(
                    "Index " + index + " is out of bounds"
            );
        }

        return arr[index];
    }

    // O(n): creates a new array and copies the elements
    public void resize(int newSize) {
        if (newSize < 0) {
            throw new IllegalArgumentException("Size cannot be negative");
        }

        T[] newArr = createArray(newSize);
        int limit = Math.min(numItems, newSize);

        for (int i = 0; i < limit; i++) {
            newArr[i] = arr[i];
        }

        arr = newArr;
        numItems = limit;
    }

    // O(1): returns the array capacity
    public int size() {
        return arr.length;
    }

    // O(n): counts non-null elements, preserving the original behavior
    public int count() {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                count++;
            }
        }

        return count;
    }
}