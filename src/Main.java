import MatriceLabo5.*;

public class Main {
    public static void main(String[] args) {
        final int NBR_ARG = 5;

        if (args.length != NBR_ARG) {
            throw new RuntimeException("nombre d'argument de args " +
                    "non valide : " + args.length + ", attendu : " + NBR_ARG);
        }

        final int MODULO = Integer.parseInt(args[4]);
        Operator[] operators = {new Plus(), new Minus(), new Mult()};

        System.out.println("The modulus is " + MODULO + "\n");

        System.out.println("one");
        Matrice one = new Matrice(MODULO, Integer.parseInt(args[0]),
                Integer.parseInt(args[1]));
        System.out.println(one);

        System.out.println("two");
        Matrice two = new Matrice(MODULO, Integer.parseInt(args[2]),
                Integer.parseInt(args[3]));
        System.out.println(two);

        for (Operator operator : operators) {
            System.out.println("one " + operator.getSymbol() + " two");
            System.out.println(operator.operate(one, two));
        }
    }
}