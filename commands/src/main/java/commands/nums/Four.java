package commands.nums;

import Interfaces.UICommand;

public class Four implements UICommand {

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
        return "4";
    }
}
