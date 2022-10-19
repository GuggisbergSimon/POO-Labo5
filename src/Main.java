import Operator.*;

public class Main {
    public static void main(String[] args) {
        //TODO remove for final
        args = new String[]{"6", "5", "4", "3"};
        //TODO : est-ce qu'on doit testé le nombre d'argument de args ? (si c'est impaire on peut pas faire 2 matrices)
        Operator operators[] = {new Plus(), new Minus(), new Mult()};

        int modulo = 5;
        System.out.println("The modulus is " + modulo + "\n");

        System.out.println("one");
        Matrice one = new Matrice(Integer.parseInt(args[0]), Integer.parseInt(args[1]), modulo);
        System.out.println(one);

        System.out.println("two");
        Matrice two = new Matrice(Integer.parseInt(args[2]), Integer.parseInt(args[3]), modulo);
        System.out.println(two);

        for (int i = 0; i < operators.length; ++i)
        {
            System.out.println("one " + operators[i].getSymbole() + " two");
            System.out.println(operators[i].operate(one, two));
        }
    }
}