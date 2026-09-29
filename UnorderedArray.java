public class UnorderedArray {

    private Integer[] arr;
    private int numItems;

    public UnorderedArray(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Size cannot be negative");
        }
        arr = new Integer[size];
        numItems = 0;
    }
    // Time Complexity O(n)

    public void insert(int x) {
        if (numItems == arr.length) {
            resize(Math.max(1, arr.length * 2));
        }

        arr[numItems] = x;
        numItems++;
    }
    // Time Complexity: O(1) average, O(n) worst case

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
    // Time Complexity: O(n)

    public int find(int x) {
        for (int i = 0; i < numItems; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }
    // Time Complexity: O(n)

    public Integer get(int index) {
        if (index < 0 || index >= arr.length) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        }
        return arr[index];
    }
    // Time Complexity: O(1)

    public void resize(int newSize) {
        Integer[] newArr = new Integer[newSize];
        int limit = Math.min(numItems, newSize);
        for (int i = 0; i < limit; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
        numItems = limit;
    }
    // Time Complexity: O(n)
    public int size() {
        return arr.length;
    }
// Time Complexity: O(1)

    public int count() {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                count++;
            }
        }

        return count;
    }
// Time Complexity: O(n)
}