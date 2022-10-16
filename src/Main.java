public class Main {
    public static void main(String[] args) {
        //TODO remove for final
        args = new String[]{"3", "3", "6", "2"};
        Operator operator[] = {new Plus(), new Minus(), new Mult()};

        int modulo = -5;
        System.out.println("The modulus is " + modulo + "\n");

        System.out.println("one");
        Matrice one = new Matrice(Integer.parseInt(args[0]), Integer.parseInt(args[1]), modulo);
        System.out.println(one);

        System.out.println("two");
        Matrice two = new Matrice(Integer.parseInt(args[2]), Integer.parseInt(args[3]), modulo);
        System.out.println(two);

        for (int i = 0; i < operator.length; ++i)
        {
            System.out.println("one " + operator[i].getSymbole() + " two");
            System.out.println(operator[i].operate(one, two));
        }
    }
}