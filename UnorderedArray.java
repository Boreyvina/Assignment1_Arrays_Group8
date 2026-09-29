public class UnorderedArray {

    private Integer[] arr;
    private int numItems;

    // O(n): creates an array of size, all slots start as null
    public UnorderedArray(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Size cannot be negative");
        }
        arr = new Integer[size];
        numItems = 0;
    }

    // O(1) average: drops x into the next free slot; O(n) worst case when resize() runs
    public void insert(int x) {
        if (numItems == arr.length) {
            resize(Math.max(1, arr.length * 2));
        }

        arr[numItems] = x;
        numItems++;
    }

    // O(n): scanning for x is O(n), and shifting the remaining elements left is O(n)
    public boolean delete(int x) {
        for (int i = 0; i < numItems; i++) {
            if (arr[i] == x) {
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

    // O(n): unordered, so every slot may need checking with no shortcut
    public int find(int x) {
        for (int i = 0; i < numItems; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }

    // O(1): array indexing jumps straight to the slot
    public Integer get(int index) {
        if (index < 0 || index >= arr.length) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        }
        return arr[index];
    }

    // O(n): allocates a new array and copies up to min(numItems, newSize) elements over
    public void resize(int newSize) {
        Integer[] newArr = new Integer[newSize];
        int limit = Math.min(numItems, newSize);
        for (int i = 0; i < limit; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
        numItems = limit;
    }

    // O(1): arr.length is stored directly, no loop needed
    public int size() {
        return arr.length;
    }

    // O(n): no running counter used here, so every slot must be checked
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