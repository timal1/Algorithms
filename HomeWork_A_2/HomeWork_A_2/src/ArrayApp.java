public class ArrayApp {

    private static Long time;

    public static int getRandomPrice(int min, int max){
        int x = (int)((Math.random()*(max- min)+1)+min)*50;
        return x;
    }

    public static int getRandomAmountRAM(int min, int max){
        int x = (int) ((Math.random()*((max-min)+1))+min)*4;
        return x;
    }

    public static Manufacturer getEnun(int j) {
        Manufacturer[] manufacturer = Manufacturer.values();
        return manufacturer[j];
    }

    public static void startTime() {
        time = System.currentTimeMillis();
    }

    public static void endTime() {
        time = System.currentTimeMillis() - time;
        System.out.println(time);
    }


    public static void main(String[] args) {

        Notebook[] notebooks = new Notebook[5000];
        for (int i = 0; i < notebooks.length; i++) {
            notebooks[i] = new Notebook(getRandomPrice(10, 60), getRandomAmountRAM(1, 6), getEnun((int) (Math.random()*5)));
   //         notebooks[i].printInfoNotebook();
        }

        startTime();
        SortPrice.sort(notebooks);
   //     endTime();

  //      System.out.println();
 //       startTime();
        SortRam.sortRam(notebooks);
 //       endTime();

 //       System.out.println();
  //      startTime();
        SortEnum.sortManufactured(notebooks);
        endTime();

        for (int i = 0; i < notebooks.length; i++) {
            notebooks[i].printInfoNotebook();
        }
    }
}
