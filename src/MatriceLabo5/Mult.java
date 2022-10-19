package MatriceLabo5;

public class Mult extends Operator {
    public Mult() {
        super("x");
    }

    @Override
    protected int op(int i, int j) {
        return i * j;
    }
}
