public class SortPrice {

        public static void sort(Notebook[] arr) {
//  сортировка выбором
//            for (int i = 0; i < arr.length - 1; i++) {
//                int min = i;
//                int minRam = i;
//
//                for (int j = i + 1; j < arr.length; j++) {
//                    if (arr[j].price < arr[min].price) {
//                        min = j;
//                    }
//                }
//
//                if (i == min) {
//                    continue;
//                }
//
//                int temp = arr[i].price;
//                arr[i].price = arr[min].price;
//                arr[min].price = temp;
//            }


 // сортировка вставкой

            for (int i = 1; i < arr.length; i++) {

                int j = i - 1;
                int value = arr[i].price;
                while (j >= 0 && arr[j].price > value) {
                    arr[j + 1].price = arr[j].price;
                    j--;
                }
                arr[j + 1].price = value;
            }


        }
}
