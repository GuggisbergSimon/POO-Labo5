public class Matrice {
    private int[][] values;
    private final int m, n, modulo;

    public Matrice(int m, int n, int modulo, int val)
    {
        this.m = m;
        this.n = n;
        this.modulo = modulo;
        values = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                values[i][j] = val;
            }
        }
    }

    public Matrice(int m, int n, int modulo) {
        this.m = m;
        this.n = n;
        this.modulo = modulo;
        values = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                values[i][j] = (int) Math.round(Math.random() * (modulo - 1));
            }
        }
    }

    public Matrice(int modulo, int[][] values) {
        this.values = values;
        this.modulo = modulo;
        m = values.length;
        int tmp = values[0].length;
        for (int i = 0; i < values.length; i++) {
            if (values[i].length > tmp) {
                tmp = values[i].length;
            }
            for (int j = 0; j < values[i].length; j++) {
                this.values[i][j] %= modulo;
            }
        }
        n = tmp;
        //TODO fill the missing values if the array has multiple lengths
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (var line: values) {
            for (var val: line) {
                s.append(val);
            }
            s.append("\n");
        }
        return s.toString();
    }

    public int getM()
    {
        return m;
    }

    public int getN()
    {
        return n;
    }

    public int getModulo()
    {
        return modulo;
    }

    public int at(int i, int j)
    {
        return values[i][j];
    }
}
