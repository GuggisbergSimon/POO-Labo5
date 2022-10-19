package Operator;

abstract public class Operator {
    private String symbole;

    Operator(String s) {
        symbole = s;
    }

    public Matrice operate(Matrice a, Matrice b) {
        if (a.getModulo() != b.getModulo()) {
            throw new RuntimeException("Les modulos ne sont pas identique dans les deux matrices");
        }

        int m = Math.max(a.getM(), b.getM());
        int n = Math.max(a.getN(), b.getN());

        int matrice[][] = new int[m][n];

        try {
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    int tmpA = i < a.getM() && j < a.getN() ? a.at(i, j) : 0;
                    int tmpB = i < b.getM() && j < b.getN() ? b.at(i, j) : 0;
                    matrice[i][j] = Math.floorMod(op(tmpA, tmpB), a.getModulo());
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getCause() +
                    " ::: Exception levée lors de l'utilisation de '" + getSymbole() + "'.");
        }

        return new Matrice(a.getModulo(), matrice);
    }

    abstract protected int op(int i, int j);

    public String getSymbole() {
        return symbole;
    }
}
