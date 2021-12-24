public interface Graph {

    void addVertex(String label);

    boolean addEdge(String startLabel, String secondLabel, int distance);

    int getSize();

    void display();

    void optimalWay(String startLabel, String endLabel);

}
