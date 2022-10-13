public class Main {
    public static void main(String[] args) {
        //TODO remove for final
        args = new String[]{"4", "3", "5", "3"};

        int modulo = 5;
        System.out.println("The modulus is " + modulo);
        System.out.println();

        System.out.println("one");
        Matrice one = new Matrice(Integer.parseInt(args[1]), Integer.parseInt(args[0]), modulo);
        System.out.println(one);
        System.out.println();

        System.out.println("two");
        Matrice two = new Matrice(Integer.parseInt(args[3]), Integer.parseInt(args[2]), modulo);
        System.out.println(two);
        System.out.println();

        System.out.println("one + two");
        System.out.println();

        System.out.println("one - two");
        System.out.println();

        System.out.println("one x two");
        System.out.println();
    }
}