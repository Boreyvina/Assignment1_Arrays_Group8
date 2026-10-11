public class OrderedArray<T extends Comparable<? super T>> {

    private T[] arr;
    private int count;

    @SuppressWarnings("unchecked")
    private T[] createArray(int size) {
        return (T[]) new Comparable[size];
    }

    // O(n): creates an array of the requested size
    public OrderedArray(int initialSize) {
        if (initialSize < 0) {
            throw new IllegalArgumentException(
                    "Size cannot be negative: " + initialSize
            );
        }

        arr = createArray(initialSize);
        count = 0;
    }

    // O(n): inserts the element in ascending order
    public void insert(T x) {
        if (count == arr.length) {
            resize(arr.length * 2 + 1);
        }

        int pos = 0;

        while (pos < count && arr[pos].compareTo(x) < 0) {
            pos++;
        }

        for (int i = count; i > pos; i--) {
            arr[i] = arr[i - 1];
        }

        arr[pos] = x;
        count++;
    }

    // O(n): binary search followed by shifting elements
    public boolean delete(T x) {
        int index = find(x);

        if (index == -1) {
            return false;
        }

        for (int i = index; i < count - 1; i++) {
            arr[i] = arr[i + 1];
        }

        arr[count - 1] = null;
        count--;
        return true;
    }

    // O(log n): binary search
    public int find(T x) {
        int low = 0;
        int high = count - 1;

        while (low <= high) {
            int middle = low + (high - low) / 2;
            int comparison = arr[middle].compareTo(x);

            if (comparison == 0) {
                return middle;
            }

            if (comparison < 0) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }

        return -1;
    }

    // O(1): direct array access by index
    public T get(int index) {
        if (index < 0 || index >= arr.length) {
            throw new IndexOutOfBoundsException(
                    "Index " + index + " is out of bounds"
            );
        }

        return arr[index];
    }

    // O(1): returns the array capacity
    public int size() {
        return arr.length;
    }

    // O(n): counts non-null elements, preserving original behavior
    public int count() {
        int total = 0;

        for (T value : arr) {
            if (value != null) {
                total++;
            }
        }

        return total;
    }

    // O(n): copies elements into a new array
    public void resize(int newSize) {
        if (newSize < 0) {
            throw new IllegalArgumentException("Size cannot be negative");
        }

        T[] newArr = createArray(newSize);
        int limit = Math.min(count, newSize);

        for (int i = 0; i < limit; i++) {
            newArr[i] = arr[i];
        }

        arr = newArr;
        count = limit;
    }
}