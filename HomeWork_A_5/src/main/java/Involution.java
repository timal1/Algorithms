public class Involution {

    public static void main(String[] args) {

        System.out.println(Involution.invol(4, 5));
    }

        public static int invol(int number, int degree) {
            if (degree == 0) {
                return 1;
            }
            return number * invol(number, degree - 1);
        }
    }

