package engine;

import Interfaces.MathCommand;
import manager.CommandManager;

import java.util.ArrayDeque;

class ReversePolishNotation {
    private CommandManager manager = CommandManager.getInstance();

    ExprModel toRPN(ExprModel input) throws InvalidMathExpressionException {
        ArrayDeque<MathCommand> stack = new ArrayDeque<>();
        ExprModel result = new ExprModel();

        while (!input.commands.isEmpty()) {
            MathCommand firstInput = input.commands.pollFirst();

            switch (firstInput.getMathCommandType()){
                case NUMBER:
                    result.commands.addLast(firstInput);
                    result.numbers.addLast(input.numbers.pollFirst());
                    break;

                case POSTFIX_F:
                    result.commands.addLast(firstInput);
                    break;

                case PREFIX_F:
                case LEFTBR:
                    stack.addLast(firstInput);
                    break;

                case RIGHTBR:
                    try {
                        while (stack.peekLast().getMathCommandType() != MathCommand.MCType.LEFTBR)
                            result.commands.addLast(stack.pollLast());
                        stack.pollLast(); // удаляем открывающую скобку
                        //input.commands.pollFirst(); // удаляем закрывающую скобку
                    }
                    catch (Exception e) {
                        throw new InvalidMathExpressionException();
                    }
                    break;

                case BINARY_F:
                    while (!stack.isEmpty() && (stack.peekLast().getMathCommandType() == MathCommand.MCType.PREFIX_F ||
                            stack.peekLast().getPriority() > firstInput.getPriority() //||
                            /*(!stack.peekFirst().isRightAssociate() && stack.peekFirst().getPriority() == firstInput.getPriority())*/))
                        result.commands.addLast(stack.pollLast());
                    stack.addLast(firstInput);
                    break;

                case UNKNOWN:
                default:
                    throw new InvalidMathExpressionException();
            }
        }

        if (!input.numbers.isEmpty() || !input.commands.isEmpty()) // если где-то что-то осталось - ошибка
            throw new InvalidMathExpressionException();

        // выталкиваем из стека все оставшиеся команды
        while (!stack.isEmpty()) {
            MathCommand stacklast = stack.pollLast();
            // если остались скобки то ошибка
            if ( stacklast.getMathCommandType() == MathCommand.MCType.LEFTBR ||
                 stacklast.getMathCommandType() == MathCommand.MCType.RIGHTBR )
                throw new InvalidMathExpressionException();

            result.commands.addLast(stacklast);
        }

        return result;
    }
}
