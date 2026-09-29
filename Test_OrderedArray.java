public class Test_OrderedArray {
    public static void main(String[] args) {
        OrderedArray o = new OrderedArray(2);

        System.out.println("Inserting 5, 2, 9...");
        o.insert(5);
        o.insert(2);
        o.insert(9);

        System.out.println("size (capacity): " + o.size());
        System.out.println("count (used):    " + o.count());

        System.out.println("Elements in use:");
        for (int i = 0; i < o.count(); i++) {
            System.out.println("  index " + i + " -> " + o.get(i));
        }

        System.out.println("All slots (including unused/null):");
        for (int i = 0; i < o.size(); i++) {
            System.out.println("  index " + i + " -> " + o.get(i));
        }

        System.out.println();
        System.out.println("find 9: " + o.find(9));
        System.out.println("find 4 (not in array): " + o.find(4));

        System.out.println();
        System.out.println("Deleting 5...");
        boolean removed = o.delete(5);
        System.out.println("delete(5) returned: " + removed);
        System.out.println("count after delete: " + o.count());

        System.out.println("Elements in use after delete:");
        for (int i = 0; i < o.count(); i++) {
            System.out.println("  index " + i + " -> " + o.get(i));
        }

        System.out.println();
        System.out.println("Deleting 100 (not in array)...");
        boolean removedMissing = o.delete(100);
        System.out.println("delete(100) returned: " + removedMissing);
    }
}