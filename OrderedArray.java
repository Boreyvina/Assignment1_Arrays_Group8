public class OrderedArray {

    private Integer[] arr;
    private int count;

    // O(n): creates an array of initialSize, all slots start as null
    public OrderedArray(int initialSize) {
        if (initialSize < 0) {
            throw new IllegalArgumentException("Size cannot be negative: " + initialSize);
        }
        arr = new Integer[initialSize];
        count = 0;
    }

    // O(n): finding the spot is a simple scan, and shifting elements right to open a gap is O(n)
    public void insert(int x) {
        if (count == arr.length) {
            resize(arr.length * 2 + 1);
        }
        int pos = 0;
        while (pos < count && arr[pos] < x) {
            pos++;
        }
        for (int i = count; i > pos; i--) {
            arr[i] = arr[i - 1];
        }
        arr[pos] = x;
        count++;
    }

    // O(n): find() is O(log n), but shifting elements left to close the gap is O(n)
    public boolean delete(int x) {
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

    // O(log n): binary search cuts the search range in half each step
    public int find(int x) {
        int low = 0;
        int high = count - 1;

        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (arr[middle] == x) {
                return middle;
            }
            if (arr[middle] < x) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return -1;
    }

    // O(1): direct array access by index
    public Integer get(int index) {
        if (index < 0 || index >= arr.length) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        }
        return arr[index];
    }

    // O(1): just reads the array length
    public int size() {
        return arr.length;
    }

    // O(n): loops through every slot to count the non-null values
    public int count() {
        int count = 0;

        for (Integer value : arr) {
            if (value != null) {
                count++;
            }
        }
        return count;
    }

    // O(n): copies up to newSize elements into a new array
    public void resize(int newSize) {
        Integer[] newArr = new Integer[newSize];
        int limit = Math.min(count, newSize);
        for (int i = 0; i < limit; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
        count = limit;
    }


}