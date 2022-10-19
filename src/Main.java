public class Main {
    public static void main(String[] args) {
        //TODO remove for final
        args = new String[]{"4", "3", "5", "3"};
        Operator operator[] = {new Plus(), new Minus(), new Mult()};

        int modulo = 5;
        System.out.println("The modulus is " + modulo + "\n");

        System.out.println("one");
        //Matrice one = new Matrice(modulo, new int[][] {{1,3,1,1},{3,2,4,2},{1,0,1,0}});
        Matrice one = new Matrice(Integer.parseInt(args[1]), Integer.parseInt(args[0]), modulo);
        System.out.println(one);

        System.out.println("two");
        //Matrice two = new Matrice(modulo, new int[][] {{1,4,2,3,2},{0,1,0,4,2},{0,0,2,0,2}});
        Matrice two = new Matrice(Integer.parseInt(args[3]), Integer.parseInt(args[2]), modulo);
        System.out.println(two);

        for (int i = 0; i < operator.length; ++i)
        {
            System.out.println("one " + operator[i].getSymbole() + " two");
            System.out.println(operator[i].operate(one, two));
        }
    }
}