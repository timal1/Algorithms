public class Main {

    public static void main(String[] args) {

  //       Задание 1
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16};
        Integer[] arr1 = {1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};

        SearchNumber.serchNum(arr);
        SearchNumber.serchNum(arr1);
        System.out.println();

 //        Задание 2
        testDequeApp();
        System.out.println();

    }


    private static void testDequeApp() {

        Deque<Integer> queue = new DequeApp<>(5);


        System.out.println("add element: " + queue.insertLeft(34));
        queue.display();
        System.out.println("add element: " + queue.insertLeft(12));
        queue.display();
        System.out.println("add element: " + queue.insertLeft(20));
        queue.display();
        System.out.println("add element: " + queue.insertRight(16));
        queue.display();
        System.out.println("add element: " + queue.insertRight(14));
        queue.display();
        System.out.println("add element: " + queue.insertLeft(17));
        queue.display();
        System.out.println("remove: " + queue.removeLeft());
        queue.display();
        System.out.println("remove: " + queue.removeRight());
        queue.display();
        System.out.println("remove: " + queue.removeRight());
        queue.display();

    }


}
