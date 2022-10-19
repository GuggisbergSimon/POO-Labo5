package MatriceLabo5;

public class Minus extends Operator {
    @Override
    public String toString() {
        return "-";
    }

    @Override
    public int op(int i, int j) {
        return i - j;
    }
}
