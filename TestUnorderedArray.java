public class TestUnorderedArray {

    public static void main(String[] args) {
        UnorderedArray arr = new UnorderedArray(3);

        System.out.println("--- Testing insert() and resize() ---");
        arr.insert(50);
        arr.insert(3);
        arr.insert(99);
        printArray(arr); // should be full: 50, 3, 99 (size 3)

        arr.insert(7); // array is full, should trigger resize
        printArray(arr); // should now show size 6 (doubled), with 50, 3, 99, 7

        System.out.println("\n--- Testing find() ---");
        System.out.println("find(99) -> " + arr.find(99) + " (expected 2)");
        System.out.println("find(100) -> " + arr.find(100) + " (expected -1)");

        System.out.println("\n--- Testing get() ---");
        System.out.println("get(1) -> " + arr.get(1) + " (expected 3)");
        System.out.println("get(4) -> " + arr.get(4) + " (expected null, empty slot)");
        try {
            arr.get(10); // out of bounds
            System.out.println("get(10) -> did NOT throw (this is a bug)");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("get(10) -> threw IndexOutOfBoundsException as expected");
        }

        System.out.println("\n--- Testing delete() ---");
        arr.insert(3); // duplicate 3, to test "first occurrence"
        printArray(arr);
        boolean removed = arr.delete(3);
        System.out.println("delete(3) -> " + removed + " (expected true)");
        printArray(arr); // first 3 (index 1) should be gone, second 3 should remain

        boolean removedAgain = arr.delete(1000);
        System.out.println("delete(1000) -> " + removedAgain + " (expected false, not in array)");

        System.out.println("\n--- Testing size() and count() ---");
        System.out.println("size() -> " + arr.size() + " (total capacity)");
        System.out.println("count() -> " + arr.count() + " (non-null elements)");

        System.out.println("\n--- Testing resize() directly ---");
        arr.resize(2); // shrink, should discard extra elements
        printArray(arr);
        arr.resize(5); // grow again
        printArray(arr);
    }

    private static void printArray(UnorderedArray arr) {
        // helper method, sits outside main, also already there
    }
}