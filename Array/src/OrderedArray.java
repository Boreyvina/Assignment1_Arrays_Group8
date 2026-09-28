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
            resize(Math.max(1, arr.length * 2));
        }

        int low = 0, high = count;
        while (low < high) {
            int mid = (low + high) >>> 1;
            if (arr[mid] <= x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        for (int i = count; i > low; i--) {
            arr[i] = arr[i - 1];
        }
        arr[low] = x;
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

}