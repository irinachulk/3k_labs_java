package commands;

import Interfaces.MathCommand;
import Interfaces.UICommand;

public class Number implements MathCommand, UICommand {
    @Override
    public int getPriority() {
        return 0;
    }

    @Override
    public MCType getMathCommandType() {
        return MCType.NUMBER;
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
        return "number";
    }
}
