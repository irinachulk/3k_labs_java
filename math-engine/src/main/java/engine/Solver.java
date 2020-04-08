package engine;

import Interfaces.MathCommand;
import manager.CommandManager;

import java.util.ArrayDeque;

class Solver {
    private CommandManager manager = CommandManager.getInstance();

    /**
        1. Обработка входного символа (слева направо)
                Если на вход подано число, оно помещается на вершину стека.
                Если на вход подан знак операции, то соответствующая операция выполняется над требуемым количеством значений,
                    извлечённых из стека, взятых в порядке добавления. Результат выполненной операции кладётся на вершину стека.
        2. Если входной набор символов обработан не полностью, перейти к шагу 1.
        3. После полной обработки входного набора символов результат вычисления выражения лежит на вершине стека.
     */
    Double solve(ExprModel rpn) throws InvalidMathExpressionException {
        ArrayDeque<Double> stack = new ArrayDeque<>();

        while (!rpn.commands.isEmpty()) {
            MathCommand firstInput = rpn.commands.pollFirst();

            Double x2, x1;

            switch (firstInput.getMathCommandType()) {
                case NUMBER:
                    stack.addLast(rpn.numbers.pollFirst());
                    break;
                case PREFIX_F:
                case POSTFIX_F:
                    stack.addLast(firstInput.solve(stack.pollLast()));
                    break;
                case BINARY_F:
                    x2 = stack.pollLast();
                    x1 = stack.pollLast();

                    try {
                        stack.addLast(firstInput.solve(x1, x2));
                    } catch (Exception e) {
                        throw new InvalidMathExpressionException();
                    }
                    break;

                case UNKNOWN:
                default:
                    throw new InvalidMathExpressionException();
            }
        }
        return stack.pollLast();
    }
}
