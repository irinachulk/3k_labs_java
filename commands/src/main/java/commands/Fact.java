package commands;

import Interfaces.MathCommand;
import Interfaces.UICommand;

public class Fact implements MathCommand, UICommand {
    @Override
    public int getPriority() {
        return Priority.P4;
    }

    @Override
    public MCType getMathCommandType() {
        return MCType.POSTFIX_F;
    }

    private static double fact(double n){
        int result = 1;
        for (int i = 1; i <= n; i++)
            result = result*i;
        return result;
    }

    @Override
    public Double solve(double... a) {
        return fact(a[0]);
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
        return "!";
    }
}
