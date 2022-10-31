package Operator;

public class Mult extends Operator {
    @Override
    public String toString() {
        return "x";
    }

    @Override
    public int op(int i, int j) {
        return i * j;
    }
}
