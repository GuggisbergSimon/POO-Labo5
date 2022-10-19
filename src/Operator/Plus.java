package Operator;

public class Plus extends Operator
{
    public Plus() { super("+"); }

    @Override
    protected int op(int i, int j)
    {
        return i + j;
    }
}
