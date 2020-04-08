package Interfaces;


public interface MathCommand {
    int getPriority(); // приоритет команды для обратной польской записи
    MCType getMathCommandType ();
    Double solve(double ...a);

    class Priority {
        public static final int P1 = 1, // ()
                                P2 = 2, // + -
                                P3 = 3, // * / %
                                P4 = 4, // ^ ! префиксный минус
                                P5 = 5;  // functions
    }
    enum MCType {
        PREFIX_F,  // unary sin() etc
        POSTFIX_F, // unary x! etc
        BINARY_F,  // +, - etc
        LEFTBR,  // (
        RIGHTBR, // )
        NUMBER,  // any num
        UNKNOWN  // what?
    }
}
