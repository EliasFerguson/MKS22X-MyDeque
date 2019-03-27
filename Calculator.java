import java.util.*;
public class Calculator {
  public static double eval(String s) {
    String[] tokens = s.split(" ");
    MyDeque<String> deque = new MyDeque<String>();
    for (String token: tokens) {
      if (!isOperation(token)) deque.addLast(token);
      else {
        Double a = Double.parseDouble(deque.removeLast());
        Double b = Double.parseDouble(deque.removeLast());
        double replacementVal = 0;
        if (token.equals("+")) replacementVal = b + a;
        else if (token.equals("-")) replacementVal = b - a;
        else if (token.equals("*")) replacementVal = b * a;
        else if (token.equals("/")) replacementVal = b / a;
        else if (token.equals("%")) replacementVal = b % a;
        String holder = replacementVal + "";
        deque.addLast(holder);
      }
    }
    return Double.parseDouble(deque.removeLast());
  }
  public static boolean isOperation(String input) {
    String[] operations = {"+", "-", "*", "/", "%"};
    for (int i = 0; i < operations.length; i++) {
      if (operations[i].equals(input)) return true;
    }
    return false;
  }
}
