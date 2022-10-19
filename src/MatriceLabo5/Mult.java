package MatriceLabo5;

public class Mult extends Operator {
    @Override
    public String toString() {
        return "x";
    }

    @Override
    protected int op(int i, int j) {
        return i * j;
    }
}
