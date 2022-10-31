package VectorialObject;

import Operator.Minus;
import Operator.Mult;
import Operator.Operator;
import Operator.Plus;

public class Matrice {
    private int[][] values;
    private final int m, n, modulo;

    public Matrice(int modulo, int m, int n) {
        if (m <= 0 || n <= 0) {
            throw new RuntimeException("in Matrice(int m, int n, " +
                    "int modulo) : m = " + m + ", n = " + n);
        }
        if (modulo < 0) {
            throw new RuntimeException(
                    "negative modulo : not supported");
        }
        this.m = m;
        this.n = n;
        this.modulo = modulo;
        values = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                values[i][j] = (int) Math.round(Math.random() *
                        (Math.abs(modulo) - 1));
            }
        }
    }

    public Matrice(int modulo, int[][] values) {
        this.values = values;
        this.modulo = modulo;
        m = values.length;
        if (m == 0) {
            throw new RuntimeException("in Matrice(int modulo, " +
                    "int[][] values) : m = " + m);
        }
        if (modulo < 0) {
            throw new RuntimeException(
                    "negative modulo : not supported");
        }
        int maxN = 0;
        //Gets the largest n
        for (int[] value : values) {
            if (value.length > maxN) {
                maxN = value.length;
            }
        }
        n = maxN;
        if (n == 0) {
            throw new RuntimeException("in Matrice(int modulo, " +
                    "int[][] values) : n = " + n);
        }

        //Setups the array and fills it with values floorModded
        this.values = new int[m][this.n];
        for (int i = 0; i < this.m; i++) {
            for (int j = 0; j < this.n; j++) {
                this.values[i][j] = j < values[i].length ?
                        Math.floorMod(values[i][j], modulo) : 0;
            }
        }
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (var line : values) {
            for (var val : line) {
                s.append(val);
            }
            s.append("\n");
        }
        return s.toString();
    }

    public int getM() {
        return m;
    }

    public int getN() {
        return n;
    }

    public int getModulo() {
        return modulo;
    }

    public int at(int i, int j) {
        return values[i][j];
    }

    private Matrice operate(Matrice a, Matrice b, Operator oper) {
        if (a.getModulo() != b.getModulo()) {
            throw new RuntimeException("Les modulos ne sont pas " +
                    "identiques dans les deux matrices");
        }

        int m = Math.max(a.getM(), b.getM());
        int n = Math.max(a.getN(), b.getN());

        int[][] matrice = new int[m][n];

        try {
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    int tmpA = i < a.getM() && j < a.getN() ?
                            a.at(i, j) : 0;
                    int tmpB = i < b.getM() && j < b.getN() ?
                            b.at(i, j) : 0;
                    matrice[i][j] = Math.floorMod(
                            oper.op(tmpA, tmpB), a.getModulo());
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getCause() +
                    " ::: Exception levée lors de l'utilisation " +
                    "de '" + oper.toString() + "'.");
        }

        return new Matrice(a.getModulo(), matrice);
    }

    public Matrice plus(Matrice other) {
        return operate(this, other, new Plus());
    }

    public Matrice minus(Matrice other) {
        return operate(this, other, new Minus());
    }

    public Matrice multiply(Matrice other) {
        return operate(this, other, new Mult());
    }
}
