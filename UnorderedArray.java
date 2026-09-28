public class UnorderedArray {

    private Integer[] arr;
    private int numItems;

    public UnorderedArray(int size){
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
