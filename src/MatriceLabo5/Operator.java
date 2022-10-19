package MatriceLabo5;

abstract public class Operator {
    private final String SYMBOL;

    Operator(String s) {
        SYMBOL = s;
    }

    abstract protected int op(int i, int j);

    public String getSymbol() {
        return SYMBOL;
    }
}
