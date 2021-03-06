package commands;

import Interfaces.MathCommand;
import Interfaces.UICommand;
import static java.lang.Math.*;

public class Arcsin implements MathCommand, UICommand {
    @Override
    public int getPriority() {
        return Priority.P5;
    }

    @Override
    public MCType getMathCommandType() {
        return MCType.PREFIX_F;
    }

    @Override
    public Double solve(double... a) {
        return asin(a[0]);
    }

    @Override
    public String getLabel() {
        return toString();
    }

    @Override
    public String getText() {
        return toString() + "(";
    }

    @Override
    public String toString() {
        return "arcsin";
    }
}
