import java.util.*;

public class GraphImpl implements Graph{

    private final List<Vertex> vertexList;
    private final int[][] adjMatrix;
    private int allWay = 0;
    private Vertex vertexStart;
    private Vertex vertexEnd;

    public GraphImpl(int maxVertexCount) {
        this.vertexList = new ArrayList<>(maxVertexCount);
        this.adjMatrix = new int[maxVertexCount][maxVertexCount];
    }

    @Override
    public void addVertex(String label) {
        vertexList.add(new Vertex(label));
    }

    @Override
    public boolean addEdge(String startLabel, String secondLabel, int distance) {

        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(secondLabel);

        if (startIndex == -1 || endIndex == -1) {
            return false;
        }
        adjMatrix[startIndex][endIndex]  = distance;
        return true;
    }

    private int indexOf(String label) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).getLabel().equals(label)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int getSize() {
        return vertexList.size();
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getSize(); i++) {
            sb.append(vertexList.get(i));
            for (int j = 0; j < getSize(); j++) {
                if (adjMatrix[i][j] > 0) {
                    sb.append(" -> ").append(vertexList.get(j));
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public void optimalWay(String startLabel, String endLabel) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(endLabel);
        int shortWay = 0;
        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверная вершина: " + startLabel);
        } else if (endIndex == -1) {
            throw new IllegalArgumentException("Неверная вершина: " + endLabel);
        }

        Stack<Vertex> stack = new Stack<>();
        vertexStart = vertexList.get(startIndex);
        vertexEnd = vertexList.get(endIndex);
        Vertex vertexNext;

        resetVertexVisited();

        while (!allVisited()) {
            if (stack.isEmpty()){
                visitVertex(stack, vertexStart);
            }
            vertexNext = getNearUnvisitedVertex(stack.peek());

            if (vertexNext != null) {

                visitVertex(stack, vertexNext);

                if (vertexNext.equals(vertexEnd)) {
                    for (Vertex st: stack) {
                        System.out.println(st);
                    }
                    System.out.println("Длинна пути: " + allWay + " км");
                    System.out.println("----------------------------------------------");
                    System.out.println();

                    if (allWay < shortWay || shortWay == 0){
                        shortWay = allWay;
                    }
                } else {
                    vertexEnd.setVisited(false);
                }

            } else {
                stack.pop();
            }
            if (stack.isEmpty()){
                break;
            }
        }
        System.out.println("Кратчайшee растояние: " + shortWay + " км");
    }

    private Vertex getNearUnvisitedVertex(Vertex vertex) {
        int currentIndex = vertexList.indexOf(vertex);

        for (int i = 0; i < getSize(); i++) {
            if (adjMatrix[currentIndex][i] > 0 && !vertexList.get(i).isVisited()) {
                allWay += adjMatrix[currentIndex][i];
                return vertexList.get(i);
            }
                allWay -= adjMatrix[currentIndex][i];
        }
        return null;
    }

    private void resetVertexVisited() {
        for (Vertex vertex : vertexList) {
            vertex.setVisited(false);
        }
    }

    private void visitVertex(Stack<Vertex> stack, Vertex vertex) {
        stack.add(vertex);
        vertex.setVisited(true);
    }

    private boolean allVisited () {
        for (int i = 0; i < getSize(); i++) {
            if (vertexList.get(i).isVisited() == false) {
                return false;
            }
        }
          return true;
    }
    int x = 0;

}
