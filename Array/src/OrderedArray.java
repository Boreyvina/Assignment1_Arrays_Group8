public class OrderedArray {

    // #7: Return total capacity of the array
    // Time Complexity: O(1) because it directly returns the array length.
    public int size() {
        return arr.length;
    }

    // #8: Return number of elements currently stored
    // Time Complexity: O(n) because it checks every position in the array.
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