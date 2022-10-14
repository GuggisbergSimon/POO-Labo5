import java.lang.reflect.Method;

abstract public class Operator
{
    abstract public Matrice operate(Matrice a, Matrice b);

    protected Matrice oper(Matrice a, Matrice b)
    {
        if (a.getModulo() != b.getModulo())
        {
            throw new RuntimeException("Les modulos ne sont pas identique dans les deux matrices");
        }

        int m = Math.max(a.getM(), b.getM());
        int n = Math.max(b.getN(), b.getN());

        int matrice[][] = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i < a.getM() && i < b.getM() && j < b.getN() && j < b.getN())
                {
                    // TODO : lire donné pour les val 0 je sais plus s'il faut faire un truc spécifique
                    matrice[i][j] = op(a.getAt(i, j), b.getAt(i, j))%a.getModulo();
                }
                else
                {
                    matrice[i][j] = 0;
                }
            }
        }

        return new Matrice(a.getModulo(), matrice);
    }

    abstract protected int op(int i, int j);
}
