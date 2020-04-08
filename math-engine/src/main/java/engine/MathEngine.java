package engine;

import Interfaces.UICommand;

import java.math.BigInteger;

/**
 * Главный класс math-engine модуля
 */
public class MathEngine {
    private Parser parser = new Parser();
    private ReversePolishNotation rpn = new ReversePolishNotation();
    private Solver solver = new Solver();

    public String solve(String expr, int radix) throws InvalidMathExpressionException {
        Double result = solver.solve(rpn.toRPN(parser.parse(expr, radix)));

        return convertTo(result, radix);
    }

    private String convertTo(Double num, int radix) {
        if (radix == 10)
            return num.toString();

        return new BigInteger(((Long)num.longValue()).toString(), 10).toString(radix).toUpperCase();
    }
}
