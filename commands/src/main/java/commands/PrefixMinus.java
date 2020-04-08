package commands;

import Interfaces.MathCommand;
import Interfaces.UICommand;

public class PrefixMinus implements MathCommand, UICommand {
    @Override
    public int getPriority() {
        return Priority.P4;
    }

    @Override
    public MCType getMathCommandType() {
        return MCType.PREFIX_F;
    }

    @Override
    public Double solve(double... a) {
        return -a[0];
    }

    @Override
    public String getLabel() {
        return toString();
    }

    @Override
    public String getText() {
        return toString();
    }
    @Override
    public String toString() {
        return "{prefix}-";
    }
}
