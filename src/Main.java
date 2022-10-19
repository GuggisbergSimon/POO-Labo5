import MatriceLabo5.*;

public class Main {
    public static void main(String[] args) {

        if (args.length != 4)
        {
            throw new RuntimeException("nombre d'argument de args non valide : " + args.length + ", attendu : 4");
        }

        Operator operators[] = {new Plus(), new Minus(), new Mult()};

        final int MODULO = 5;
        System.out.println("The modulus is " + MODULO + "\n");

        System.out.println("one");
        Matrice one = new Matrice(Integer.parseInt(args[0]), Integer.parseInt(args[1]), MODULO);
        System.out.println(one);

        System.out.println("two");
        Matrice two = new Matrice(Integer.parseInt(args[2]), Integer.parseInt(args[3]), MODULO);
        System.out.println(two);

        for (int i = 0; i < operators.length; ++i)
        {
            System.out.println("one " + operators[i].getSymbole() + " two");
            System.out.println(operators[i].operate(one, two));
        }
    }
}