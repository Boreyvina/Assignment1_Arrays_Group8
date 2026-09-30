public class TestUnorderedArray {

    public static void main(String[] args) {
        UnorderedArray arr = new UnorderedArray(5);

        System.out.println("Inserting 5, 2, 9...");
        arr.insert(5);
        arr.insert(2);
        arr.insert(9);

        System.out.println("size (capacity): " + arr.size());
        System.out.println("count (used):    " + arr.count());

        System.out.println("Elements in use:");
        for (int i = 0; i < arr.count(); i++) {
            System.out.println("  index " + i + " -> " + arr.get(i));
        }

        System.out.println("All slots (including unused/null):");
        for (int i = 0; i < arr.size(); i++) {
            System.out.println("  index " + i + " -> " + arr.get(i));
        }

        System.out.println();
        System.out.println("find 9: " + arr.find(9));
        System.out.println("find 4 (not in array): " + arr.find(4));

        System.out.println();
        System.out.println("Deleting 5...");
        boolean deleted = arr.delete(5);
        System.out.println("delete(5) returned: " + deleted);
        System.out.println("count after delete: " + arr.count());

        System.out.println("Elements in use after delete:");
        for (int i = 0; i < arr.count(); i++) {
            System.out.println("  index " + i + " -> " + arr.get(i));
        }

        System.out.println();
        System.out.println("Deleting 100 (not in array)...");
        boolean deletedAgain = arr.delete(100);
        System.out.println("delete(100) returned: " + deletedAgain);
    }
}