package commands.nums;

import Interfaces.UICommand;

public class D implements UICommand {

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
        return "D";
    }
}
