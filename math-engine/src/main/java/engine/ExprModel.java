package engine;

import Interfaces.MathCommand;

import java.util.ArrayDeque;

/**
 * Представляет математическое выражение в виде очереди команд и чисел
 */
class ExprModel {
    private static final int DEF_SIZE = 50;

    ArrayDeque<MathCommand> commands;
    ArrayDeque<Double> numbers;

    ExprModel() {
        commands = new ArrayDeque<>(DEF_SIZE);
        numbers = new ArrayDeque<>(DEF_SIZE);
    }

    @Override
    public String toString() {
        return    "Commands: " + commands.toString() +
                "\nNumbers:  " + numbers.toString();
    }


}