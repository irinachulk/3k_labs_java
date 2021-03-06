package commands;

import Interfaces.MathCommand;
import Interfaces.UICommand;

public class RightBr implements MathCommand, UICommand {
    @Override
    public int getPriority() {
        return Priority.P1;
    }

    @Override
    public MCType getMathCommandType() {
        return MCType.RIGHTBR;
    }

    @Override
    public Double solve(double... a) {
        return null;
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
        return ")";
    }
}
