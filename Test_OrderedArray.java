public class Test_OrderedArray {

    public static void main(String[] args) {

        // TEST 1: Integer
        System.out.println("===== INTEGER TEST =====");

        OrderedArray<Integer> numbers = new OrderedArray<>(2);

        numbers.insert(5);
        numbers.insert(2);
        numbers.insert(9);

        System.out.println("Capacity: " + numbers.size());
        System.out.println("Count: " + numbers.count());

        for (int i = 0; i < numbers.count(); i++) {
            System.out.println("Index " + i + " -> " + numbers.get(i));
        }

        System.out.println("Find 9: " + numbers.find(9));
        System.out.println("Find 4: " + numbers.find(4));

        System.out.println("Delete 5: " + numbers.delete(5));

        for (int i = 0; i < numbers.count(); i++) {
            System.out.println("After deletion, index " + i
                    + " -> " + numbers.get(i));
        }

        System.out.println("Delete 100: " + numbers.delete(100));

        // TEST 2: String
        System.out.println();
        System.out.println("===== STRING TEST =====");

        OrderedArray<String> names = new OrderedArray<>(2);

        names.insert("Vina");
        names.insert("Dara");
        names.insert("Sok");

        for (int i = 0; i < names.count(); i++) {
            System.out.println("Name " + i + " -> " + names.get(i));
        }

        System.out.println("Find Dara: " + names.find("Dara"));
        System.out.println("Delete Dara: " + names.delete("Dara"));

        // TEST 3: Double
        System.out.println();
        System.out.println("===== DOUBLE TEST =====");

        OrderedArray<Double> prices = new OrderedArray<>(2);

        prices.insert(5.5);
        prices.insert(2.5);
        prices.insert(8.0);

        for (int i = 0; i < prices.count(); i++) {
            System.out.println("Price " + i + " -> " + prices.get(i));
        }

        System.out.println("Find 8.0: " + prices.find(8.0));
        System.out.println("Delete 5.5: " + prices.delete(5.5));

        System.out.println("Final count: " + prices.count());
        System.out.println();
        System.out.println("===== STUDENT TEST =====");

        OrderedArray<Student> students = new OrderedArray<>(2);
        students.insert(new Student("Vina", 85));
        students.insert(new Student("Dara", 95));
        students.insert(new Student("Sok", 75));

        for (int i = 0; i < students.count(); i++) {
            System.out.println(students.get(i));
        }
    }

}
