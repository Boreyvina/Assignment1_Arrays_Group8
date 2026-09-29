public class OrderedArray {

    private Integer[] arr;
    private int count;

    public OrderedArray(int initialSize) {
        if (initialSize < 0) {
            throw new IllegalArgumentException("Size cannot be negative: " + initialSize);
        }
        arr = new Integer[initialSize];
        count = 0;
    }

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

    public void resize(int newSize) {
        Integer[] newArr = new Integer[newSize];
        int limit = Math.min(count, newSize);
        for (int i = 0; i < limit; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
        count = limit;
    }

    public int size() {
        return arr.length;

    }

    public int count() {
        int count = 0;

        for (Integer value : arr) {
            if (value != null) {
                count++;
            }
        }

        return count;
    }
}
