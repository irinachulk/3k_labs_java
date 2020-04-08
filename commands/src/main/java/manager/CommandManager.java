package manager;

import commands.Number;
import Interfaces.MathCommand;
import Interfaces.UICommand;
import commands.*;
import commands.nums.*;

import java.util.ArrayList;

public class CommandManager {
    private static final CommandManager manager = new CommandManager();

    public static CommandManager getInstance() {
        return manager;
    }


    private final ArrayList<UICommand>
            uiDecFuncList = new ArrayList<>(),
            uiBinFuncList = new ArrayList<>(),
            uiHexFuncList = new ArrayList<>(),
            uiBasicList = new ArrayList<>(),
            uiHexNumberList = new ArrayList<>(),
            uiDecNumberList = new ArrayList<>(),
            uiBinNumberList = new ArrayList<>();

    private final ArrayList<MathCommand> mathCommands = new ArrayList<>();

    // Functions
    private final Abs abs = new Abs();
    private final And and = new And();
    private final Arccos arccos = new Arccos();
    private final Arcctg arcctg = new Arcctg();
    private final Arcsin arcsin = new Arcsin();
    private final Arctg arctg = new Arctg();
    private final Cos cos = new Cos();
    private final Ctg ctg = new Ctg();
    private final DecSeparator separator = new DecSeparator();
    private final Div div = new Div();
    private final Fact  fact = new Fact();
    private final LeftBr leftBr = new LeftBr();
    private final Log log = new Log();
    private final Minus minus = new Minus();
    private final Mod mod = new Mod();
    private final Mul mul = new Mul();
    private final Number number = new Number();
    private final Or or = new Or();
    private final Plus plus = new Plus();
    private final Pow pow = new Pow();
    private final PrefixMinus prefixMinus = new PrefixMinus();
    private final RightBr rightBr = new RightBr();
    private final Sin sin = new Sin();
    private final Sqrt sqrt = new Sqrt();
    private final Tg tg = new Tg();
    private final Unknown unknown = new Unknown();
    private final Xor xor = new Xor();


    // numbers
    private final A a = new A();
    private final B b = new B();
    private final C c = new C();
    private final D d = new D();
    private final E e = new E();
    private final F f = new F();
    private final Zero zero = new Zero();
    private final One one = new One();
    private final Two two = new Two();
    private final Three three = new Three();
    private final Four four = new Four();
    private final Five five = new Five();
    private final Six six = new Six();
    private final Seven seven = new Seven();
    private final Eight eight = new Eight();
    private final Nine nine = new Nine();


    private CommandManager() {

        // TODO при добавлении новой команды ее нужно добавить сюда
        mathCommands.add(abs);
        mathCommands.add(and);
        mathCommands.add(arccos);
        mathCommands.add(arcctg);
        mathCommands.add(arcsin);
        mathCommands.add(arctg);
        mathCommands.add(cos);
        mathCommands.add(ctg);
        mathCommands.add(div);
        mathCommands.add(fact);
        mathCommands.add(leftBr);
        mathCommands.add(log);
        mathCommands.add(minus);
        mathCommands.add(mod);
        mathCommands.add(mul);
        mathCommands.add(or);
        mathCommands.add(plus);
        mathCommands.add(pow);
        mathCommands.add(rightBr);
        mathCommands.add(sin);
        mathCommands.add(sqrt);
        mathCommands.add(tg);
        mathCommands.add(xor);


        // NOTE порядок в массиве важен, отражается на UI

        // BIN
        uiBinFuncList.add(abs);
        uiBinFuncList.add(or);
        uiBinFuncList.add(xor);


        // DEC
        uiDecFuncList.add(abs);
        uiDecFuncList.add(arccos);
        uiDecFuncList.add(arcctg);
        uiDecFuncList.add(arcsin);
        uiDecFuncList.add(arctg);
        uiDecFuncList.add(cos);
        uiDecFuncList.add(ctg);
        uiDecFuncList.add(fact);
        uiDecFuncList.add(log);
        uiDecFuncList.add(pow);
        uiDecFuncList.add(sin);
        uiDecFuncList.add(sqrt);
        uiDecFuncList.add(tg);
        uiDecFuncList.add(separator);

        // HEX
        uiHexFuncList.add(abs);
        uiHexFuncList.add(or);
        uiHexFuncList.add(xor);


        // BASIC
        uiBasicList.add(minus);
        uiBasicList.add(plus);
        uiBasicList.add(mul);
        uiBasicList.add(div);
        uiBasicList.add(mod);
        uiBasicList.add(leftBr);
        uiBasicList.add(rightBr);



        // NUMBER HEX
        uiHexNumberList.add(a);
        uiHexNumberList.add(b);
        uiHexNumberList.add(c);
        uiHexNumberList.add(d);
        uiHexNumberList.add(e);
        uiHexNumberList.add(f);

        uiHexNumberList.add(seven);
        uiHexNumberList.add(eight);
        uiHexNumberList.add(nine);

        uiHexNumberList.add(four);
        uiHexNumberList.add(five);
        uiHexNumberList.add(six);

        uiHexNumberList.add(three);
        uiHexNumberList.add(two);
        uiHexNumberList.add(one);

        uiHexNumberList.add(zero);


        // NUMBER DEC
        uiDecNumberList.add(seven);
        uiDecNumberList.add(eight);
        uiDecNumberList.add(nine);

        uiDecNumberList.add(four);
        uiDecNumberList.add(five);
        uiDecNumberList.add(six);

        uiDecNumberList.add(three);
        uiDecNumberList.add(two);
        uiDecNumberList.add(one);

        uiDecNumberList.add(zero);

        // NUMBER BIN
        uiBinNumberList.add(zero);
        uiBinNumberList.add(one);
    }

    // вернуть одну из особых команд
    public MathCommand getNumber() {
        return number;
    }
    public MathCommand getMinus() {
        return minus;
    }
    public MathCommand getPrefixMinus() {
        return prefixMinus;
    }

    // без минуса (т.к. он бывает разный) и чисел
    public MathCommand getMathCommand(String com) {
        for (MathCommand i : mathCommands) {
            if (i.toString().equalsIgnoreCase(com))
                return i;
        }
        return unknown;
    }

    public ArrayList<UICommand> getUiCommandsList(UICommand.UCType utype, UICommand.RadixType radixType) {
        switch (utype) {
            case FUNC:
                return getListByRadix(radixType, uiBinFuncList, uiDecFuncList, uiHexFuncList);
            case BASIC:
                return uiBasicList;
            case NUM:
                return getListByRadix(radixType, uiBinNumberList, uiDecNumberList, uiHexNumberList);
            case UNKNOWN:
            default:
                return null;
        }
    }

    private ArrayList<UICommand> getListByRadix(
            UICommand.RadixType radixType,
            ArrayList<UICommand> l1,
            ArrayList<UICommand> l2,
            ArrayList<UICommand> l3
    ) {
        switch (radixType) {

            case BIN:
                return l1;
            case DEC:
                return l2;
            case HEX:
                return l3;
            case UNKNOWN:
            default:
                return null;
        }
    }
}
