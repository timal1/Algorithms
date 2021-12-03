public class SortRam {
    public static void sortRam(Notebook[] arr) {
        int x = 0;
        for (int i = 1; i < arr.length; i++) {

            if (arr[i].price == arr[i-1].price) {
                    int j = i - 1;
                    int value = arr[i].amountRAM;
                    while (j >= x && arr[j].amountRAM > value) {
                        arr[j + 1].amountRAM = arr[j].amountRAM;
                        j--;
                    }
                    arr[j + 1].amountRAM = value;

            } else x = i;
        }
    }
}
