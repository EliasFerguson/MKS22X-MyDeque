public class Calculator {
  public static double eval(String s) {
    return 1 + 1.0;
  }
  public static boolean isOperation(String input) {
    String[] operations = {"+", "-", "*", "/", "%"};
    for (int i = 0; i < operations.length; i++) {
      if (operations[i].equals(input)) return true;
    }
    return false;
  }
}
