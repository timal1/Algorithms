public class Main {
    public static void main(String[] args) {

        routeMap();

    }

    private static void routeMap() {
        Graph graph = new GraphImpl(10);
        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Рязань");
        graph.addVertex("Калуга");
        graph.addVertex("Липецк");
        graph.addVertex("Тамбов");
        graph.addVertex("Орел");
        graph.addVertex("Саратов");
        graph.addVertex("Курск");
        graph.addVertex("Воронеж");

        graph.addEdge("Москва", "Тула", 173);
        graph.addEdge("Тула", "Липецк", 295);
        graph.addEdge("Липецк", "Воронеж", 126);
        graph.addEdge("Москва", "Рязань", 218);
        graph.addEdge("Рязань", "Тамбов", 280);
        graph.addEdge("Тамбов", "Саратов", 460);
        graph.addEdge("Саратов", "Воронеж", 510);
        graph.addEdge("Москва", "Калуга", 184);
        graph.addEdge("Калуга", "Орел", 210);
        graph.addEdge("Орел", "Курск", 164);
        graph.addEdge("Курск", "Воронеж", 225);

        graph.optimalWay("Москва", "Воронеж");

    //    graph.display();
    }

}
