public class SearchNumber {
    public static void serchNum (Integer[] arr){
        int start = 0;
        int end = arr.length -1;
        int strike;
        int i = 0;

        while (end > start ) {
            i++;
            strike = (end + start) / 2;
            if (arr[strike] - strike > 1) {
                end = strike - 1;
            } else start = strike + 1;
        }
        if (arr[start] - start > 1) {
            System.out.println(arr[start] - 1);
        } else if (arr[start - 1] - (start - 1) > 1) {
                    System.out.println(arr[start - 1] + 1);
                } else if (arr[start + 1] - (start + 1) > 1) {
                    System.out.println(arr[start + 1] - 1);
        }
        System.out.println("Итераций: " + i);
    }
}
