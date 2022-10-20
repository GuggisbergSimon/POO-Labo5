import VectorialObject.Matrice;

public class Main {
    public static void main(String[] args) {
        final int NBR_ARG = 5;

        if (args.length != NBR_ARG) {
            throw new RuntimeException(
                    "nombre d'argument de args " +
                            "non valide : " + args.length +
                            ", attendu : " + NBR_ARG);
        }

        final int MODULO = Integer.parseInt(args[4]);

        System.out.println("The modulus is " + MODULO + "\n");

        System.out.println("one");
        Matrice one = new Matrice(MODULO, Integer.parseInt(args[0]),
                Integer.parseInt(args[1]));
        System.out.println(one);

        System.out.println("two");
        Matrice two = new Matrice(MODULO, Integer.parseInt(args[2]),
                Integer.parseInt(args[3]));
        System.out.println(two);

        System.out.println("one + two");
        System.out.println(one.plus(two));

        System.out.println("one - two");
        System.out.println(one.minus(two));

        System.out.println("one x two");
        System.out.println(one.multiply(two));

    }
}