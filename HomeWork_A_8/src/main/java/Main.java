public class Main {

    public static void main(String[] args) {
        var hashTable = new HashTableImpl<>(6);
//
        hashTable.put(new Product(1, "Orange"), 150);
        hashTable.put(new Product(72, "Banana"), 100);
        hashTable.put(new Product(68, "Carrot"), 228);
        hashTable.put(new Product(67, "Lemon"), 250);
        hashTable.put(new Product(50, "Milk"), 120);
        hashTable.put(new Product(23, "Potato"), 67);
//
        System.out.println("Size is " + hashTable.size());
        hashTable.display();

        System.out.println("Cost potato is " + hashTable.get(new Product(23, "Potato")));
        System.out.println("Cost banana is " + hashTable.get(new Product(72, "Banana")));
        System.out.println("Cost carrot is " + hashTable.get(new Product(68, "Carrot")));
        System.out.println();

        System.out.println("Удалили " + hashTable.remove(new Product(23, "Potato")));
        System.out.println("Удалили " + hashTable.remove(new Product(72, "Banana")));
        System.out.println();

        System.out.println("Cost potato is " + hashTable.get(new Product(23, "Potato")));
        System.out.println("Cost banana is " + hashTable.get(new Product(72, "Banana")));
        System.out.println("Cost carrot is " + hashTable.get(new Product(68, "Carrot")));

        hashTable.display();

        hashTable.put(new Product(47, "Pineapple"), 228);
        hashTable.put(new Product(68, "Carrot"), 555);
        hashTable.put(new Product(12, "Apple"), 29);
        hashTable.put(new Product(68, "Carrot"), 555);

        System.out.println("Удалили " + hashTable.remove(new Product(50, "Milk")));

        hashTable.display();
    }
}
