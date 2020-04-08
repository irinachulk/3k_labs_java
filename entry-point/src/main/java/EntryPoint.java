import engine.InvalidMathExpressionException;
import engine.MathEngine;

import java.util.Scanner;

public class EntryPoint {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter string: ");
        String str = in.nextLine();
        MathEngine mathEngine=new MathEngine();
        try {
            System.out.println(mathEngine.solve(str,16));//radix-система счисления
        } catch (InvalidMathExpressionException e) {
            System.out.println("Uncorrected");
        }
    }
}
