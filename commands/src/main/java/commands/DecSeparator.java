package commands;

import Interfaces.UICommand;

public class DecSeparator implements UICommand {

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
        return ",";
    }
}
