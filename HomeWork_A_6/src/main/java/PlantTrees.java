public class PlantTrees {

    public static void main(String[] args) {

        int levelTree = 4;
        int quantityTree = 20;
        int minValue = -25;
        int maxValue = 25;
        double unbalanced = 0.0;

        for (int i = 0; i < quantityTree; i++) {
            Tree<Integer> tree = new GrowTree<>();
            while (tree.levelTree() < levelTree) {

                tree.add((int) (Math.random() * ((maxValue - minValue) + 1) + minValue));
            }

            tree.display();

            if (tree.isBalanced(tree.getRoot())) {
                System.out.println("Дерево сбалансированно");
            } else {
                System.out.println("Дерево не сбалансированно");
                unbalanced++;
            }
        }

        System.out.println(unbalanced / quantityTree * 100 + " % деревьев не сбалансированно");
    }
}
