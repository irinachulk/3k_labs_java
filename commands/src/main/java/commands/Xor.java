package commands;

import Interfaces.MathCommand;
import Interfaces.UICommand;

public class Xor implements MathCommand, UICommand {
    @Override
    public int getPriority() {
        return Priority.P5;
    }

    @Override
    public MCType getMathCommandType() {
        return MCType.BINARY_F;
    }

    @Override
    public Double solve(double... a) {
        return (double)((long)a[0]^(long)a[1]);
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
        return "xor";
    }
}
