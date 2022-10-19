public class Minus extends Operator
{
    public Minus() { super("-"); }

    @Override
    public Matrice operate(Matrice a, Matrice b) { return oper(a, b); }

    @Override
    protected int op(int i, int j) { return i - j; }
}
