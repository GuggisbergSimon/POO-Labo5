package Operator;

public class Minus extends Operator
{
    public Minus() { super("-"); }

    @Override
    protected int op(int i, int j) { return i - j; }
}
