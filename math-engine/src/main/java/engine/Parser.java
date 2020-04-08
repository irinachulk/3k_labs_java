package engine;

import Interfaces.MathCommand;
import manager.CommandManager;

import java.text.NumberFormat;
import java.text.ParseException;

class Parser {
    private CommandManager manager = CommandManager.getInstance();
    /**
     * Парсит строку в модель выражения.
     * @param expr Строковое выражение
     * @param radix система счисления
     * @return модель выражения
     * @throws InvalidMathExpressionException
     */
    ExprModel parse(String expr, int radix) throws InvalidMathExpressionException {
        ExprModel parsedExpr = new ExprModel();
        expr = expr.replaceAll("\\s",""); // убираем пробелы из строки

        for (int i = 0; i < expr.length();) { // основной цикл по строке
            StringBuilder current = new StringBuilder(); // текущий собираемый из строки объект
            char ch = expr.charAt(i);

            // Числа (основния 2-10 + 16)
            if(isNumChars(ch)) {
                while (i < expr.length() && isNumChars(ch = expr.charAt(i))) { // добавляем в строку пока можно
                    current.append(ch);
                    i++;
                }

                parsedExpr.numbers.addLast(parseNumber(current.toString(), radix));
                parsedExpr.commands.addLast(manager.getNumber());
            }
            else
                // Функции
                if (isLower(ch)) {
                    while (i < expr.length() && isLower(ch = expr.charAt(i))) {
                        current.append(ch);
                        i++;
                    }

                    parsedExpr.commands.addLast(manager.getMathCommand(current.toString()));
                }
                else {
                    MathCommand currentCom = manager.getMathCommand(String.valueOf(ch));

                    // элементарные операции, префиксный минус, скобки
                    if (isSignleCharCommand(ch)) {
                        String prevch = (i != 0) ? String.valueOf(expr.charAt(i - 1)) : "";

                        // если это минус, то необходимо определить префиксный он или нет
                        if (ch == '-')
                            if ((i == 0 || manager.getMathCommand(prevch).getMathCommandType() == MathCommand.MCType.LEFTBR))
                                parsedExpr.commands.addLast(manager.getPrefixMinus());
                            else
                                parsedExpr.commands.addLast(manager.getMinus());
                        else // иначе просто пишем команду
                            parsedExpr.commands.addLast(currentCom);
                        i++;
                    }
                    else // если встретили что-то непонятное
                        throw new InvalidMathExpressionException();
                }
        }

        return parsedExpr;
    }

    /**
     * Разделитель дробных - запятая
     * @param num число-строка
     * @return число
     */
    private Double parseNumber(String num, int numberSystem) throws InvalidMathExpressionException {
        if (numberSystem == 10)
            try {
                return NumberFormat.getInstance().parse(num).doubleValue();
            } catch (ParseException e) {
                throw new InvalidMathExpressionException();
            }

        try {
            return (double)Long.parseLong(num, numberSystem);
        }
        catch (Exception e) {
            throw  new InvalidMathExpressionException();
        }
    }

    private boolean isSignleCharCommand(char ch) {
        return (ch == '+' || ch == '-' || ch == '*' ||
                ch == '/' || ch == '(' || ch == ')' ||
                ch == '!' || ch == '^' || ch == '%');
    }

    private boolean isLower(char ch) {
        return (ch >= 'a' && ch <= 'z');
    }

    private boolean isNumChars(char ch) {
        return ((ch >= 'A' && ch <= 'F') ||
                (ch >= '0' && ch <= '9') ||
                ch == ',');
    }
}
