public class Notebook {
    int price;
    int amountRAM;
    Manufacturer notebookMaker;

    Notebook (int price, int amountRAM, Manufacturer notebookMaker) {
        this.price = price;
        this.amountRAM = amountRAM;
        this.notebookMaker = notebookMaker;

    }
    void printInfoNotebook() {
        System.out.println("цена " + price + " память " + amountRAM + " Изготовитель " + notebookMaker);
    }


}
