public class SortEnum {

    public static void sortManufactured(Notebook[] arr) {
        int x = 0;
        for (int i = 1; i < arr.length; i++) {

            if (arr[i].price == arr[i-1].price && arr[i].amountRAM == arr[i -1].amountRAM) {
                int j = i - 1;
                Manufacturer value = arr[i].notebookMaker;
                while (j >= x && !arr[j].notebookMaker.equals(value)) {
                    arr[j + 1].notebookMaker = arr[j].notebookMaker;
                    j--;
                }
                arr[j + 1].notebookMaker = value;

            } else x = i;
        }
    }

}
