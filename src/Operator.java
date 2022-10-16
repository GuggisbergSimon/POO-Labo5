import java.sql.SQLOutput;

abstract public class Operator
{
    private String symbole;

    Operator(String s)
    {
        symbole = s;
    }
    abstract public Matrice operate(Matrice a, Matrice b);

    protected Matrice oper(Matrice a, Matrice b)
    {
        if (a.getModulo() != b.getModulo())
        {
            throw new RuntimeException("Les modulos ne sont pas identique dans les deux matrices");
        }

        int m = Math.max(a.getM(), b.getM());
        int n = Math.max(a.getN(), b.getN());

        //System.out.println("m=" + m + ",n=" + n);

        int matrice[][] = new int[m][n];

        try {
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    //System.out.print("i=" + i + ",j=" + j);
                    if (i < a.getM() && i < b.getM() && j < a.getN() && j < b.getN()) {
                        //System.out.print(" in ");
                        // TODO : lire donné pour les val 0 je sais plus s'il faut faire un truc spécifique
                        matrice[i][j] = Math.floorMod(op(a.at(i, j), b.at(i, j)), a.getModulo());
                        //System.out.println("a=" + a.at(i, j) + ",b=" + b.at(i, j));
                    } else if (i >= a.getM() && i < b.getM() && j < b.getN()) {
                        //System.out.print(", 1 b.at(i, j) ");
                        matrice[i][j] = Math.floorMod(op(0, b.at(i, j)), a.getModulo());
                    } else if (i >= b.getM() && i < a.getM() && j < a.getN()) {
                        //System.out.print(", 2 a.at(i, j) ");
                        matrice[i][j] = Math.floorMod(op(a.at(i, j), 0), a.getModulo());
                    } else if (j >= a.getN() && j < b.getN() && i < b.getM()) {
                        //System.out.print(", 3 b.at(i, j) ");
                        matrice[i][j] = Math.floorMod(op(0, b.at(i, j)), a.getModulo());
                    } else if (j >= b.getN() && j < a.getN() && i < a.getM()) {
                        //System.out.print(", 4 a.at(i, j) ");
                        matrice[i][j] = Math.floorMod(op(a.at(i, j), 0), a.getModulo());
                    } else {
                        matrice[i][j] = 0;
                    }
                    //System.out.println();
                }
            }
        }
        catch (Exception e)
        {
            throw new RuntimeException(e.getCause() +  " ::: Exception levée !");
        }

        return new Matrice(a.getModulo(), matrice);
    }

    abstract protected int op(int i, int j);

    public String getSymbole()
    {
        return symbole;
    }
}
