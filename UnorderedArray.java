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

    public void insert(int x) {
        if (numItems == arr.length) {
            resize(Math.max(1, arr.length * 2));
        }

        arr[numItems] = x;
        numItems++;
    }

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

    public int find(int x) {
        for (int i = 0; i < numItems; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }


    public Integer get(int index) {
        if (index < 0 || index >= arr.length) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        }
        return arr[index];
    }

    public void resize(int newSize) {
        Integer[] newArr = new Integer[newSize];
        int limit = Math.min(numItems, newSize);
        for (int i = 0; i < limit; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
        numItems = limit;
    }
}