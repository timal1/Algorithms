import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Backpack {
    Thing[] things;
    int price;

    public Backpack(Thing[] things, int price) {
        this.things = things;
        this.price = price;
    }

    public Thing[] getThings() {
        return things;
    }

    public int getPrice() {
        return price;
    }

    //Описание состояния рюкзака
    public String getDescription() {
        return things == null ? "" : Arrays.stream(things).map(Thing::getName).collect(Collectors.joining("+")) + "-" + getPrice();
    }

    public static void main(String[] args) {

        int n = 5; //число вещей
        int k = 4; //грузоподъёмность рюкзака
        //массив вещей
        Thing[] things = {new Thing("гитара", 1, 1500),
                new Thing("бензопила", 4, 3000),
                new Thing("ноутбук", 3, 2500),
                new Thing("топор", 2, 500),
                new Thing("телефон", 1, 2000)};
        //массив промежуточных состояний рюкзака
        Backpack[][] bp = new Backpack[n + 1][k + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < k + 1; j++) {
                if (i == 0 || j == 0) { //нулевую строку и столбец заполняем нулями
                    bp[i][j] = new Backpack(new Thing[]{}, 0);
                } else if (i == 1) {
                    /*первая строка заполняется просто: первый предмет кладём или не кладём в зависимости от веса*/
                    bp[1][j] = things[0].getWeight() <= j ? new Backpack(new Thing[]{things[0]}, things[0].getPrice())
                            : new Backpack(new Thing[]{}, 0);
                } else {
                    if (things[i - 1].getWeight() > j) //если очередной предмет не влезает в рюкзак,
                        bp[i][j] = bp[i - 1][j];    //записываем предыдущий максимум
                    else {
                        /*рассчитаем цену очередного предмета + максимальную цену для (максимально возможный для рюкзака вес − вес предмета)*/
                        int newPrice = things[i - 1].getPrice() + bp[i - 1][j - things[i - 1].getWeight()].getPrice();
                        if (bp[i - 1][j].getPrice() > newPrice) //если предыдущий максимум больше
                            bp[i][j] = bp[i - 1][j]; //запишем его
                        else {
                            /*иначе фиксируем новый максимум: текущий предмет + стоимость свободного пространства*/
                            bp[i][j] = new Backpack(Stream.concat(Arrays.stream(new Thing[]{things[i - 1]}),
                                    Arrays.stream(bp[i - 1][j - things[i - 1].getWeight()].getThings())).toArray(Thing[]::new), newPrice);
                        }
                    }
                }
            }
        }

        List<Backpack> lastColumn = Arrays.stream(bp).map(row -> row[row.length - 1]).collect(Collectors.toList());


        Backpack backpackWithMax = lastColumn.stream().max(Comparator.comparing(Backpack::getPrice)).orElse(new Backpack(null, 0));


        System.out.println(backpackWithMax.getDescription());
    }
}

class Thing  {
    private String name;
    private int weight;
    private int price;

    public Thing( String name, int weight, int price) {
        this.name = name;
        this.weight = weight;
        this.price = price;

    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }

}

