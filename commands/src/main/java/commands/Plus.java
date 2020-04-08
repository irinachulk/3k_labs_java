package commands;

import Interfaces.MathCommand;
import Interfaces.UICommand;

public class Plus implements MathCommand, UICommand {
    @Override
    public int getPriority() {
        return Priority.P2;
    }

    @Override
    public MCType getMathCommandType() {
        return MCType.BINARY_F;
    }

    @Override
    public Double solve(double... a) {
        return a[0]+a[1];
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
        return "+";
    }
}
