public class TestUnorderedArray {

    public static void main(String[] args) {

        // TEST 1: Integer (original Assignment 1 test)
        System.out.println("===== INTEGER TEST =====");

        UnorderedArray<Integer> arr = new UnorderedArray<>(5);

        System.out.println("Inserting 5, 2, 9...");
        arr.insert(5);
        arr.insert(2);
        arr.insert(9);

        System.out.println("Capacity: " + arr.size());
        System.out.println("Count: " + arr.count());

        for (int i = 0; i < arr.count(); i++) {
            System.out.println("Index " + i + " -> " + arr.get(i));
        }

        System.out.println("Find 9: " + arr.find(9));
        System.out.println("Find 4: " + arr.find(4));

        System.out.println("Delete 5: " + arr.delete(5));
        System.out.println("Count after deletion: " + arr.count());

        // TEST 2: String
        System.out.println();
        System.out.println("===== STRING TEST =====");

        UnorderedArray<String> names = new UnorderedArray<>(2);

        names.insert("Vina");
        names.insert("Dara");
        names.insert("Sok");

        for (int i = 0; i < names.count(); i++) {
            System.out.println("Name " + i + " -> " + names.get(i));
        }

        System.out.println("Find Dara: " + names.find("Dara"));
        System.out.println("Delete Dara: " + names.delete("Dara"));
        System.out.println("Count after deletion: " + names.count());

        // TEST 3: Double
        System.out.println();
        System.out.println("===== DOUBLE TEST =====");

        UnorderedArray<Double> prices = new UnorderedArray<>(3);

        prices.insert(10.5);
        prices.insert(20.75);
        prices.insert(5.25);

        for (int i = 0; i < prices.count(); i++) {
            System.out.println("Price " + i + " -> " + prices.get(i));
        }

        System.out.println("Find 20.75: " + prices.find(20.75));
        System.out.println("Delete 10.5: " + prices.delete(10.5));

        System.out.println("Final count: " + prices.count());
    }
}